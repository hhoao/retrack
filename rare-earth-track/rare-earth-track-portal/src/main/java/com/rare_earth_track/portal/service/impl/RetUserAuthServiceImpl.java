package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.admin.bean.IdentifyType;
import com.rare_earth_track.admin.bean.RetUserAuthParam;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetUserAuthMapper;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.mgb.model.RetUserAuthExample;
import com.rare_earth_track.portal.service.RetUserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    @Override
    public List<RetUserAuth> getUserAuth(Long userId){
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        userAuthExample.createCriteria().
                andUserIdEqualTo(userId);
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

    private RetUserAuthExample getUserAuthExample(RetUserAuth userAuth){
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        RetUserAuthExample.Criteria criteria = userAuthExample.createCriteria();
        if (userAuth.getId() != null){
            criteria.andIdEqualTo(userAuth.getId());
            return userAuthExample;
        }
        if (userAuth.getUserId() != null){
            criteria.andUserIdEqualTo(userAuth.getUserId());
            return userAuthExample;
        }
        if (userAuth.getIdentifier() != null){
            criteria.andIdentifierEqualTo(userAuth.getIdentifier());
            return userAuthExample;
        }
        if (userAuth.getCredential() != null && userAuth.getUserId() != null){
            String newCredential = passwordEncoder.encode(userAuth.getCredential());
            criteria.andCredentialEqualTo(newCredential);
        }
        if (userAuth.getIdentityType() != null){
            criteria.andIdentityTypeEqualTo(userAuth.getIdentityType());
        }
        return userAuthExample;
    }
    @Override
    public void deleteAllUserAuth(Long userId) {
        RetUserAuthExample userAuthExample = new RetUserAuthExample();
        userAuthExample.createCriteria().
                andUserIdEqualTo(userId);
        List<RetUserAuth> retUserAuths = userAuthMapper.selectByExample(userAuthExample);
        for (RetUserAuth userAuth : retUserAuths){
            userAuthMapper.deleteByPrimaryKey(userAuth.getId());
            userAuthMapper.deleteByPrimaryKey(userAuth.getId());
        }
    }

    @Override
    public void updateUserAuth(Long userId, IdentifyType identifyType, RetUserAuthParam userAuthParam){
        RetUserAuth oldUserAuth = getUserAuth(userId, identifyType);
        RetUserAuth userAuth = new RetUserAuth();
        BeanUtils.copyProperties(userAuthParam, userAuth);

        userAuth.setId(oldUserAuth.getId());
        userAuthMapper.updateByPrimaryKeySelective(userAuth);
        if (userAuthParam.getCredential() != null) {
            updateCredential(userId, userAuthParam.getCredential());
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
        if (i == 0){
            Asserts.fail("删除失败");
        }
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
