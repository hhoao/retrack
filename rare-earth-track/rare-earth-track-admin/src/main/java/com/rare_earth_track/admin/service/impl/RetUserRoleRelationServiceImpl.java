package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetRoleResourceRelationService;
import com.rare_earth_track.admin.service.RetUserRoleRelationService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetRoleMapper;
import com.rare_earth_track.mgb.mapper.RetUserRoleRelationMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;
import com.rare_earth_track.mgb.model.RetUserRoleRelation;
import com.rare_earth_track.mgb.model.RetUserRoleRelationExample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
@Service
@RequiredArgsConstructor
public class RetUserRoleRelationServiceImpl implements RetUserRoleRelationService {
    private final RetUserRoleRelationMapper userRoleRelationMapper;
    private final RetRoleMapper roleMapper;
    private final RetRoleResourceRelationService roleResourceRelationService;
    private RetRole createDefaultUserRole(Long userId){
        RetUserRoleRelation userRoleRelation = new RetUserRoleRelation();
        userRoleRelation.setUserId(userId);
        userRoleRelationMapper.insert(userRoleRelation);
        return getRoleByUserId(userId);
    }
    @Override
    public RetRole getRoleByUserId(Long userId) {
        RetUserRoleRelationExample relationExample = new RetUserRoleRelationExample();
        relationExample.createCriteria().andUserIdEqualTo(userId);
        List<RetUserRoleRelation> retUserRoleRelations = userRoleRelationMapper.selectByExample(relationExample);
        if (retUserRoleRelations.size() > 0){
            RetUserRoleRelation relation = retUserRoleRelations.get(0);
            Long roleId = relation.getRoleId();
            return roleMapper.selectByPrimaryKey(roleId);
        }
        return createDefaultUserRole(userId);
    }

    @Override
    public List<RetResource> getResourcesByUserId(Long id) {
        RetRole role = getRoleByUserId(id);
        return roleResourceRelationService.getResourcesByRoleId(role.getId());
    }

    @Override
    public void alterUserRole(Long userId, Long roleId) {
        RetUserRoleRelationExample userRoleRelationExample = new RetUserRoleRelationExample();
        userRoleRelationExample.createCriteria().andUserIdEqualTo(userId);
        List<RetUserRoleRelation> userRoleRelations = userRoleRelationMapper.selectByExample(userRoleRelationExample);
        if (userRoleRelations == null || userRoleRelations.size() == 0){
            Asserts.fail("用户没有角色");
        }
        RetUserRoleRelation userRoleRelation = userRoleRelations.get(0);
        userRoleRelation.setRoleId(roleId);
        int i = userRoleRelationMapper.updateByPrimaryKey(userRoleRelation);
        if (i == 0){
            Asserts.fail("修改角色失败");
        }

    }
}
