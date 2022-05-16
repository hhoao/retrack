package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.rare_earth_track.admin.bean.RetUserDetails;
import com.rare_earth_track.admin.bean.RetUserParam;
import com.rare_earth_track.admin.bean.RetUserRegisterParam;
import com.rare_earth_track.admin.bean.RetUserUpdatePasswordParam;
import com.rare_earth_track.admin.service.*;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetUserMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserExample;
import com.rare_earth_track.security.util.JwtTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author hhoa
 **/
@Slf4j
@Service
@AllArgsConstructor
public class RetUserServiceImpl implements RetUserService {
    private final RetUserMapper userMapper;
    private final RetUserCacheService userCacheService;
    private final PasswordEncoder passwordEncoder;
    private final RetTokenCacheService tokenCacheService;
    private final JwtTokenService jwtTokenService;
    private final RetResourceService resourceService;
    private final RetMailService mailService;
    private final RetUserRoleRelationService userRoleRelationService;

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            RetUser retUser = getUserByName(username);

            if (retUser == null){
                throw  new UsernameNotFoundException("没有该用户");
            }

            if(!passwordEncoder.matches(password, retUser.getPassword())){
                throw new BadCredentialsException("密码错误");
            }
            if(!retUser.getStatus().equals(1)){
                throw new DisabledException("用户已被禁用");
            }
            List<RetResource> retResources = resourceService.getResourcesByUserId(retUser.getId());
            UserDetails userDetails = new RetUserDetails(retUser, retResources);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            RetRole role = userRoleRelationService.getRoleByUserId(retUser.getId());
            tokenCacheService.setKey(username, role.getName(), retResources);
            token = jwtTokenService.generateToken(username);
            log.info(userDetails.getUsername() + "登录成功");
        }catch (AuthenticationException e){
            log.warn("登录异常:{}", e.getMessage());
        }

        return token;
    }
    @Override
    public UserDetails getUserDetailsByUser(RetUser retUser){
        List<RetResource> retResources = resourceService.getResourcesByUserId(retUser.getId());
        return new RetUserDetails(retUser, retResources);
    }


    @Override
    public Boolean existsMail(String mail) {
        RetUserExample userExample = new RetUserExample();
        userExample.createCriteria().andEmailEqualTo(mail);
        List<RetUser> retUsers = userMapper.selectByExample(userExample);
        return retUsers != null && retUsers.size() > 0;
    }

    @Override
    public UserDetails getUserDetailsByUserName(String username) {
        UserDetails userDetails = null;
        RetUserExample userExample = new RetUserExample();
        userExample.createCriteria().andNameEqualTo(username);
        List<RetUser> retUsers = userMapper.selectByExample(userExample);
        if (retUsers != null && retUsers.size() > 0) {
            RetUser user = retUsers.get(0);
            userDetails = getUserDetailsByUser(user);
        }
        return userDetails;
    }

    @Override
    public RetUser register(RetUserRegisterParam registerParam) {
        RetUser user = new RetUser();
        BeanUtil.copyProperties(registerParam, user);
        RetUserExample userExample = new RetUserExample();
        userExample.createCriteria().andNameEqualTo(user.getName());
        List<RetUser> retUsers = userMapper.selectByExample(userExample);
        if (retUsers.size() > 0){
            Asserts.fail("用户已经存在, 注册失败");
        }
        user.setStatus(1);
        user.setCreateTime(new Date());
        userMapper.insert(user);
        return user;
    }
    @Override
    public String refreshToken(String token) {
        return jwtTokenService.refreshHeadToken(token);
    }

    @Override
    public void updatePasswordWithPhone(RetUserUpdatePasswordParam passwordParam){
        String phone = passwordParam.getPhoneOrEmail();
        RetUserExample userExample = new RetUserExample();
        RetUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<RetUser> retUsers = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(retUsers)){
            Asserts.fail("该账号不存在");
        }
        //验证验证码
        if(!userCacheService.getPhoneAuthCode(phone).equals(passwordParam.getAuthCode())){
            Asserts.fail("验证码错误");
        }
        RetUser retUser = retUsers.get(0);
        retUser.setPassword(passwordEncoder.encode(passwordParam.getPassword()));
        userMapper.updateByPrimaryKeySelective(retUser);
        tokenCacheService.delKey(retUser.getName());
        userCacheService.deleteUserByName(retUser.getName());
    }
    @Override
    public void updatePasswordWithMail(RetUserUpdatePasswordParam passwordParam){
        String email = passwordParam.getPhoneOrEmail();
        RetUserExample userExample = new RetUserExample();
        RetUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<RetUser> retUsers = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(retUsers)){
            Asserts.fail("该账号不存在");
        }
        //验证验证码
        if(!mailService.validateAuthCode(email, passwordParam.getAuthCode())){
            Asserts.fail("验证码错误");
        }
        RetUser retUser = retUsers.get(0);
        retUser.setPassword(passwordEncoder.encode(passwordParam.getPassword()));
        userMapper.updateByPrimaryKeySelective(retUser);
        userCacheService.deleteUserByName(retUser.getName());
        tokenCacheService.delKey(retUser.getName());
    }

    /**
     * 生成通用验证码
     * @return 验证码
     */
    public String generateCommonAuthCode(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    @Override
    public String generatePhoneAuthCode(String phone) {
        RetUserExample userExample = new RetUserExample();
        userExample.createCriteria().andPhoneEqualTo(phone);
        List<RetUser> retUsers = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(retUsers)){
            Asserts.fail("该手机号不存在");
        }
        String authCode = generateCommonAuthCode();
        userCacheService.setPhoneAuthCode(phone, authCode);
        return authCode;
    }

    @Override
    public RetUser getUserCacheByUserName(String username) {
        return userCacheService.getUserByName(username);
    }

    @Override
    public RetUser updateUser(RetUserParam userParam) {
        RetUser user = new RetUser();
        BeanUtil.copyProperties(userParam, user);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i == 0){
            Asserts.fail("用户更新失败");
        }
        return user;
    }

    @Override
    public List<RetUser> getAllUsers() {
        return userMapper.selectByExample(new RetUserExample());
    }

    @Override
    public RetUser getUserByName(String name){
        RetUser retUser = userCacheService.getUserByName(name);
        if (retUser == null) {
            RetUserExample retUserExample = new RetUserExample();
            retUserExample.createCriteria().andNameEqualTo(name);
            List<RetUser> retUsers = userMapper.selectByExample(retUserExample);
            if (retUsers != null && retUsers.size() > 0){
                retUser = retUsers.get(0);
                userCacheService.setUser(retUser);
            }
            else{
                throw new UsernameNotFoundException("用户名或者密码错误");
            }
        }
        return retUser;
    }

}
