package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.*;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetUserMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.mgb.model.RetUserExample;
import com.rare_earth_track.security.util.JwtTokenService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *
 * @author hhoa
 **/
@Slf4j
@Service
@AllArgsConstructor
@Data
public class RetUserServiceImpl implements RetUserService {
    private final RetUserMapper userMapper;
//    private final RetUserCacheService userCacheService;
    private final PasswordEncoder passwordEncoder;
    private final RetTokenCacheService tokenCacheService;
    private final JwtTokenService jwtTokenService;
    private final RetMailService mailService;
    private final RetRoleService roleService;
    private final RetUserAuthService userAuthService;
    private final RetMemberService memberService;

    @Override
    public String login(RetLoginParam loginParam) {
        String token = null;
        try {
            RetUserAuth userAuth = userAuthService.getUserAuth(loginParam.getIdentifier());
            if (!passwordEncoder.matches(loginParam.getPassword(), userAuth.getCredential())){
                Asserts.fail("密码错误");
            }

            RetUser user = userMapper.selectByPrimaryKey(userAuth.getUserId());
            if(!user.getStatus().equals(1)){
                throw new DisabledException("用户已被冻结");
            }
            RetUserAuth usernameAuth = userAuthService.getUserAuth(userAuth.getUserId(), IdentifyType.USERNAME);
            RetUserDetails userDetails = getUserDetails(usernameAuth.getIdentifier());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            tokenCacheService.setKey(userAuth.getIdentifier(), userDetails);
            token = jwtTokenService.generateToken(userAuth.getIdentifier());
            log.info(userDetails.getUsername() + "登录成功");
        }catch (AuthenticationException e){
            log.warn("登录异常:{}", e.getMessage());
        }

        return token;
    }
    @Override
    public void logout(String token){
        String username = jwtTokenService.getSubjectFromToken(token);
        clearUserStatus(username);
    }

