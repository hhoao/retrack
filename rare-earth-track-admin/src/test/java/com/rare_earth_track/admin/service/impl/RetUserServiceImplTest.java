package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.RetUserAuthService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.security.util.JwtTokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hhoa
 * @date 2022/5/31
 **/

class RetUserServiceImplTest extends TransactionTest {
    @Autowired
    RetUserService userService;
    @Autowired
    RetUserAuthService userAuthService;
    @Autowired
    JwtTokenService jwtTokenService;
    @Autowired
    PasswordEncoder passwordEncoder;
    String testUsername = "test";

    @Test
    void updateUser() {
        RetUser user = new RetUser();
        user.setId(1L);
        user.setNickname("xiaozhang");
        userService.updateUser(user);
    }

    @Test
    void getFactoryJobsByUserName() {
        List<RetFactoryJob> factoryJobsByUserName = userService.getFactoryJobsByUserName(testUsername);
        System.out.println(factoryJobsByUserName);
    }

    @Test
    void deleteUserByUserId() {
        userService.deleteUserByUserId(1L);
        Assertions.assertThrows(Exception.class, ()-> userService.getUserByUsername(testUsername));
    }

    @Test
    void getUser() {
        userService.getUser(1L);
        RetUser user = new RetUser();
        user.setSex(1);
        List<RetUser> user1 = userService.getUsers(user);
        for (RetUser user2 : user1){
            Assertions.assertEquals(user2.getSex(), 1);
        }
    }

    static List<Object[]> listParams(){
        List<Object[]> objects = new ArrayList<>();
        RetUserParam userParam = new RetUserParam();
        userParam.setName("test");
        objects.add(new Object[]{userParam, new PageInfo(1, 5)});
        userParam = new RetUserParam();
        userParam.setStatus(1);
        objects.add(new Object[]{userParam, new PageInfo(1, 5)});
        return objects;
    }
    @ParameterizedTest
    @MethodSource("listParams")
    void list(RetUserParam userParam, PageInfo pageInfo) {
        List<RetUserParam> list = userService.list(userParam, pageInfo);
        Assertions.assertTrue(list.size()<= 5);
        list = userService.list(null, new PageInfo(1, 5));
        Assertions.assertTrue(list.size()<= 5);
    }

    @Test
    void getUserByName() {
        RetUser userByName = userService.getUserByUsername(testUsername);
        Assertions.assertEquals(userByName.getId(), 1L);

    }

    @Test
    void updateUserAuth() {
        RetUserAuthParam userAuthParam = new RetUserAuthParam();
        String testPassword = "oooooo";
        userAuthParam.setCredential(testPassword);
        userService.updateUserAuth(1L, IdentifyType.email, userAuthParam);
        RetLoginParam loginParam = new RetLoginParam();
        RetUserAuth userAuth = userService.getUserAuth(1L, IdentifyType.username);
        Assertions.assertTrue(passwordEncoder.matches(testPassword, userAuth.getCredential()));
    }

    @Test
    void deleteUsers() {
        RetUser user = new RetUser();
        user.setId(1L);
        userService.deleteUsers(user);
        List<RetUser> user1 = userService.getUsers(user);
        Assertions.assertEquals(user1.size(), 0);
    }

    @Test
    void getUserAuths() {
        Map<String, String> userAuths = userService.getUserAuths(tUserId);
        Assertions.assertNotNull(userAuths);
    }

    static List<String> getUserByIdentifierParams(){
        List<String> params = new ArrayList<>();
        params.add("test");
        return params;
    }
    @ParameterizedTest
    @MethodSource("getUserByIdentifierParams")
    void getUserByIdentifier(String identifier) {
        RetUser test = userService.getUserByIdentifier(identifier);
        Assertions.assertNotNull(test);
    }

    @Test
    void getUserByUsername() {
        RetUser test = userService.getUserByUsername("test");
        Assertions.assertNotNull(test);
    }

    @Test
    void getUsers() {
        List<RetUser> users = userService.getUsers(new RetUser());
        Assertions.assertNotNull(users);
    }

    @Test
    void deleteUserAuth() {
        userService.deleteUserAuth(1L, IdentifyType.username);
        Assertions.assertThrows(ApiException.class, ()-> userService.getUserAuth(1L, IdentifyType.username));
    }

    @Test
    void getUserAuth() {
        Assertions.assertNotNull(userService.getUserAuth(1L, IdentifyType.username));
        userService.deleteUserAuth(1L, IdentifyType.username);
        Assertions.assertThrows(ApiException.class, ()-> userService.getUserAuth(1L, IdentifyType.username));
    }
}