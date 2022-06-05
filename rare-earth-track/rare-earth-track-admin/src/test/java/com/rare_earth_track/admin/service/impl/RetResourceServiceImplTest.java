package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.RetResourceParam;
import com.rare_earth_track.admin.config.AdminJwtSecurityConfig;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.mgb.model.RetResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author hhoa
 * @date 2022/6/4
 **/

class RetResourceServiceImplTest extends TransactionTest {
    @Autowired
    RetResourceService resourceService;
    @Autowired
    ConfigurableApplicationContext applicationContext;

    @Test
    void getResource() {
        RetResource allGetResources = resourceService.getResource("所有GET资源");
        assertNotNull(allGetResources);
        RetResource resource = resourceService.getResource(1L);
        assertEquals(resource.getName(), allGetResources.getName());
    }

    @Test
    void getAllResources() {
        List<RetResource> allResources = resourceService.getAllResources();
        Assertions.assertTrue(allResources.size() > 0);
    }


    @Test
    void addResource() {
        RetResourceParam resourceParam = new RetResourceParam();
        resourceParam.setMethod("GET");
        resourceParam.setName("哈哈哈");
        resourceParam.setUrl("URL");
        resourceService.addResource(resourceParam);
        AdminJwtSecurityConfig.AdminDynamicSecurityServiceConfig adminDynamicSecurityServiceConfig = applicationContext.getBean(AdminJwtSecurityConfig.AdminDynamicSecurityServiceConfig.class);
        Map<AntPathRequestMatcher, ConfigAttribute> dataSource = adminDynamicSecurityServiceConfig.getDataSource();
        RetResource resource = resourceService.getResource("哈哈哈");
        assertNotNull(dataSource.get(new AntPathRequestMatcher(resource.getUrl(), resource.getMethod())));
    }

    @Test
    void updateResource() {
        RetResourceParam resourceParam = new RetResourceParam();
        resourceParam.setMethod("GET");
        resourceParam.setName("我的世界");
        resourceService.updateResource("所有GET资源", resourceParam);
        AdminJwtSecurityConfig.AdminDynamicSecurityServiceConfig adminDynamicSecurityServiceConfig = applicationContext.getBean(AdminJwtSecurityConfig.AdminDynamicSecurityServiceConfig.class);
        Map<AntPathRequestMatcher, ConfigAttribute> dataSource = adminDynamicSecurityServiceConfig.getDataSource();
        RetResource resource = resourceService.getResource("我的世界");
        assertNotNull(dataSource.get(new AntPathRequestMatcher(resource.getUrl(), resource.getMethod())));
    }

    @Test
    void deleteResource() {
        AdminJwtSecurityConfig.AdminDynamicSecurityServiceConfig adminDynamicSecurityServiceConfig = applicationContext.getBean(AdminJwtSecurityConfig.AdminDynamicSecurityServiceConfig.class);
        Map<AntPathRequestMatcher, ConfigAttribute> dataSource = adminDynamicSecurityServiceConfig.getDataSource();
        RetResource resource = resourceService.getResource(1L);
        Assertions.assertNotNull(dataSource.get(new AntPathRequestMatcher(resource.getUrl(), resource.getMethod())));
        resourceService.deleteResource(1L);
        Assertions.assertNull(dataSource.get(new AntPathRequestMatcher(resource.getUrl(), resource.getMethod())));
    }
}