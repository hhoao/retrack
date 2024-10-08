package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetUserMapper;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.mgb.model.RetUserExample;
import com.rare_earth_track.portal.bean.*;
import com.rare_earth_track.portal.service.*;
import com.rare_earth_track.security.util.JwtTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Ret user service.
 *
 * @author hhoa
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RetUserServiceImpl implements RetUserService {
    private final RetUserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RetUserCacheService userCacheService;

    private final JwtTokenService jwtTokenService;
    private final RetMailService mailService;
    private final RetUserAuthService userAuthService;
    private final RetMemberService memberService;

    @Override
    public boolean hasLogin(String username) {
        return userCacheService.hasKey(username);
    }

    @Override
    public String login(RetLoginParam loginParam) {
        String token = null;
        try {
            RetUserAuth userAuth = userAuthService.getUserAuth(loginParam.getIdentifier());
            if (!passwordEncoder.matches(loginParam.getPassword(), userAuth.getCredential())) {
                Asserts.fail("密码错误");
            }

            RetUser user = userMapper.selectByPrimaryKey(userAuth.getUserId());
            if (!user.getStatus().equals(1)) {
                throw new DisabledException("用户已被冻结");
            }
            RetUserAuth usernameAuth = userAuthService.getUserAuth(userAuth.getUserId(), IdentifyType.username);
            RetUserDetails userDetails = getUserDetails(usernameAuth.getIdentifier());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            userCacheService.setKey(usernameAuth.getIdentifier(), userDetails);
            token = jwtTokenService.generateToken(usernameAuth.getIdentifier());
            log.info(userDetails.getUsername() + "登录成功");
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }

        return token;
    }

    @Override
    public void logout(String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        clearUserStatus(username);
    }

    private void clearUserStatus(String userName) {
        userCacheService.delKey(userName);
    }

    private RetUserDetails getUserDetailsNoCache(String username) {
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        List<RetUserAuth> userAuths = userAuthService.getUserAuth(userAuth.getUserId());
        RetUser user = userMapper.selectByPrimaryKey(userAuth.getUserId());
        List<RetFactoryJob> factoryJobsByUserId = memberService.getFactoryJobsByUserId(userAuth.getUserId());
        return new RetUserDetails(user, userAuths, factoryJobsByUserId);
    }

    private void refreshUserDetailsCache(String username) {
        RetUserDetails userDetailsNoCache = getUserDetailsNoCache(username);
        userCacheService.setKey(username, userDetailsNoCache);
    }

    @Override
    public RetUserDetails getUserDetails(String username) {
        //使用了缓存
        RetUserDetails userDetails = userCacheService.getKey(username);
        if (userDetails != null) {
            return userDetails;
        }
        userDetails = getUserDetailsNoCache(username);
        refreshUserDetailsCache(username);
        return userDetails;
    }

    private Long registerDefaultUser() {
        RetUser user = new RetUser();
        int insert = userMapper.insert(user);
        if (insert == 0) {
            Asserts.fail("注册失败");
        }
        return user.getId();
    }

    @Override
    public Long register(RetUserRegisterParam registerParam) {
        IdentifyType identifyType = registerParam.getIdentifyType();
        String identifier = registerParam.getIdentifier();
        if (StringUtils.hasLength(identifier) && userAuthService.exists(identifyType, identifier)) {
            Asserts.fail("该认证方式已存在");
        }
        if (registerParam.getIdentifyType() == IdentifyType.email) {
            boolean b = mailService.validateMessage(registerParam.getIdentifier(), registerParam.getAuthCode(), MailType.USER_REGISTER);
            if (!b) {
                Asserts.fail("验证码错误");
            }
        } else {
            Asserts.fail("没有开通该认证方式");
            //...手机号注册没有开放
        }
        Long userId = registerDefaultUser();
        userAuthService.bind(userId, identifier, identifyType);
        return userId;
    }

    @Override
    public String refreshToken(String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        boolean b = userCacheService.hasKey(username);
        if (!b) {
            Asserts.fail("用户未登陆");
        }
        String tokenFromAuthorization = jwtTokenService.getTokenFromAuthorization(authorization);
        String retToken = jwtTokenService.refreshHeadToken(tokenFromAuthorization);
        if (retToken == null) {
            Asserts.fail("token已经过期");
        }
        return retToken;
    }

    @Override
    public void updateUserPassword(RetUpdateUserPasswordParam passwordParam) {
        String identifier = passwordParam.getIdentifier();
        RetUserAuth usernameAuth = null;
        switch (passwordParam.getIdentifyType()) {
            case email -> {
                if (!userAuthService.exists(IdentifyType.email, identifier)) {
                    Asserts.fail("该邮箱不存在");
                }
                if (!mailService.validateMessage(identifier, passwordParam.getAuthCode(), MailType.UPDATE_PASSWORD)) {
                    Asserts.fail("验证码错误");
                }
            }
            case phone -> {
                //...
            }
            case username -> {
                if (passwordParam.getNewPassword() != null) {
                    RetUserAuth userAuth = userAuthService.getUserAuth(passwordParam.getIdentifier());
                    if (!userAuth.getIdentityType().equals(passwordParam.getIdentifyType().value())) {
                        usernameAuth = userAuthService.getUserAuth(userAuth.getUserId(), IdentifyType.username);
                    } else {
                        usernameAuth = userAuth;
                    }
                }
            }
            default -> Asserts.fail("没有该验证方式");
        }
        if (usernameAuth == null) {
            usernameAuth = userAuthService.getUserAuth(passwordParam.getIdentifyType(), identifier);
        }
        if (passwordParam.getOldPassword().equals(usernameAuth.getCredential())) {
            Asserts.fail("密码错误");
        } else {
            usernameAuth.setCredential(passwordParam.getNewPassword());
            userAuthService.updateCredential(usernameAuth.getUserId(), usernameAuth.getCredential());
        }
        //刷新用户登陆状态
        clearUserStatus(usernameAuth.getIdentifier());
    }


    @Override
    public RetUser getUserByUsername(String username) {
        RetUserDetails userDetails = getUserDetails(username);
        return userDetails.getRetUser();
    }


    @Override
    public void sendUserRegisterMail(String mail) {
        mailService.sendUserRegisterMail(mail);
    }
    /**
     * 获取userExample
     *
     * @param user user
     * @return RetUserExample
     */
    private RetUserExample getUserExample(RetUser user) {
        RetUserExample userExample = new RetUserExample();
        RetUserExample.Criteria criteria = userExample.createCriteria();
        if (user.getAddress() != null)
            criteria.andAddressEqualTo(user.getAddress());
        if (user.getAge() != null)
            criteria.andAgeEqualTo(user.getAge());
        if (user.getBirthday() != null)
            criteria.andBirthdayEqualTo(user.getBirthday());
        if (user.getId() != null)
            criteria.andIdEqualTo(user.getId());
        if (user.getJob() != null)
            criteria.andJobEqualTo(user.getJob());
        if (user.getNickname() != null)
            criteria.andNicknameEqualTo(user.getNickname());
        if (user.getStatus() != null)
            criteria.andStatusEqualTo(user.getStatus());
        if (user.getSex() != null)
            criteria.andSexEqualTo(user.getSex());
        if (user.getJob() != null)
            criteria.andJobEqualTo(user.getJob());
        return userExample;
    }


    @Override
    public RetUserAuth getUserEmailByUsername(String username) {
        RetUserAuth usernameAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        return userAuthService.getUserAuth(usernameAuth.getUserId(), IdentifyType.email);
    }

    private void updateUser(RetUser newUser) {
        int i = userMapper.updateByPrimaryKeySelective(newUser);
        if (i == 0) {
            Asserts.fail("用户更新失败");
        }
        RetUserAuth userAuth = userAuthService.getUserAuth(newUser.getId(), IdentifyType.username);
        //刷新用户token，使用户需要重新登陆
        if (newUser.getStatus() != null) {
            clearUserStatus(userAuth.getIdentifier());
        }
        refreshUserDetailsCache(userAuth.getIdentifier());
    }

    @Override
    public void updateUser(RetUser newUser, String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        newUser.setId(userAuth.getUserId());
        updateUser(newUser);
    }

    @Override
    public void unbindUserAuth(IdentifyType authType, String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        Long userId = userAuthService.getUserIdByUserName(username);
        userAuthService.deleteUserAuth(userId, authType);
        clearUserStatus(username);
    }

    @Override
    public void updateUsername(String newUsername, String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        RetUserAuthParam userAuthParam = new RetUserAuthParam();
        userAuthParam.setIdentifier(newUsername);
        IdentifyType identifyType = Enum.valueOf(IdentifyType.class, userAuth.getIdentityType());
        userAuthService.updateUserAuth(userAuth.getUserId(), identifyType, userAuthParam);
        clearUserStatus(username);
    }

    @Override
    public Map<String, String> getUserAuths(Long userId) {
        List<RetUserAuth> userAuths = userAuthService.getUserAuth(userId);
        Map<String, String> authMap = new HashMap<>();
        for (RetUserAuth userAuth : userAuths) {
            authMap.put(userAuth.getIdentityType(), userAuth.getIdentifier());
        }
        return authMap;
    }

    @Override
    public void bindEmail(String email, String authCode, String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        if (!mailService.existMessage(email, MailType.BIND_EMAIL)) {
            Asserts.fail("没有该验证码");
        }
        RetUserAuth userAuth = userAuthService.getUserAuth(username);
        userAuthService.bind(userAuth.getUserId(), email, IdentifyType.email);
    }

    @Override
    public void bindPhone(String phone, String authCode, String authorization) {
        //没有实现
    }

    @Override
    public void sendBindEmailCode(String email, String authorization) {
        if (userAuthService.exists(IdentifyType.email, email)) {
            Asserts.fail("该邮箱已被使用");
        }
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        RetUserAuth userAuth = userAuthService.getUserAuth(username);
        if (userAuthService.exists(userAuth.getUserId(), IdentifyType.email)) {
            Asserts.fail("该用户名已绑定邮箱");
        }
        mailService.sendBindMail(email);
    }

    @Override
    public Map<String, String> getVerifiedUserAuths(String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        Long userIdByUserName = userAuthService.getUserIdByUserName(username);
        return getUserAuths(userIdByUserName);
    }

    @Override
    public RetUser getUserByAuthorization(String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        return this.getUserByUsername(username);
    }
}
