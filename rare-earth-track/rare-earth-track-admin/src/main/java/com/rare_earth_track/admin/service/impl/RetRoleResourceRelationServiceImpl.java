package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.*;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetRoleResourceRelationMapper;
import com.rare_earth_track.mgb.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
@Service
@RequiredArgsConstructor
public class RetRoleResourceRelationServiceImpl implements RetRoleResourceRelationService {
    private final RetRoleResourceRelationMapper roleResourceRelationMapper;
    private RetResourceService resourceService;
    private RetRoleService roleService;
    private RetRoleResourceCacheService roleResourceCacheService;

    @Autowired
    @Lazy
    public void setResourceService(RetResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Autowired
    @Lazy
    public void setRoleService(RetRoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    @Lazy
    public void setRoleResourceCacheService(RetRoleResourceCacheService roleResourceCacheService) {
        this.roleResourceCacheService = roleResourceCacheService;
    }

    @Override
    public List<RetRole> getRoles(Long resourceId) {
        RetRoleResourceRelationExample roleRelationExample = new RetRoleResourceRelationExample();
        roleRelationExample.createCriteria().andResourceIdEqualTo(resourceId);
        List<RetRoleResourceRelation> roleResourceRelations = roleResourceRelationMapper.selectByExample(roleRelationExample);
        List<RetRole> roles = new ArrayList<>();
        for (RetRoleResourceRelation resourceRoleRelation : roleResourceRelations) {
            Long roleId = resourceRoleRelation.getRoleId();
            RetRole role = roleService.getRole(roleId);
            roles.add(role);
        }
        return roles;
    }

    @Override
    public List<RetRole> getRoles(String resourceName) {
        RetResource resource = resourceService.getResource(resourceName);
        return getRoles(resource.getId());
    }

    @Override
    public void deleteRoleResource(Long roleId, Long resourceId) {
        RetRoleResourceRelationExample roleResourceRelationExample = new RetRoleResourceRelationExample();
        roleResourceRelationExample.createCriteria().andRoleIdEqualTo(roleId).andResourceIdEqualTo(resourceId);
        int i = roleResourceRelationMapper.deleteByExample(roleResourceRelationExample);
        if (i == 0) {
            Asserts.fail("删除角色资源失败");
        } else {
            //刷新缓存
            roleService.refreshCache(roleId);
        }
    }

    @Override
    public void deleteRoleResources(Long roleId) {
        RetRoleResourceRelationExample relationExample = new RetRoleResourceRelationExample();
        relationExample.createCriteria().andRoleIdEqualTo(roleId);
        int i = roleResourceRelationMapper.deleteByExample(relationExample);
        if (i != 0) {
            //刷新缓存
            roleService.refreshCache(roleId);
        }
    }
    @Override
    public List<RetResource> getRoleResources(Long roleId) {
        return getRoleResources(roleId, false);
    }
    @Override
    public List<RetResource> getRoleResources(Long roleId, Boolean disableCache) {
        RetRole retRole = roleService.getRole(roleId);
        List<RetResource> byRoleName;
        if (disableCache == null) {
            byRoleName = roleResourceCacheService.getByRoleName(retRole.getName());
        }
        else {
            byRoleName = new ArrayList<>();
            RetRoleResourceRelationExample roleResourceRelationExample = new RetRoleResourceRelationExample();
            roleResourceRelationExample.createCriteria().andRoleIdEqualTo(roleId);
            List<RetRoleResourceRelation> retRoleResourceRelations = roleResourceRelationMapper.selectByExample(roleResourceRelationExample);
            for (RetRoleResourceRelation roleResourceRelation : retRoleResourceRelations) {
                byRoleName.add(resourceService.getResource(roleResourceRelation.getResourceId()));
            }
        }
        return byRoleName;
    }

    @Override
    public void addRoleResource(Long roleId, Long resourceId) {
        RetRoleResourceRelation roleResourceRelation = new RetRoleResourceRelation();
        roleResourceRelation.setRoleId(roleId);
        roleResourceRelation.setResourceId(resourceId);
        int insert = roleResourceRelationMapper.insert(roleResourceRelation);
        if (insert == 0) {
            Asserts.fail("增加角色失败");
        }
        roleService.refreshCache(roleId);
    }

    @Override
    public List<RetResource> listRoleResources(String name, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetRole roleByRoleName = roleService.getRole(name);
        if (roleByRoleName == null) {
            Asserts.fail("没有该角色");
        }
        return getRoleResources(roleByRoleName.getId());
    }

    @Override
    public void deleteRoleResource(Long id) {
        RetRoleResourceRelationExample relationExample = new RetRoleResourceRelationExample();
        relationExample.createCriteria().andResourceIdEqualTo(id);
        List<RetRoleResourceRelation> retRoleResourceRelations = roleResourceRelationMapper.selectByExample(relationExample);
        int deleteRelationCount = roleResourceRelationMapper.deleteByExample(relationExample);
        if (deleteRelationCount != 0) {
            //刷新缓存
            for (RetRoleResourceRelation roleResourceRelation : retRoleResourceRelations) {
                roleService.refreshCache(roleResourceRelation.getRoleId());
            }
        }
    }

    @Override
    public void deleteRoleResource(String roleName, String resourceName) {
        RetRole role = roleService.getRole(roleName);
        RetResource resource = resourceService.getResource(resourceName);
        deleteRoleResource(role.getId(), resource.getId());
    }

    @Override
    public void addRoleResource(String roleName, String resourceName) {
        RetResource resource = resourceService.getResource(resourceName);
        RetRole role = roleService.getRole(roleName);
        addRoleResource(role.getId(), resource.getId());
    }

}
