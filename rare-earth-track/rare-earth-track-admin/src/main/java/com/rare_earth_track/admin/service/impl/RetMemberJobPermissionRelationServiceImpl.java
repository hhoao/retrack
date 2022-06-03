package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetMemberJobPermissionRelationService;
import com.rare_earth_track.admin.service.RetMemberJobService;
import com.rare_earth_track.admin.service.RetPermissionService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMemberJobPermissionRelationMapper;
import com.rare_earth_track.mgb.model.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/27
 **/

@Service
public class RetMemberJobPermissionRelationServiceImpl implements RetMemberJobPermissionRelationService {
    private final RetMemberJobPermissionRelationMapper memberJobPermissionRelationMapper;
    private final RetPermissionService permissionService;
    private final RetMemberJobService jobService;
    @Lazy
    public RetMemberJobPermissionRelationServiceImpl(RetMemberJobPermissionRelationMapper memberJobPermissionRelationMapper,
                                                     RetPermissionService permissionService,
                                                     RetMemberJobService jobService) {
        this.memberJobPermissionRelationMapper = memberJobPermissionRelationMapper;
        this.permissionService= permissionService;
        this.jobService = jobService;
    }

    @Override
    public void deleteMemberPermission(Long permissionId) {
        RetMemberJobPermissionRelationExample memberJobPermissionRelationExample = new RetMemberJobPermissionRelationExample();
        memberJobPermissionRelationExample.createCriteria().andPermissionIdEqualTo(permissionId);
        List<RetMemberJobPermissionRelation> retMemberJobPermissionRelations = memberJobPermissionRelationMapper.selectByExample(memberJobPermissionRelationExample);
        for (RetMemberJobPermissionRelation memberJobPermissionRelation : retMemberJobPermissionRelations){
            memberJobPermissionRelationMapper.deleteByPrimaryKey(memberJobPermissionRelation.getId());
        }
    }

    @Override
    public List<RetPermission> getJobPermissions(Long jobId) {
        RetMemberJobPermissionRelationExample memberJobPermissionRelationExample = new RetMemberJobPermissionRelationExample();
        memberJobPermissionRelationExample.createCriteria().andMemberJobIdEqualTo(jobId);
        List<RetMemberJobPermissionRelation> retMemberJobPermissionRelations = memberJobPermissionRelationMapper.selectByExample(memberJobPermissionRelationExample);
        List<RetPermission> permissions = new ArrayList<>();
        for (RetMemberJobPermissionRelation memberJobPermissionRelation : retMemberJobPermissionRelations){
            RetPermission permissionByPermissionId = permissionService.getPermission(memberJobPermissionRelation.getPermissionId());
            permissions.add(permissionByPermissionId);
        }
        return permissions;
    }

    @Override
    public void addJobPermission(Long jobId, Long permissionId) {
        RetMemberJobPermissionRelation memberJobPermissionRelation = new RetMemberJobPermissionRelation();
        memberJobPermissionRelation.setPermissionId(permissionId);
        memberJobPermissionRelation.setMemberJobId(jobId);
        int insert = memberJobPermissionRelationMapper.insert(memberJobPermissionRelation);
        if (insert == 0){
            Asserts.fail("插入失败");
        }
    }

    @Override
    public void deleteJobPermission(Long jobId, Long permissionId) {
        RetMemberJobPermissionRelationExample memberJobPermissionRelationExample = new RetMemberJobPermissionRelationExample();
        memberJobPermissionRelationExample.createCriteria().andPermissionIdEqualTo(permissionId).andMemberJobIdEqualTo(jobId);
        List<RetMemberJobPermissionRelation> retMemberJobPermissionRelations = memberJobPermissionRelationMapper.selectByExample(memberJobPermissionRelationExample);
        if (retMemberJobPermissionRelations == null || retMemberJobPermissionRelations.size() == 0){
            Asserts.fail("job没有该权限");
        }
        int i = memberJobPermissionRelationMapper.deleteByPrimaryKey(retMemberJobPermissionRelations.get(0).getId());
        if (i == 0){
            Asserts.fail("job权限删除失败");
        }
    }

    @Override
    public void addJobPermission(String jobName, String permissionName) {
        RetMemberJob job = jobService.getJob(jobName);
        RetPermission permission = permissionService.getPermission(permissionName);
        addJobPermission(job.getId(), permission.getId());
    }
}
