package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    static List<Object[]> listParamsProvider(){
        List<Object[]> params = new ArrayList<>();
        RetRole role = null;

        role = new RetRole();
        role.setName("ROLE_ADMIN");
        params.add(new Object[]{new PageInfo(1, 5), role, (Consumer<List<Object>>) o -> Assertions.assertTrue(o.size() > 0)});

        role = new RetRole();
        role.setId(1L);
        params.add(new Object[]{new PageInfo(1, 5), role, (Consumer<List<Object>>) o -> Assertions.assertTrue(o.size() > 0)});

        params.add(new Object[]{new PageInfo(1, 1), null, (Consumer<List<Object>>) o -> assertEquals(1, o.size())});

        return params;
    }
    @ParameterizedTest
    @MethodSource("listParamsProvider")
    void list(PageInfo pageInfo, RetRole role, Consumer<Object> consumer) {
        List<RetRole> list = roleService.list(pageInfo, role);
        consumer.accept(list);
    }

    static List<Object[]> allocMenusParams(){
        List<Object[]> params = new ArrayList<>();
        params.add( new Object[]{"ROLE_ADMIN", List.of(1L, 2L)});
        return params;
    }

    @MethodSource("allocMenusParams")
    @ParameterizedTest
    void allocMenus(String roleName, List<Long> menusIds) {
        roleService.allocMenus(roleName, menusIds);
        RetRole role = roleService.getRole(roleName);
        List<RetMenu> menus = roleService.getMenus(role.getId());
        Assertions.assertEquals(menus.size(), menusIds.size());
    }

    static List<Object[]> allocResourcesParams(){
        List<Object[]> params = new ArrayList<>();
        params.add( new Object[]{"ROLE_ADMIN", List.of(1L, 2L)});
        return params;
    }

    @ParameterizedTest
    @MethodSource("allocResourcesParams")
    void allocResources(String roleName, List<Long> resourcesIds) {
        roleService.allocResources(roleName, resourcesIds);
        RetRole role = roleService.getRole(roleName);
        List<RetResource> resources = roleService.getRoleResources(role.getId());
        Assertions.assertEquals(resourcesIds.size(), resources.size());
    }
}