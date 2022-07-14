package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.RetMailService;
import com.rare_earth_track.admin.service.RetUserAuthService;
import com.rare_earth_track.admin.service.RetUserService;
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
    RetMailService mailService;
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

    @Test
    void list() {
        List<RetUser> list = userService.list(new RetUser(), new PageInfo(1, 5));
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

    static List<Object[]> queryUsersParamsProvider(){
        PageInfo pageInfo = new PageInfo(1, 5);
        //1
       RetUser userParam = new RetUser();
       userParam.setSex(1);
       List<Object[]> oL = new ArrayList<>();
       oL.add(new Object[]{userParam, pageInfo});
       //2
        userParam = new RetUser();
        userParam.setStatus(1);
        oL.add(new Object[]{userParam, pageInfo});
        //3
        userParam = new RetUser();
        userParam.setId(1L);
        oL.add(new Object[]{userParam, pageInfo});
        //4
        userParam = new RetUser();
        oL.add(new Object[]{userParam, pageInfo});
       return oL;
    }
    @ParameterizedTest
    @MethodSource("queryUsersParamsProvider")
    void queryUsers(RetUser userParam, PageInfo pageInfo) {
        List<RetUser> users = userService.list(userParam, pageInfo);
        Assertions.assertTrue(users.size()>0);
    }
}