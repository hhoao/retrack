package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetPermissionParam;
import com.rare_earth_track.admin.config.AdminJwtSecurityConfig;
import com.rare_earth_track.admin.service.RetPermissionService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetPermission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hhoa
 * @date 2022/6/5
 **/

class RetPermissionServiceImplTest extends TransactionTest {
    @Autowired
    RetPermissionService permissionService;
    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Test
    void getPermission() {
        RetPermission permission = permissionService.getPermission(1L);
        assertEquals(permission.getId(), 1L);
    }

    @Test
    void getAllPermissions() {
        List<RetPermission> allPermissions = permissionService.getAllPermissions();
        assertTrue(allPermissions.size() > 0);
    }

    static private List<Object[]> listParams(){
        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new PageInfo(1, 2), null, (Consumer<List<RetPermission>>) list -> {
            Assertions.assertEquals(list.size(), 2);
        }});
        return params;
    }

    @ParameterizedTest
    @MethodSource("listParams")
    void list(PageInfo pageInfo, RetPermission permission, Consumer<List<RetPermission>> consumer) {
        consumer.accept(permissionService.list(pageInfo, permission));
    }

    @Test
    void testGetPermission() {
        assertNotNull(permissionService.getPermission(1L));
        assertNotNull(permissionService.getPermission("获取工厂所有成员"));
    }
    private Map<AntPathRequestMatcher, ConfigAttribute>  getDataSource(){
        AdminJwtSecurityConfig.AdminDynamicSecurityServiceConfig adminDynamicSecurityServiceConfig = applicationContext.getBean(AdminJwtSecurityConfig.AdminDynamicSecurityServiceConfig.class);
        return adminDynamicSecurityServiceConfig.getDataSource();
    }
    @Test
    void addPermission() {
        RetPermissionParam permissionParam = new RetPermissionParam();
        permissionParam.setMethod("GET");
        permissionParam.setName("test");
        permissionParam.setUrl("/test");
        Long aLong = permissionService.addPermission(permissionParam);
        assertNotNull(permissionService.getPermission(aLong));
    }

    @Test
    void updatePermission() {
        RetPermissionParam permissionParam = new RetPermissionParam();
        permissionParam.setName("test");
        permissionService.updatePermission("获取工厂所有成员", permissionParam);
        assertNotNull(permissionService.getPermission("test"));
    }

    @Test
    void deletePermission() {
        permissionService.deletePermission(2L);
        assertThrows(ApiException.class, ()->permissionService.getPermission(2L));
        assertNull(getDataSource().get(new AntPathRequestMatcher("/factories/**/members", "GET")));
    }
}