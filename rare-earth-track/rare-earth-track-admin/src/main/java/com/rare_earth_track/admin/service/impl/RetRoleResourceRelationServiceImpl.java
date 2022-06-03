package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.admin.service.RetRoleResourceCacheService;
import com.rare_earth_track.admin.service.RetRoleResourceRelationService;
import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetRoleResourceRelationMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;
import com.rare_earth_track.mgb.model.RetRoleResourceRelation;
import com.rare_earth_track.mgb.model.RetRoleResourceRelationExample;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
@Service
public class RetRoleResourceRelationServiceImpl implements RetRoleResourceRelationService {
//    @Lazy
//    @Autowired
    private RetRoleResourceRelationMapper roleResourceRelationMapper;
//    @Lazy
//    @Autowired
    private RetResourceService resourceService;
//    @Lazy
//    @Autowired
    private RetRoleService roleService;
//    @Lazy
//    @Autowired
    private RetRoleResourceCacheService roleResourceCacheService;

    @Lazy
    public RetRoleResourceRelationServiceImpl(RetRoleResourceRelationMapper roleResourceRelationMapper,
                                              RetResourceService resourceService,
                                              RetRoleService roleService,
                                              RetRoleResourceCacheService roleResourceCacheService) {
        this.roleResourceRelationMapper = roleResourceRelationMapper;
        this.resourceService = resourceService;
        this.roleService = roleService;
        this.roleResourceCacheService =  roleResourceCacheService;

    }
    @Override
    public List<RetRole> getRoles(Long resourceId) {
        RetRoleResourceRelationExample roleRelationExample = new RetRoleResourceRelationExample();
        roleRelationExample.createCriteria().andResourceIdEqualTo(resourceId);
        List<RetRoleResourceRelation> roleResourceRelations = roleResourceRelationMapper.selectByExample(roleRelationExample);
        List<RetRole> roles = new ArrayList<>();
        for (RetRoleResourceRelation resourceRoleRelation : roleResourceRelations){
            Long roleId = resourceRoleRelation.getRoleId();
            RetRole role = roleService.getRole(roleId);
            roles.add(role);
        }
        return roles;
    }
    @Override
    public List<RetRole> getRoles(String resourceName) {
        RetResource resource = resourceService.getResource(resourceName);
        return  getRoles(resource.getId());
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
        RetRole retRole = roleService.getRole(roleId);
        List<RetResource> byRoleName = roleResourceCacheService.getByRoleName(retRole.getName());
        if (byRoleName == null){
            return new ArrayList<>();
        }
        return byRoleName;
    }

    @Override
    public void addRoleResource(Long roleId, Long resourceId) {
        RetRoleResourceRelation roleResourceRelation = new RetRoleResourceRelation();
        roleResourceRelation.setRoleId(roleId);
        roleResourceRelation.setResourceId(resourceId);
        int insert = roleResourceRelationMapper.insert(roleResourceRelation);
        if (insert == 0){
            Asserts.fail("增加角色失败");
        }
        roleService.refreshCache(roleId);
    }
    @Override
    public List<RetResource> listRoleResources(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        RetRole roleByRoleName = roleService.getRole(name);
        if (roleByRoleName == null){
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
        if (deleteRelationCount == 0){
            Asserts.fail("删除角色资源失败");
        }
        //刷新缓存
        for (RetRoleResourceRelation roleResourceRelation : retRoleResourceRelations){
            roleService.refreshCache(roleResourceRelation.getRoleId());
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
