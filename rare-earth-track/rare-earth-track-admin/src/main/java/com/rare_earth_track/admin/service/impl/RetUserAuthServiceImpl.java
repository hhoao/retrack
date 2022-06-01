package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.bean.IdentifyType;
import com.rare_earth_track.admin.service.RetMailService;
import com.rare_earth_track.admin.service.RetUserAuthService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetUserAuthMapper;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.mgb.model.RetUserAuthExample;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author hhoa
 * @date 2022/5/29
 **/
@Service
@RequiredArgsConstructor
public class RetUserAuthServiceImpl implements RetUserAuthService {
    private final RetUserAuthMapper userAuthMapper;
    private final PasswordEncoder passwordEncoder;
    private final RetMailService mailService;
    @Override
    public List<RetUserAuth> getUserAuth(Long userId){
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        userAuthExample.createCriteria().
                andUserIdEqualTo(userId).
                andIdentityTypeEqualTo(IdentifyType.username.value());
        List<RetUserAuth> retUserAuths = userAuthMapper.selectByExample(userAuthExample);
        if (retUserAuths == null || retUserAuths.size() == 0){
            Asserts.fail("没有该验证方式");
        }
        return retUserAuths;
    }
    @Override
    public RetUserAuth getUserAuth(Long userId, IdentifyType identifyType) {
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        userAuthExample.createCriteria().
                andUserIdEqualTo(userId).
                andIdentityTypeEqualTo(identifyType.value());
        List<RetUserAuth> retUserAuths = userAuthMapper.selectByExample(userAuthExample);
        if (retUserAuths == null || retUserAuths.size() == 0){
            Asserts.fail("没有该验证方式");
        }
        return retUserAuths.get(0);
    }

    @Override
    public RetUserAuth getUserAuth(IdentifyType identifyType, String identifier) {
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        userAuthExample.createCriteria().
                andIdentifierEqualTo(identifier).
                andIdentityTypeEqualTo(identifyType.value());
        List<RetUserAuth> retUserAuths = userAuthMapper.selectByExample(userAuthExample);
        if (retUserAuths == null || retUserAuths.size() == 0){
            Asserts.fail("没有该用户");
        }
        return retUserAuths.get(0);
    }

    @Override
    public boolean exists(IdentifyType identifyType, String identifier){
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        userAuthExample.createCriteria().
                andIdentityTypeEqualTo(identifyType.value()).
                andIdentifierEqualTo(identifier);
        List<RetUserAuth> retUserAuths = userAuthMapper.selectByExample(userAuthExample);
        return retUserAuths != null && retUserAuths.size() != 0;
    }

    @Override
    public void bind(Long id, String identifier, IdentifyType identifyType) {
        RetUserAuth userAuth = new RetUserAuth();
        String s = UUID.randomUUID().toString();
        userAuth.setUserId(id);
        userAuth.setIdentifier(identifier);
        userAuth.setIdentityType(identifyType.value());
        userAuth.setCredential(s);
        userAuthMapper.insert(userAuth);
    }


    @Override
    public void updateCredential(Long userId, String credential){
        List<RetUserAuth> userAuths = getUserAuth(userId);
        for (RetUserAuth userAuth : userAuths){
            userAuth.setCredential(passwordEncoder.encode(credential));
            int i = userAuthMapper.updateByPrimaryKey(userAuth);
            if (i == 0){
                Asserts.fail("更新失败");
            }
        }
    }

    @Override
    public void deleteAllUserAuth(Long userId) {
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        userAuthExample.createCriteria().
                andUserIdEqualTo(userId);
        List<RetUserAuth> retUserAuths = userAuthMapper.selectByExample(userAuthExample);
        for (RetUserAuth userAuth : retUserAuths){
            userAuthMapper.deleteByPrimaryKey(userAuth.getId());
        }
    }

    @Override
    public RetUserAuth getUserAuth(String identifier, String credential) {
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        userAuthExample.createCriteria().
                andIdentifierEqualTo(identifier).
                andCredentialEqualTo(credential);
        List<RetUserAuth> retUserAuths = userAuthMapper.selectByExample(userAuthExample);
        if (retUserAuths == null || retUserAuths.size() == 0){
            Asserts.fail("没有该验证方式");
        }
        if (retUserAuths.size() > 1){
            Asserts.fail("有多个验证方式");
        }
        return retUserAuths.get(0);
    }

    @Override
    public void updateUserAuth(RetUserAuth userAuth) {
        RetUserAuth oldUserAuth = userAuthMapper.selectByPrimaryKey(userAuth.getId());
        if (userAuth.getCredential() != null) {
            if (!passwordEncoder.matches(userAuth.getCredential(), oldUserAuth.getCredential())) {
//            updateCredential(userAuth.getUserId(), userAuth.getCredential());
                updateCredential(userAuth.getUserId(), userAuth.getCredential());
                userAuth.setCredential(passwordEncoder.encode(userAuth.getCredential()));
            }
        }
        int i = userAuthMapper.updateByPrimaryKeySelective(userAuth);
        if (i == 0){
            Asserts.fail("更新失败");
        }
    }

    @Override
    public Long getUserIdByUserName(String username) {
        RetUserAuth usernameAuth = getUserAuth(IdentifyType.username, username);
        return usernameAuth.getUserId();
    }

    @Override
    public void deleteUserAuth(Long userId, IdentifyType authType) {
        RetUserAuth userAuth = getUserAuth(userId, authType);
        int i = userAuthMapper.deleteByPrimaryKey(userAuth.getId());
    }

    @Override
    public RetUserAuth getUserAuth(String identifier) {
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        userAuthExample.createCriteria().andIdentifierEqualTo(identifier);
        List<RetUserAuth> retUserAuths = userAuthMapper.selectByExample(userAuthExample);
        if (retUserAuths == null || retUserAuths.size() == 0){
            Asserts.fail("没有该用户");
        }
        if (retUserAuths.size() > 1){
            Asserts.fail("该认证标识数量不少于一个");
        }

        return retUserAuths.get(0);
    }
}
