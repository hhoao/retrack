package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.*;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetUserMapper;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.mgb.model.RetUserExample;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private final RetUserAuthService userAuthService;
    private final RetMemberService memberService;

    @Override
    public RetUser getUserByIdentifier(String identifier) {
        RetUserAuth userAuth = userAuthService.getUserAuth(identifier);
        return getUser(userAuth.getUserId());
    }

    @Override
    public RetUser getUserByUsername(String username) {
        RetUserAuth userAuth = userAuthService.getUserAuth(username);
        return getUser(userAuth.getUserId());
    }


    @Override
    public void updateUser(RetUser newUser) {
        int i = userMapper.updateByPrimaryKeySelective(newUser);
        if (i == 0) {
            Asserts.fail("用户更新失败");
        }
    }

    @Override
    public List<RetFactoryJob> getFactoryJobsByUserName(String username) {
        RetUser userByUsername = getUserByUsername(username);
        return memberService.getFactoryJobsByUserId(userByUsername.getId());
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
        deleteReference(userId);
        int i = userMapper.deleteByPrimaryKey(userId);
        if (i == 0) {
            Asserts.fail("删除失败");
        }

    }

    @Override
    public void deleteUsers(RetUser user){
        List<RetUser> users = getUsers(user);
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
        if (user != null) {
            RetUserExample.Criteria criteria = userExample.createCriteria();
            if (StringUtils.hasLength(user.getAddress()))
                criteria.andAddressEqualTo(user.getAddress());
            if (user.getAge() != null)
                criteria.andAgeEqualTo(user.getAge());
            if (user.getBirthday() != null)
                criteria.andBirthdayEqualTo(user.getBirthday());
            if (user.getId() != null)
                criteria.andIdEqualTo(user.getId());
            if (StringUtils.hasLength(user.getNickname()))
                criteria.andNicknameEqualTo(user.getNickname());
            if (user.getStatus() != null)
                criteria.andStatusEqualTo(user.getStatus());
            if (user.getSex() != null)
                criteria.andSexEqualTo(user.getSex());
            if (StringUtils.hasLength(user.getJob()))
                criteria.andJobEqualTo(user.getJob());
        }
        return userExample;
    }
    @Override
    public List<RetUser> getUsers(RetUser user) {
        RetUserExample userExample = getUserExample(user);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public void updateUserAuth(Long userId, IdentifyType authType, RetUserAuthParam adminUserAuthParam) {
        RetUserAuth usernameAuth = userAuthService.getUserAuth(userId, IdentifyType.username);
        userAuthService.updateUserAuth(userId, authType, adminUserAuthParam);
    }

    @Override
    public List<RetUserParam> list(RetUserParam userDetailParam, @NotNull PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetUser userParam = new RetUser();
        List<RetUserParam> userParams = new ArrayList<>();
        if (userDetailParam != null) {
            BeanUtil.copyProperties(userDetailParam, userParam);
            RetUserExample userExample = getUserExample(userParam);
            List<RetUser> users = userMapper.selectByExample(userExample);
            RetUserAuth userAuthResult = null;
            if (StringUtils.hasLength(userDetailParam.getPhone())) {
                userAuthResult = userAuthService.getUserAuth(userDetailParam.getPhone());
            }
            if (StringUtils.hasLength(userDetailParam.getName()) && userAuthResult == null) {
                userAuthResult = userAuthService.getUserAuth(userDetailParam.getName());
            }
            if (StringUtils.hasLength(userDetailParam.getEmail()) && userAuthResult == null) {
                userAuthResult = userAuthService.getUserAuth(userDetailParam.getEmail());
            }
            RetUserAuth finalUserAuthResult = userAuthResult;
            Stream<RetUser> retUserStream = users.stream().filter(user -> finalUserAuthResult == null || Objects.equals(user.getId(), finalUserAuthResult.getUserId()));
            for (RetUser user : retUserStream.toList()) {
                RetUserParam userParamResult = new RetUserParam();
                BeanUtil.copyProperties(user, userParamResult);
                for (RetUserAuth userAuth1 : userAuthService.getUserAuth(user.getId())) {
                    if (userAuth1.getIdentityType().equals(IdentifyType.username.name())) {
                        userParamResult.setName(userAuth1.getIdentifier());
                    } else if (userAuth1.getIdentityType().equals(IdentifyType.email.name())) {
                        userParamResult.setEmail(userAuth1.getIdentifier());
                    } else if (userAuth1.getIdentityType().equals(IdentifyType.phone.name())) {
                        userParamResult.setPhone(userAuth1.getIdentifier());
                    }
                }
                userParams.add(userParamResult);
            }
        }else {
            RetUserExample userExample = new RetUserExample();
            List<RetUser> users = userMapper.selectByExample(userExample);
            for (RetUser user : users){
                RetUserParam  userParam1 = new RetUserParam();
                BeanUtil.copyProperties(user, userParam1);
                userParams.add(userParam1);
            }
        }
        return userParams;

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
    }
    @Override
    public RetUserAuth getUserAuth(Long userId, IdentifyType type){
        return userAuthService.getUserAuth(userId, type);
    }
}
