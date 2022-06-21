package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.IdentifyType;
import com.rare_earth_track.admin.bean.RetUserAuthParam;
import com.rare_earth_track.admin.service.RetUserAuthService;
import com.rare_earth_track.mgb.model.RetUserAuth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/6/1
 **/

class RetUserAuthServiceImplTest extends TransactionTest {
    @Autowired
    RetUserAuthService userAuthService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void getUserAuth() {
        List<RetUserAuth> userAuth = userAuthService.getUserAuth(tUserId);
        Assertions.assertEquals(userAuth.size(), 3);
        RetUserAuth userAuth1 = userAuthService.getUserAuth(IdentifyType.username, tUsername);
        Assertions.assertNotNull(userAuth1);
        RetUserAuth userAuth2 = userAuthService.getUserAuth(tUsername);
        Assertions.assertNotNull(userAuth2);
        RetUserAuth userAuth3 = userAuthService.getUserAuth(tUserId, IdentifyType.username);
        Assertions.assertNotNull(userAuth3);
        RetUserAuth userAuth4 = userAuthService.getUserAuth("17679358123");
        Assertions.assertNotNull(userAuth4);
        RetUserAuth userAuth5 = userAuthService.getUserAuth("test");
        Assertions.assertNotNull(userAuth5);
    }

    @Test
    void exists() {
        Assertions.assertTrue(userAuthService.exists(IdentifyType.username, tUsername));
    }

    @Test
    void bind() {
        userAuthService.deleteUserAuth(tUserId, IdentifyType.username);
        userAuthService.bind(tUserId, tUsername, IdentifyType.username);
    }

    @Test
    void updateCredential() {
        String testPassword = "oooooo";
        userAuthService.updateCredential(tUserId, testPassword);
        RetUserAuth userAuth = userAuthService.getUserAuth(tUserId, IdentifyType.username);
        Assertions.assertTrue(passwordEncoder.matches(testPassword, userAuth.getCredential()));
    }

    @Test
    void deleteAllUserAuth() {
        userAuthService.deleteAllUserAuth(tUserId);
        Assertions.assertEquals(userAuthService.getUserAuth(tUserId).size(), 0);
    }
    @Test
    void updateUserAuth() {
        String testPassword = "oooooo";
        RetUserAuthParam userAuthParam = new RetUserAuthParam();
        userAuthParam.setCredential(testPassword);
        userAuthService.updateUserAuth(tUserId, IdentifyType.username, userAuthParam);
        RetUserAuth userAuth = userAuthService.getUserAuth(tUserId, IdentifyType.email);
        Assertions.assertTrue(passwordEncoder.matches(testPassword, userAuth.getCredential()));
    }

    @Test
    void getUserIdByUserName() {
        userAuthService.getUserIdByUserName(tUsername);
    }
}