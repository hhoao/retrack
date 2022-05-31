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
            RetUserAuth usernameAuth = userAuthService.getUserAuth(userAuth.getUserId(), IdentifyType.username);
            RetUserDetails userDetails = getUserDetails(usernameAuth.getIdentifier());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            tokenCacheService.setKey(usernameAuth.getIdentifier(), userDetails);
            token = jwtTokenService.generateToken(usernameAuth.getIdentifier());
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
        //使用了缓存
        RetUserDetails userDetails = tokenCacheService.getKey(username);
        if (userDetails != null){
            return userDetails;
        }
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        List<RetUserAuth> userAuths = userAuthService.getUserAuth(userAuth.getUserId());
        RetUser user = userMapper.selectByPrimaryKey(userAuth.getUserId());
        List<RetResource> userResources = getUserResources(userAuth.getUserId());
        List<RetFactoryJob> factoryJobsByUserId = memberService.getFactoryJobsByUserId(userAuth.getUserId());
        userDetails = new RetUserDetails(user, userAuths,  userResources, factoryJobsByUserId);
        tokenCacheService.setKey(username, userDetails);
        return userDetails;
    }

    private Long registerDefaultUser(){
        RetUser user = new RetUser();
        user.setRoleId(4L);
        int insert = userMapper.insert(user);
        if (insert == 0){
            Asserts.fail("注册失败");
        }
        return user.getId();
    }

    @Override
    public void register(RetUserRegisterParam registerParam) {
        IdentifyType identifyType = registerParam.getIdentifyType();
        String identifier = registerParam.getIdentifier();
        if (StringUtils.hasLength(identifier) && userAuthService.exists(identifyType, identifier)) {
            Asserts.fail("该认证方式已存在");
        }
        if (registerParam.getIdentifyType() == IdentifyType.email){
            boolean b = mailService.validateMessage(registerParam.getIdentifier(), registerParam.getAuthCode(), MailType.USER_REGISTER);
            if (!b){
                Asserts.fail("验证码错误");
            }
        }else{
            Asserts.fail("没有开通该认证方式");
            //...手机号注册没有开放
        }
        Long userId = registerDefaultUser();
        userAuthService.bind(userId, identifier, identifyType);
    }

    @Override
    public String refreshToken(String authorization) {
        String tokenFromAuthorization = jwtTokenService.getTokenFromAuthorization(authorization);
        String retToken = jwtTokenService.refreshHeadToken(tokenFromAuthorization);
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
            case email -> {
                if (!userAuthService.exists(IdentifyType.email, identifier)){
                    Asserts.fail("该邮箱不存在");
                }
                if(!mailService.validateMessage(identifier, passwordParam.getAuthCode(), MailType.USER_REGISTER)){
                    Asserts.fail("验证码错误");
                }
            }
            case phone -> {
                //...
            }
            case username -> {
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
        RetUserAuth userNameAuth = userAuthService.getUserAuth(usernameAuth.getUserId(), IdentifyType.username);
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
    public void deleteUserByUserId(Long userId) {
        userAuthService.deleteAllUserAuth(userId);
        memberService.deleteMembers(userId);
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
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, name);
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
        RetUserAuth usernameAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        return userAuthService.getUserAuth(usernameAuth.getUserId(), IdentifyType.email);
    }

    @Override
    public void updateUser(RetUser user, String authorization) {
        String username = jwtTokenService.getSubjectFromAuthorization(authorization);
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        user.setId(userAuth.getUserId());
        int i = userMapper.updateByPrimaryKey(user);
        if (i == 0){
            Asserts.fail("更新失败");
        }
    }

    @Override
    public void updateUserAuth(Long userId, IdentifyType authType, RetAdminUserAuthParam adminUserAuthParam) {
        RetUserAuth userAuth = new RetUserAuth();
        userAuth.setUserId(userId);
        userAuth.setIdentityType(authType.value());
        userAuth.setCredential(adminUserAuthParam.getCredential());
        userAuth.setIdentifier(adminUserAuthParam.getIdentifier());
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
        RetUserAuth userAuth = userAuthService.getUserAuth(IdentifyType.username, username);
        userAuth.setIdentifier(newUsername);
        userAuthService.updateUserAuth(userAuth);
    }

}
