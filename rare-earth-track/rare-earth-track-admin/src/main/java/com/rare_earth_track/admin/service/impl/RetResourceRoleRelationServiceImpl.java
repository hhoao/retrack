package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.bean.RetResourceRoleRelationParam;
import com.rare_earth_track.admin.service.RetResourceRoleRelationService;
import com.rare_earth_track.mgb.mapper.RetResourceMapper;
import com.rare_earth_track.mgb.mapper.RetResourceRoleRelationMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetResourceRoleRelation;
import com.rare_earth_track.mgb.model.RetResourceRoleRelationExample;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
@RequiredArgsConstructor
@Service
public class RetResourceRoleRelationServiceImpl implements RetResourceRoleRelationService {
    private final RetResourceRoleRelationMapper resourceRoleRelationMapper;
    private final RetResourceMapper resourceMapper;
    @Override
    public List<RetResource> getResourcesByRoleId(Long roleId) {
        List<RetResource> resources = new ArrayList<>();
        RetResourceRoleRelationExample relationExample = new RetResourceRoleRelationExample();
        relationExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RetResourceRoleRelation> retResourceRoleRelations = resourceRoleRelationMapper.selectByExample(relationExample);
        if (retResourceRoleRelations.size() > 0){
            for (RetResourceRoleRelation relation : retResourceRoleRelations){
                Long resourceId = relation.getResourceId();
                RetResource resourceByResourceId = resourceMapper.selectByPrimaryKey(resourceId);
                resources.add(resourceByResourceId);
            }
        }
        return resources;
    }

    @Override
    public int addResourceRoleRelation(RetResourceRoleRelationParam roleResourceRelationParam) {
        RetResourceRoleRelation resourceRoleRelation = new RetResourceRoleRelation();
        BeanUtils.copyProperties(roleResourceRelationParam, resourceRoleRelation);
        int insert = resourceRoleRelationMapper.insert(resourceRoleRelation);
        return insert;
    }
}
