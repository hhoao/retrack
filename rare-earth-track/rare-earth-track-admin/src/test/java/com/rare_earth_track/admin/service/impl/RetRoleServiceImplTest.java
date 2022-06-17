package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        List<RetResource> roleResources = roleService.getRoleResources(1L);
        Assertions.assertNotNull(roleResources);
    }

    @Test
    void getRole() {
        RetRole role = roleService.getRole(testRoleName);
        Assertions.assertEquals(role.getId(), 1L);
    }

    @Test
    void addRole() {
        RetRoleParam roleParam = new RetRoleParam();
        roleParam.setName("ROLE_CONTROLLER");
        roleService.addRole(roleParam);
        RetRole role_controller = roleService.getRole("ROLE_CONTROLLER");
        Assertions.assertEquals(role_controller.getName(), "ROLE_CONTROLLER");
    }

    @Test
    void deleteRole() {
        roleService.deleteRole("ROLE_ADMIN");
        Assertions.assertThrows(ApiException.class, ()-> roleService.getRole("ROLE_ADMIN"));
    }

    @Test
    void deleteRoleMenu() {
        roleService.deleteRoleMenu(testRoleName, 1L);
        RetRole role_user = roleService.getRole(testRoleName);
        List<RetMenu> menus = roleService.getMenus(role_user.getId());
        boolean b = false;
        for (RetMenu menu : menus) {
            if (menu.getId() == 1L) {
                b = true;
                break;
            }
        }
        Assertions.assertFalse(b);
    }

    @Test
    void addRoleMenu() {
        roleService.addRoleMenu("ROLE_USER", 1L);
        RetRole role_user = roleService.getRole("ROLE_USER");
        List<RetMenu> menus = roleService.getMenus(role_user.getId());
        boolean b = false;
        for (RetMenu menu : menus) {
            if (menu.getId() == 1L) {
                b = true;
                break;
            }
        }
        Assertions.assertTrue(b);
    }
}