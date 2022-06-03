package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.admin.service.RetRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hhoa
 * @date 2022/6/3
 **/

class RetRoleServiceImplTest extends TransactionTest {
    @Autowired
    RetRoleService roleService;
    private final String testRoleName = "ROLE_ADMIN";
    @Test
    void updateRole() {
        RetRoleParam roleParam = new RetRoleParam();
        roleParam.setDescription("管理员");
        roleService.updateRole(testRoleName, roleParam);
    }

    @Test
    void getRoleResources() {
    }

    @Test
    void getRole() {
    }

    @Test
    void addRole() {
    }

    @Test
    void getAllRoles() {
    }

    @Test
    void list() {
    }

    @Test
    void deleteRole() {
    }
}