    private void clearUserStatus(String userName){
        tokenCacheService.delKey(userName);
    }
    @Override
    public RetUserDetails getUserDetails(String username) {
        RetUserDetails userDetails = tokenCacheService.getKey(username);
        if (userDetails != null){
            return userDetails;
        }

        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.USERNAME, username);
        List<RetUserAuth> userAuths = userAuthService.getUserAuth(userAuth.getUserId());
        RetUser user = userMapper.selectByPrimaryKey(userAuth.getUserId());
        List<RetResource> userResources = getUserResources(userAuth.getUserId());
        List<RetFactoryJob> factoryJobsByUserId = memberService.getFactoryJobsByUserId(userAuth.getUserId());
        userDetails = new RetUserDetails(user, userAuths,  userResources, factoryJobsByUserId);
        tokenCacheService.setKey(username, userDetails);
        return userDetails;
    }

    private RetUser registerDefaultUser(){
        RetUser user = new RetUser();
        List<RetUser> retUsers = userMapper.selectByExample(new RetUserExample());
        long insertId =  (long)(retUsers.size()) + 1;
        user.setId(insertId);
        int insert = userMapper.insert(user);
        if (insert == 0){
            Asserts.fail("注册失败");
        }
        return userMapper.selectByPrimaryKey(insertId);
    }

    @Override
    public RetUser register(RetUserRegisterParam registerParam){
        return register(registerParam, IdentifyType.USERNAME);
    }

    @Override
    public RetUser register(RetUserRegisterParam registerParam, IdentifyType identifyType) {
        RetUser user;
        switch (identifyType){
            case EMAIL -> {
                if (StringUtils.hasLength(registerParam.getEmail()) && userAuthService.exists(identifyType, registerParam.getEmail())) {
                    Asserts.fail("该邮箱已经存在");
                }
                user = registerDefaultUser();
                userAuthService.bind(user.getId(), IdentifyType.EMAIL);
            }
            case PHONE -> {
                if (StringUtils.hasLength(registerParam.getPhone()) && userAuthService.exists( identifyType, registerParam.getPhone())) {
                    Asserts.fail("该手机号已经存在");
                }
                user = registerDefaultUser();
                userAuthService.bind(user.getId(), IdentifyType.PHONE);
            }
            default -> {
                if (StringUtils.hasLength(registerParam.getName()) && userAuthService.exists(identifyType, registerParam.getName())) {
                    Asserts.fail("该用户名已经存在");
                }
                user = registerDefaultUser();
                userAuthService.bind(user.getId(), IdentifyType.USERNAME);
            }
        }
        return user;
    }

    @Override
    public String refreshToken(String token) {
        String retToken = jwtTokenService.refreshHeadToken(token);
        if (retToken == null){
            Asserts.fail("token已经过期");
        }
        return retToken;
    }

    @Override
    public void updateUserPassword(RetUserAuthParam passwordParam){
        String identifier = passwordParam.getIdentifier();
        RetUserAuth usernameAuth = null;
        switch (passwordParam.getIdentifyType()) {
            case EMAIL -> {
                if (!userAuthService.exists(IdentifyType.EMAIL, identifier)){
                    Asserts.fail("该邮箱不存在");
                }
                if(!mailService.validateMessage(identifier, passwordParam.getAuthCode(), MailType.USER_REGISTER)){
                    Asserts.fail("验证码错误");
                }
            }
            case PHONE -> {
                //...
            }
            case USERNAME -> {
                if (passwordParam.getNewPassword() != null) {
                    usernameAuth = userAuthService.getUserAuth(passwordParam.getIdentifyType(), passwordParam.getIdentifier());
                    if (passwordParam.getOldPassword().equals(usernameAuth.getCredential())) {
                        Asserts.fail("密码错误");
                    } else {
                        usernameAuth.setCredential(passwordParam.getNewPassword());
                        userAuthService.updateCredential(usernameAuth.getUserId(), usernameAuth.getCredential());
                    }
                }
            }
            default -> Asserts.fail("没有该验证方式");
        }
        if (usernameAuth == null) {
            usernameAuth = userAuthService.getUserAuth(passwordParam.getIdentifyType(), identifier);
        }
        RetUserAuth userNameAuth = userAuthService.getUserAuth(usernameAuth.getUserId(), IdentifyType.USERNAME);
        userAuthService.updateCredential(passwordParam);
        //刷新用户登陆状态
        clearUserStatus(userNameAuth.getIdentifier());
    }

    @Override
    public RetUser getUserCacheByUserName(String username) {
        RetUserDetails key = tokenCacheService.getKey(username);
        return key.getRetUser();
    }

    @Override
    public void updateUser(RetUser newUser) {
        RetUser oldUser = userMapper.selectByPrimaryKey(newUser.getId());
        if (oldUser == null){
            Asserts.fail("没有该用户");
        }
        BeanUtil.copyProperties(newUser, oldUser);
        int i = userMapper.updateByPrimaryKey(oldUser);
        if (i == 0){
            Asserts.fail("用户更新失败");
        }
        RetUserAuth userAuth = userAuthService.getUserAuth(newUser.getId(), IdentifyType.USERNAME);
        //刷新用户token，使用户需要重新登陆
        clearUserStatus(userAuth.getIdentifier());
    }

    @Override
    public void sendMailAuthCode(String mail) {
        boolean exists = userAuthService.exists(IdentifyType.EMAIL, mail);
        if (!exists){
            Asserts.fail("没有该邮箱");
        }
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.EMAIL, mail);
        RetUserAuth usernameAuth = userAuthService.getUserAuth(userAuth.getUserId(), IdentifyType.USERNAME);
        RetUserDetails userDetails = getUserDetails(usernameAuth.getIdentifier());
        mailService.sendUserRegisterMail(mail, userDetails);
    }

    @Override
    public List<RetFactoryJob> getFactoryJobsByUserName(String username) {
        RetUser userByName = getUserByName(username);
        return memberService.getFactoryJobsByUserId(userByName.getId());
    }

    @Override
    public void deleteUserByUserId(Long userId) {
        userAuthService.deleteAllUserAuth(userId);
        int i = userMapper.deleteByPrimaryKey(userId);
        if (i == 0){
            Asserts.fail("删除失败");
        }
    }
    @Override
    public List<RetUser> getUser(RetUser user) {
        RetUserExample userExample = new RetUserExample();
        userExample.createCriteria().
                andAddressEqualTo(user.getAddress()).
                andAgeEqualTo(user.getAge()).
                andBirthdayEqualTo(user.getBirthday()).
                andIdEqualTo(user.getId()).
                andJobEqualTo(user.getJob()).
                andNicknameEqualTo(user.getNickname()).
                andStatusEqualTo(user.getStatus()).
                andSexEqualTo(user.getSex()).
                andJobEqualTo(user.getJob()).
                andRoleIdEqualTo(user.getRoleId());
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<RetUser> getAllUsers() {
        return userMapper.selectByExample(new RetUserExample());
    }

    @Override
    public List<RetUser> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return getAllUsers();
    }

    @Override
    public RetUser getUserByName(String name){
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.USERNAME, name);
        Long userId = userAuth.getUserId();
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<RetResource> getUserResources(Long userId){
        RetUser user = userMapper.selectByPrimaryKey(userId);
        return roleService.getRoleResources(user.getRoleId());
    }

    @Override
    public void updateUserRole(Long userId, Long roleId){
        RetUser user = userMapper.selectByPrimaryKey(userId);
        if (user == null){
            Asserts.fail("没有该用户id");
        }
        user.setRoleId(roleId);
        int i = userMapper.updateByPrimaryKey(user);
        if (i == 0){
            Asserts.fail("修改用户"+userId+"角色"+roleId+"失败");
        }
    }

    @Override
    public RetUserAuth getUserEmailByUsername(String username) {
        RetUserAuth usernameAuth = userAuthService.getUserAuth(IdentifyType.USERNAME, username);
        return userAuthService.getUserAuth(usernameAuth.getUserId(), IdentifyType.EMAIL);
    }

    @Override
    public void updateUser(RetUser user, String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.USERNAME, username);
        user.setId(userAuth.getUserId());
        int i = userMapper.updateByPrimaryKey(user);
        if (i == 0){
            Asserts.fail("更新失败");
        }
    }

    @Override
    public void updateUserAuth(Long userId, IdentifyType authType, RetUserAuth userAuth) {
        userAuth.setUserId(userId);
        userAuth.setIdentityType(authType.value());
        userAuthService.updateUserAuth(userAuth);
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
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.USERNAME, username);
        userAuth.setIdentifier(newUsername);
        userAuthService.updateUserAuth(userAuth);
    }

}
