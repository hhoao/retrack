package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.RetMailService;
import com.rare_earth_track.admin.service.RetUserAuthService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.security.util.JwtTokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

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
    String testRegisterMail = "huanghaohhoa@163.com";
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

//    @Test
//    Long register() {
//        String authCode = mailService.sendUserRegisterMail(testRegisterMail);
//        mailService.validateMessage(testRegisterMail, authCode, MailType.USER_REGISTER);
//        RetUserRegisterParam userRegisterParam =new RetUserRegisterParam();
//        userRegisterParam.setIdentifier(testRegisterMail);
//        userRegisterParam.setAuthCode(authCode);
//        userRegisterParam.setIdentifyType(IdentifyType.email);
//        Long userId = userService.register(userRegisterParam);
//        Assertions.assertEquals(userAuthService.getUserAuth(userId, IdentifyType.email).
//                getIdentifier(), testRegisterMail);
//        return userId;
//    }

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
    void updateUser() {
        RetUser user = new RetUser();
        user.setId(1L);
        user.setNickname("xiaozhang");
        userService.updateUser(user);
    }

//    @Test
//    void sendUserRegisterMail() {
//        userService.sendUserRegisterMail(testRegisterMail);
//        boolean b = mailService.existMessage(testRegisterMail, MailType.USER_REGISTER);
//        Assertions.assertTrue(b);
//    }

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
        List<RetUser> user1 = userService.getUser(user);
        for (RetUser user2 : user1){
            Assertions.assertEquals(user2.getSex(), 1);
        }
    }

    @Test
    void getAllUsers() {
        List<RetUser> allUsers = userService.getAllUsers();
        Assertions.assertNotNull(allUsers);
    }

    @Test
    void list() {
        List<RetUser> list = userService.list(new PageInfo(1, 5));
        Assertions.assertTrue(list.size()<= 5);
    }

    @Test
    void getUserByName() {
        RetUser userByName = userService.getUserByUsername(testUsername);
        Assertions.assertEquals(userByName.getId(), 1L);
    }

    @Test
    void getUserResources() {
        List<RetResource> userResources = userService.getUserResources(1L);
        Assertions.assertTrue(userResources.size() > 0);
    }

    @Test
    void updateUserRole() {
        userService.updateUserRole(1L, 2L);
        RetUser user = userService.getUser(1L);
        Assertions.assertEquals(2L, (long) user.getRoleId());
    }

    @Test
    void getUserEmailByUsername() {
        RetUserAuth userEmailByUsername = userService.getUserEmailByUsername(testUsername);
        Assertions.assertEquals(userEmailByUsername.getIdentifier(), testEmail);
    }

    @Test
    void updateUserAuth() {
        RetUserAuthParam userAuthParam = new RetUserAuthParam();
        userAuthParam.setCredential("oooooo");
        userService.updateUserAuth(1L, IdentifyType.email, userAuthParam);

        RetLoginParam loginParam = new RetLoginParam();
        loginParam.setIdentifier(testUsername);
        loginParam.setPassword("oooooo");
        String login = userService.login(loginParam);
        Assertions.assertNotNull(login);
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
    void deleteUsers() {
        RetUser user = new RetUser();
        user.setRoleId(3L);
        userService.deleteUsers(user);
        List<RetUser> user1 = userService.getUser(user);
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
       RetUserParam userParam = new RetUserParam();
       userParam.setSex(1);
       List<Object[]> oL = new ArrayList<>();
       oL.add(new Object[]{userParam, pageInfo});
       //2
        userParam = new RetUserParam();
        userParam.setName("test");
        oL.add(new Object[]{userParam, pageInfo});
        //3
        userParam = new RetUserParam();
        userParam.setId("1");
        oL.add(new Object[]{userParam, pageInfo});
        //4
        userParam = new RetUserParam();
        oL.add(new Object[]{userParam, pageInfo});
       return oL;
    }
    @ParameterizedTest
    @MethodSource("queryUsersParamsProvider")
    void queryUsers(RetUserParam userParam, PageInfo pageInfo) {
        List<RetUser> users = userService.queryUsers(userParam, pageInfo);
        Assertions.assertTrue(users.size()>0);
    }
}