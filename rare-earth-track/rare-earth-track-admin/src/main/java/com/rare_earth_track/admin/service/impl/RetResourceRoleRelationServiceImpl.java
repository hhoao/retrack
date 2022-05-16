package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.RetResourceRoleRelationParam;
import com.rare_earth_track.admin.service.RetResourceRoleRelationService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetResourceMapper;
import com.rare_earth_track.mgb.mapper.RetResourceRoleRelationMapper;
import com.rare_earth_track.mgb.mapper.RetRoleMapper;
import com.rare_earth_track.mgb.model.*;
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
    private final RetRoleMapper roleMapper;
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
        return resourceRoleRelationMapper.insert(resourceRoleRelation);
    }
    public RetRole getRoleByRoleName(String name){
        RetRole role = null;
        RetRoleExample roleExample = new RetRoleExample();
        roleExample.createCriteria().andNameEqualTo(name);
        List<RetRole> retRoles = roleMapper.selectByExample(roleExample);
        if (retRoles != null){
            role = retRoles.get(0);
        }
        return role;
    }
    @Override
    public List<RetResource> listRoleResources(String name, Integer from, Integer size) {
        PageHelper.startPage(from, size);
        RetRole roleByRoleName = getRoleByRoleName(name);
        if (roleByRoleName == null){
            Asserts.fail("没有该角色");
        }
        return getResourcesByRoleId(roleByRoleName.getId());
    }
}
