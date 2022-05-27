package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetMemberJobPermissionRelationService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMemberJobPermissionRelationMapper;
import com.rare_earth_track.mgb.mapper.RetPermissionMapper;
import com.rare_earth_track.mgb.model.RetMemberJobPermissionRelation;
import com.rare_earth_track.mgb.model.RetMemberJobPermissionRelationExample;
import com.rare_earth_track.mgb.model.RetPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/27
 **/

@Service
@RequiredArgsConstructor
public class RetMemberJobPermissionRelationServiceImpl implements RetMemberJobPermissionRelationService {
    private final  RetMemberJobPermissionRelationMapper memberJobPermissionRelationMapper;
    private final RetPermissionMapper permissionMapper;
    @Override
    public void deleteMemberPermissionRelationByPermissionId(Long permissionId) {
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
        RetMemberJobPermissionRelationExample.Criteria criteria = memberJobPermissionRelationExample.createCriteria().andMemberJobIdEqualTo(jobId);
        List<RetMemberJobPermissionRelation> retMemberJobPermissionRelations = memberJobPermissionRelationMapper.selectByExample(memberJobPermissionRelationExample);
        List<RetPermission> permissions = new ArrayList<>();
        for (RetMemberJobPermissionRelation memberJobPermissionRelation : retMemberJobPermissionRelations){
            RetPermission retPermission = permissionMapper.selectByPrimaryKey(memberJobPermissionRelation.getPermissionId());
            permissions.add(retPermission);
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
}
