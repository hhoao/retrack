package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.portal.TransactionTest;
import com.rare_earth_track.portal.bean.IdentifyType;
import com.rare_earth_track.portal.bean.RetLoginParam;
import com.rare_earth_track.portal.bean.RetUpdateUserPasswordParam;
import com.rare_earth_track.portal.bean.RetUserDetails;
import com.rare_earth_track.portal.service.RetMailService;
import com.rare_earth_track.portal.service.RetUserAuthService;
import com.rare_earth_track.portal.service.RetUserService;
import com.rare_earth_track.security.util.JwtTokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

/**
 * @ClassName RetUserServiceImplTest
 * @Description: 用户测试
 * @Author 匡龙
 * @Date 2022/7/1 16:20
 * @Version V1.0
 */

public class RetUserServiceImplTest extends TransactionTest {
    @Autowired
    RetUserService userService;
    @Autowired
    RetUserAuthService userAuthService;
    @Autowired
    JwtTokenService jwtTokenService;
    String testPassword = "123456";
    String testUsername = "test";
    String testEmail = "haunghao@foxmail.com";
    String testErrorPassword = "error";
    String testErrorIdentifier = "error";

    @Test
    void login() {
        RetLoginParam retLoginParam = new RetLoginParam();
        retLoginParam.setPassword(testPassword);
        retLoginParam.setIdentifier(testUsername);
        Assertions.assertNotNull(userService.login(retLoginParam));
        retLoginParam.setIdentifier("haunghao@foxmail.com");
        retLoginParam.setPassword(testPassword);
        Assertions.assertNotNull(userService.login(retLoginParam));
        retLoginParam.setPassword(testErrorPassword);
        Assertions.assertThrows(ApiException.class, ()->userService.login(retLoginParam));
    }

    @Test
    void logout() {
        RetLoginParam retLoginParam = new RetLoginParam();
        retLoginParam.setPassword(testPassword);
        retLoginParam.setIdentifier(testUsername);
        String login = userService.login(retLoginParam);
        userService.logout(jwtTokenService.getTokenHead() + login);
        Assertions.assertFalse(userService.hasLogin(jwtTokenService.getSubjectFromToken(login)));
    }

    @Test
    void getUserDetails() {
        UserDetails test = userService.getUserDetails(testUsername);
        Assertions.assertInstanceOf(RetUserDetails.class, test);
        Assertions.assertThrows(ApiException.class, ()-> userService.getUserDetails(testErrorIdentifier));
    }

    public String getAuthorization(){
        RetLoginParam retLoginParam = new RetLoginParam();
        retLoginParam.setPassword("123456");
        retLoginParam.setIdentifier("test");
        String token = userService.login(retLoginParam);
        return jwtTokenService.getTokenHead() + token;
    }
    @Test
    void refreshToken() {
        String authorization = getAuthorization();
        userService.refreshToken(authorization);
    }

    @Test
    void updateUserPassword() {
        RetUpdateUserPasswordParam userAuthParam = new RetUpdateUserPasswordParam();
        userAuthParam.setIdentifier(testUsername);
        userAuthParam.setIdentifyType(IdentifyType.username);
        userAuthParam.setOldPassword(testPassword);
        userAuthParam.setNewPassword("newPassword");
        userService.updateUserPassword(userAuthParam);
        RetLoginParam loginParam = new RetLoginParam();
        loginParam.setPassword("newPassword");
        loginParam.setIdentifier(testUsername);
        String login = userService.login(loginParam);
        Assertions.assertNotNull(login);
    }


    @Test
    void getUserByName() {
        RetUser userByName = userService.getUserByUsername(testUsername);
        Assertions.assertEquals(userByName.getId(), 1L);
    }

    @Test
    void getUserEmailByUsername() {
        RetUserAuth userEmailByUsername = userService.getUserEmailByUsername(testUsername);
        Assertions.assertEquals(userEmailByUsername.getIdentifier(), testEmail);
    }


    @Test
    void unbindUserAuth() {
        String authorization = getAuthorization();
        userService.unbindUserAuth(IdentifyType.email, authorization);
        Assertions.assertThrows(ApiException.class, () ->  userAuthService.getUserAuth(IdentifyType.email, testEmail));
    }

    @Test
    void updateUsername() {
        String authorization = getAuthorization();
        userService.updateUsername("test2", authorization);
        Long test2 = userAuthService.getUserIdByUserName("test2");
        Assertions.assertEquals(test2, 1L);
    }



    @Test
    void getUserAuths() {
        Map<String, String> userAuths = userService.getUserAuths(tUserId);
        Assertions.assertNotNull(userAuths);
    }
}
