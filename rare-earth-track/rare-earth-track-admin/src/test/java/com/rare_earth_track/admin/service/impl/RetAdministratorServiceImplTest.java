package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetAdministratorDetails;
import com.rare_earth_track.admin.bean.RetLoginParam;
import com.rare_earth_track.admin.service.RetAdministratorService;
import com.rare_earth_track.admin.service.RetMailService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetAdministrator;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.security.util.JwtTokenService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/31
 **/

class RetAdministratorServiceImplTest extends TransactionTest {
    @Autowired
    RetAdministratorService administratorService;
    @Autowired
    RetMailService mailService;
    @Autowired
    JwtTokenService jwtTokenService;
    String testPassword = "123456";
    String testAdministratorName = "test";
    String testErrorIdentifier = "error";

    @Test
    void logout() {
        RetLoginParam retLoginParam = new RetLoginParam();
        retLoginParam.setPassword(testPassword);
        retLoginParam.setIdentifier(testAdministratorName);
        String login = administratorService.login(retLoginParam);
        administratorService.logout(jwtTokenService.getTokenHead() + login);
    }

    @Test
    void getAdministratorDetails() {
        UserDetails test = administratorService.getAdministratorDetails(testAdministratorName);
        Assertions.assertInstanceOf(RetAdministratorDetails.class, test);
        Assertions.assertThrows(ApiException.class, ()-> administratorService.getAdministratorDetails(testErrorIdentifier));
    }

    public String getAuthorization(){
        RetLoginParam retLoginParam = new RetLoginParam();
        retLoginParam.setPassword("123456");
        retLoginParam.setIdentifier("test");
        String token = administratorService.login(retLoginParam);
        return jwtTokenService.getTokenHead() + token;
    }
    @Test
    void refreshToken() {
        String authorization = getAuthorization();
        administratorService.refreshToken(authorization);
    }


    @Test
    void updateAdministrator() {
        RetAdministrator administrator = new RetAdministrator();
        administrator.setId(1L);
        String name = "xiaoli";
        administrator.setUsername(name);
        administratorService.updateAdministrator(administrator);
        Assertions.assertDoesNotThrow(()->administratorService.getAdministratorByAdministratorName(name));
    }

    @Test
    void deleteAdministratorByAdministratorId() {
        administratorService.deleteAdministratorByAdministratorId(1L);
        Assertions.assertThrows(Exception.class, ()-> administratorService.getAdministratorByAdministratorName(testAdministratorName));
    }

    @Test
    void getAdministrator() {
        administratorService.getAdministrators(1L);
        RetAdministrator administrator = new RetAdministrator();
        administrator.setSex(1);
        List<RetAdministrator> administrator1 = administratorService.getAdministrators(administrator);
        for (RetAdministrator administrator2 : administrator1){
            Assertions.assertEquals(administrator2.getSex(), 1);
        }
    }

    @Test
    void list() {
        List<RetAdministrator> list = administratorService.list(new PageInfo(1, 5), new RetAdministrator());
        Assertions.assertTrue(list.size()<= 5);
        list = administratorService.list(new PageInfo(1, 5), null);
        Assertions.assertTrue(list.size()<= 5);
    }

    @Test
    void getAdministratorByName() {
        RetAdministrator administratorByName = administratorService.getAdministratorByAdministratorName(testAdministratorName);
        Assertions.assertEquals(administratorByName.getId(), 1L);
    }

    @Test
    void getAdministratorResources() {
        List<RetResource> administratorResources = administratorService.getAdministratorResources(1L);
        Assertions.assertTrue(administratorResources.size() > 0);
    }

    @Test
    void deleteAdministrators() {
        RetAdministrator administrator = new RetAdministrator();
        administrator.setRoleId(3L);
        administratorService.deleteAdministrators(administrator);
        List<RetAdministrator> administrator1 = administratorService.getAdministrators(administrator);
        Assertions.assertEquals(administrator1.size(), 0);
    }
}