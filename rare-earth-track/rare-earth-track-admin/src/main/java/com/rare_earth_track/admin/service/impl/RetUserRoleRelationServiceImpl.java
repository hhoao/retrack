package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetUserRoleRelationService;
import com.rare_earth_track.mgb.mapper.RetRoleMapper;
import com.rare_earth_track.mgb.mapper.RetUserRoleRelationMapper;
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
        return null;
    }
}
