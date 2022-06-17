package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.*;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetUserMapper;
import com.rare_earth_track.mgb.model.*;
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
    private final RetTokenCacheService tokenCacheService;

    private final JwtTokenService jwtTokenService;
    private final RetMailService mailService;
    private final RetRoleService roleService;
    private final RetUserAuthService userAuthService;
    private final RetMemberService memberService;

    @Override
    public boolean hasLogin(String username) {
        return tokenCacheService.hasKey(username);
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
            tokenCacheService.setKey(usernameAuth.getIdentifier(), userDetails);
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
        tokenCacheService.delKey(userName);
    }

    @Override
    public RetUserDetails getUserDetails(String username) {
        //使用了缓存
        RetUserDetails userDetails = tokenCacheService.getKey(username);
        if (userDetails != null) {
            return userDetails;
        }
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        List<RetUserAuth> userAuths = userAuthService.getUserAuth(userAuth.getUserId());
        RetUser user = userMapper.selectByPrimaryKey(userAuth.getUserId());
        List<RetResource> userResources = getUserResources(userAuth.getUserId());
        List<RetFactoryJob> factoryJobsByUserId = memberService.getFactoryJobsByUserId(userAuth.getUserId());
        userDetails = new RetUserDetails(user, userAuths, userResources, factoryJobsByUserId);
        tokenCacheService.setKey(username, userDetails);
        return userDetails;
    }

    private Long registerDefaultUser() {
        RetUser user = new RetUser();
        user.setRoleId(4L);
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
        boolean b = tokenCacheService.hasKey(username);
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
//        RetUserAuth userNameAuth = userAuthService.getUserAuth(usernameAuth.getUserId(), IdentifyType.username);
//        userAuthService.updateCredential(passwordParam);
        //刷新用户登陆状态
        clearUserStatus(usernameAuth.getIdentifier());
    }

    @Override
    public RetUser getUserByIdentifier(String identifier) {
        return getUserDetailByIdentifier(identifier).getRetUser();
    }

    @Override
    public RetUser getUserByUsername(String username) {
        RetUserDetails userDetails = getUserDetails(username);
        return userDetails.getRetUser();
    }

    @Override
    public RetUserDetails getUserDetailByIdentifier(String identifier) {
        RetUserAuth userAuth = userAuthService.getUserAuth(identifier);
        RetUserAuth usernameAuth = userAuthService.getUserAuth(IdentifyType.username, userAuth.getIdentifier());
        return getUserDetails(usernameAuth.getIdentifier());
    }

    @Override
    public RetUser getUserByIndentifier(String identifier) {
        RetUserDetails userDetailByIdentifier = getUserDetailByIdentifier(identifier);
        return userDetailByIdentifier.getRetUser();
    }

    @Override
    public void updateUser(RetUser newUser) {
        RetUser user = userMapper.selectByPrimaryKey(newUser.getId());
        if (newUser.getRoleId() == null) {
            newUser.setRoleId(user.getRoleId());
        }
        int i = userMapper.updateByPrimaryKeySelective(newUser);
        if (i == 0) {
            Asserts.fail("用户更新失败");
        }
        RetUserAuth userAuth = userAuthService.getUserAuth(newUser.getId(), IdentifyType.username);
        //刷新用户token，使用户需要重新登陆
        clearUserStatus(userAuth.getIdentifier());
    }

    @Override
    public void sendUserRegisterMail(String mail) {
        mailService.sendUserRegisterMail(mail);
    }

    @Override
    public List<RetFactoryJob> getFactoryJobsByUserName(String username) {
        RetUserDetails userDetails = getUserDetails(username);
        return userDetails.getFactoryJobs();
    }

    @Override
    public RetUser getUser(Long userId) {
        RetUser user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            Asserts.fail("没有该用户");
        }
        return user;
    }

    /**
     * 删除相关引用
     * @param userId 用户id
     */
    private void deleteReference(Long userId){
        userAuthService.deleteAllUserAuth(userId);
        memberService.deleteMembersByUserId(userId);
    }

    @Override
    public void deleteUserByUserId(Long userId) {
        RetUserAuth userAuth = userAuthService.getUserAuth(userId, IdentifyType.username);
        clearUserStatus(userAuth.getIdentifier());
        deleteReference(userId);
        int i = userMapper.deleteByPrimaryKey(userId);
        if (i == 0) {
            Asserts.fail("删除失败");
        }

    }

    @Override
    public void deleteUsers(RetUser user){
        List<RetUser> users = getUser(user);
        for (RetUser delUser : users){
            deleteReference(delUser.getId());
            userMapper.deleteByPrimaryKey(delUser.getId());
        }
    }

    /**
     * 获取userExample
     * @param user user
     * @return RetUserExample
     */
    private RetUserExample getUserExample(RetUser user){
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
        if (user.getRoleId() != null)
            criteria.andRoleIdEqualTo(user.getRoleId());
        return userExample;
    }
    @Override
    public List<RetUser> getUser(RetUser user) {
        RetUserExample userExample = getUserExample(user);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<RetUser> getAllUsers() {
        return userMapper.selectByExample(new RetUserExample());
    }

    @Override
    public List<RetUser> list(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return getAllUsers();
    }

    @Override
    public RetUser getUserByName(String name) {
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, name);
        Long userId = userAuth.getUserId();
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<RetResource> getUserResources(Long userId) {
        RetUser user = userMapper.selectByPrimaryKey(userId);
        return roleService.getRoleResources(user.getRoleId());
    }

    @Override
    public void updateUserRole(Long userId, Long roleId) {
        RetUser user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            Asserts.fail("没有该用户id");
        }
        user.setRoleId(roleId);
        int i = userMapper.updateByPrimaryKey(user);
        if (i == 0) {
            Asserts.fail("修改用户" + userId + "角色" + roleId + "失败");
        }
    }

    @Override
    public RetUserAuth getUserEmailByUsername(String username) {
        RetUserAuth usernameAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        return userAuthService.getUserAuth(usernameAuth.getUserId(), IdentifyType.email);
    }

    @Override
    public void updateUser(RetUser user, String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        user.setId(userAuth.getUserId());
        int i = userMapper.updateByPrimaryKey(user);
        if (i == 0) {
            Asserts.fail("更新失败");
        }
    }

    @Override
    public void updateUserAuth(Long userId, IdentifyType authType, RetUserAuthParam adminUserAuthParam) {
        RetUserAuth usernameAuth = userAuthService.getUserAuth(userId, IdentifyType.username);
        userAuthService.updateUserAuth(userId, authType, adminUserAuthParam);
        clearUserStatus(usernameAuth.getIdentifier());
    }

    @Override
    public void unbindUserAuth(IdentifyType authType, String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        Long userId = userAuthService.getUserIdByUserName(username);
        userAuthService.deleteUserAuth(userId, authType);
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
    public RetUser getUserByAuthorization(String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        return getUserByName(username);
    }
    @Override
    public List<RetMenu> getMenusByAuthorization(String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        RetUser userByName = getUserByName(username);
        return roleService.getMenus(userByName.getRoleId());
    }

    @Override
    public List<RetUser> queryUsers(RetUser user, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return getUser(user);
    }

    @Override
    public Map<String, String> getUserAuths(Long userId) {
        List<RetUserAuth> userAuths = userAuthService.getUserAuth(userId);
        Map<String, String> authMap = new HashMap<>();
        for (RetUserAuth userAuth : userAuths){
            authMap.put(userAuth.getIdentityType(), userAuth.getIdentifier());
        }
        return authMap;
    }

    @Override
    public void deleteUserAuth(Long userId, IdentifyType identifyType) {
        RetUserAuth userAuth = userAuthService.getUserAuth(userId, IdentifyType.username);
        userAuthService.deleteUserAuth(userId, identifyType);
        clearUserStatus(userAuth.getIdentifier());
    }
}
