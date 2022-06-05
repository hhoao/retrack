package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.RetPermissionParam;
import com.rare_earth_track.admin.service.RetMemberJobPermissionRelationService;
import com.rare_earth_track.admin.service.RetMemberJobService;
import com.rare_earth_track.admin.service.RetPermissionService;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetPermission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author hhoa
 * @date 2022/6/4
 **/

class RetMemberJobServiceImplTest extends TransactionTest {
    @Autowired
    RetMemberJobService jobService;
    @Autowired
    RetPermissionService permissionService;
    @Autowired
    RetMemberJobPermissionRelationService memberJobPermissionRelationService;

    @Test
    void list() {
        List<RetMemberJob> list = jobService.list(1, 2);
        assertEquals(list.size(), 2);
    }

    @Test
    void listJobPermissions() {
        List<RetPermission> permissions = jobService.listJobPermissions(1, 2, 1L);
        assertEquals(permissions.size(), 2);
    }

    @Test
    void addJobPermission() {
        RetPermissionParam permissionParam = new RetPermissionParam();
        permissionParam.setMethod("GET");
        permissionParam.setName("test");
        permissionParam.setUrl("/test");
        Long aLong = permissionService.addPermission(permissionParam);
        jobService.addJobPermission(1L, aLong);
        assertNotNull(memberJobPermissionRelationService.getJobPermission(1L, aLong));
    }

    @Test
    void deleteJobPermission() {
        RetPermissionParam permissionParam = new RetPermissionParam();
        permissionParam.setMethod("GET");
        permissionParam.setName("test");
        permissionParam.setUrl("/test");
        Long aLong = permissionService.addPermission(permissionParam);
        jobService.addJobPermission(1L, aLong);
        jobService.deleteJobPermission(1L, aLong);
    }
    @Test
    void getJob() {
        assertNotNull(jobService.getJob("管理员"));
        assertNotNull(jobService.getJob(1L));
    }
}