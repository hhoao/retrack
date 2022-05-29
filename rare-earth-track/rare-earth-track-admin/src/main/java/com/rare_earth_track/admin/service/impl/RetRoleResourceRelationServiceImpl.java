package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.service.RetRoleResourceCacheService;
import com.rare_earth_track.admin.service.RetRoleResourceRelationService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetResourceMapper;
import com.rare_earth_track.mgb.mapper.RetRoleResourceRelationMapper;
import com.rare_earth_track.mgb.mapper.RetRoleMapper;
import com.rare_earth_track.mgb.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
@Service
public class RetRoleResourceRelationServiceImpl implements RetRoleResourceRelationService {
    private final RetRoleResourceRelationMapper roleResourceRelationMapper;
    private final RetResourceMapper resourceMapper;
    private final RetRoleMapper roleMapper;
    private final RetRoleResourceCacheService resourceCacheService;

    public RetRoleResourceRelationServiceImpl(RetRoleResourceRelationMapper roleResourceRelationMapper,
                                              RetResourceMapper resourceMapper,
                                              RetRoleMapper roleMapper,
                                              RetRoleResourceCacheService resourceCacheService) {
        this.roleResourceRelationMapper = roleResourceRelationMapper;
        this.resourceMapper = resourceMapper;
        this.roleMapper = roleMapper;
        this.resourceCacheService = resourceCacheService;
        //初始化 将所有角色对应资源加载进缓存中
        refreshCacheByAllRoleNames();
    }
    @Override
    public void refreshCacheByRoleName(String roleName){
        RetRole roleByRoleName = getRoleByRoleName(roleName);
        refreshCacheByRole(roleByRoleName);
    }
    @Override
    public void refreshCacheByRoleId(Long roleId){
        refreshCacheByRole(roleMapper.selectByPrimaryKey(roleId));
    }

    @Override
    public void refreshCacheByResourceId(Long resourceId) {
        List<RetRole> rolesByResourceId = getRolesByResourceId(resourceId);
        for (RetRole role : rolesByResourceId){
            refreshCacheByRoleName(role.getName());
        }
    }

    @Override
    public void refreshCacheByRole(RetRole role){
        RetRoleResourceRelationExample roleResourceRelationExample = new RetRoleResourceRelationExample();
        roleResourceRelationExample.createCriteria().andRoleIdEqualTo(role.getId());
        List<RetRoleResourceRelation> roleResourceRoleRelations = roleResourceRelationMapper.selectByExample(roleResourceRelationExample);
        List<RetResource> resources = new ArrayList<>();
        for (RetRoleResourceRelation resourceRoleRelation : roleResourceRoleRelations) {
            RetResource retResource = resourceMapper.selectByPrimaryKey(resourceRoleRelation.getResourceId());
            resources.add(retResource);
        }
        resourceCacheService.setByRoleName(resources, role.getName());
    }
    @Override
    public void refreshCacheByAllRoleNames(){
        List<RetRole> roles = roleMapper.selectByExample(new RetRoleExample());
        for (RetRole role : roles) {
            refreshCacheByRole(role);
        }
    }


    @Override
    public List<RetRole> getRolesByResourceId(Long resourceId) {
        RetRoleResourceRelationExample roleRelationExample = new RetRoleResourceRelationExample();
        roleRelationExample.createCriteria().andResourceIdEqualTo(resourceId);
        List<RetRoleResourceRelation> roleResourceRelations = roleResourceRelationMapper.selectByExample(roleRelationExample);
        List<RetRole> roles = new ArrayList<>();
        for (RetRoleResourceRelation resourceRoleRelation : roleResourceRelations){
            Long roleId = resourceRoleRelation.getRoleId();
            RetRole role = roleMapper.selectByPrimaryKey(roleId);
            roles.add(role);
        }
        return roles;
    }

    @Override
    public void deleteRoleResource(Long roleId, Long resourceId) {
        RetRoleResourceRelationExample roleResourceRelationExample = new RetRoleResourceRelationExample();
        roleResourceRelationExample.createCriteria().andRoleIdEqualTo(roleId).andResourceIdEqualTo(resourceId);
        int i = roleResourceRelationMapper.deleteByExample(roleResourceRelationExample);
        if (i == 0){
            Asserts.fail("删除角色资源失败");
        }
    }

    @Override
    public void deleteRole(Long roleId) {
        RetRoleResourceRelationExample relationExample = new RetRoleResourceRelationExample();
        relationExample.createCriteria().andRoleIdEqualTo(roleId);
        int i = roleResourceRelationMapper.deleteByExample(relationExample);
        if (i == 0){
            Asserts.fail("删除角色失败");
        }
    }

    @Override
    public List<RetResource> getRoleResources(Long roleId) {
        List<RetResource> resources = new ArrayList<>();
        RetRoleResourceRelationExample relationExample = new RetRoleResourceRelationExample();
        relationExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RetRoleResourceRelation> roleResourceRelations = roleResourceRelationMapper.selectByExample(relationExample);
        if ( roleResourceRelations.size() > 0){
            for (RetRoleResourceRelation relation :  roleResourceRelations){
                Long resourceId = relation.getResourceId();
                RetResource resourceByResourceId = resourceMapper.selectByPrimaryKey(resourceId);
                resources.add(resourceByResourceId);
            }
        }
        return resources;
    }

    @Override
    public void addResourceRoleRelation(Long roleId, Long resourceId) {
        RetRoleResourceRelation roleResourceRelation = new RetRoleResourceRelation();
        roleResourceRelation.setRoleId(roleId);
        roleResourceRelation.setResourceId(resourceId);
        int insert = roleResourceRelationMapper.insert(roleResourceRelation);
        if (insert == 0){
            Asserts.fail("增加角色失败");
        }
        refreshCacheByRoleId(roleId);
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
    public List<RetResource> listRoleResources(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        RetRole roleByRoleName = getRoleByRoleName(name);
        if (roleByRoleName == null){
            Asserts.fail("没有该角色");
        }
        return getRoleResources(roleByRoleName.getId());
    }

    @Override
    public void deleteResourceRoleRelation(Long id) {
        RetRoleResourceRelationExample relationExample = new RetRoleResourceRelationExample();
        relationExample.createCriteria().andResourceIdEqualTo(id);
        List<RetRoleResourceRelation> retRoleResourceRelations = roleResourceRelationMapper.selectByExample(relationExample);
        int deleteRelationCount = roleResourceRelationMapper.deleteByExample(relationExample);
        if (deleteRelationCount == 0){
            Asserts.fail("删除角色资源失败");
        }
        //刷新缓存
        for (RetRoleResourceRelation roleResourceRelation : retRoleResourceRelations){
            refreshCacheByRoleId(roleResourceRelation.getRoleId());
        }
    }
}
