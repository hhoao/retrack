package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.admin.service.*;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetRoleMapper;
import com.rare_earth_track.mgb.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
@Service
@RequiredArgsConstructor
public class RetRoleServiceImpl implements RetRoleService, ApplicationRunner {
    private final RetRoleMapper roleMapper;
    private RetRoleResourceRelationService roleResourceRelationService;
    private RetRoleResourceCacheService resourceCacheService;
    private RetAdministratorService administratorService;
    private RetRoleMenuRelationService roleMenuRelationService;

    @Lazy
    @Autowired
    public void setRoleResourceRelationService(RetRoleResourceRelationService roleResourceRelationService) {
        this.roleResourceRelationService = roleResourceRelationService;
    }
    @Autowired
    @Lazy
    public void setResourceCacheService(RetRoleResourceCacheService resourceCacheService) {
        this.resourceCacheService = resourceCacheService;
    }

    @Autowired
    @Lazy
    public void setAdministratorService(RetAdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @Autowired
    @Lazy
    public void setRoleMenuRelationService(RetRoleMenuRelationService roleMenuRelationService) {
        this.roleMenuRelationService = roleMenuRelationService;
    }

    @Override
    public void refreshCache(Long roleId){
        RetRole role = getRole(roleId);
        List<RetResource> roleResources = getRoleResources(role.getId(), false);
        resourceCacheService.setByRoleName(roleResources, role.getName());
    }
    @Override
    public void refreshCache(RetRole role){
        List<RetResource> roleResources = getRoleResources(role.getId(), false);
        resourceCacheService.setByRoleName(roleResources, role.getName());
    }
    @Override
    public void refreshCache(String roleName){
        RetRole role = getRole(roleName);
        List<RetResource> roleResources = getRoleResources(role.getId(), false);
        resourceCacheService.setByRoleName(roleResources, role.getName());
    }
    @Override
    public void refreshCache(){
        List<RetRole> roles = getAllRoles();
        for (RetRole role : roles) {
            List<RetResource> roleResources = getRoleResources(role.getId(), false);
            resourceCacheService.setByRoleName(roleResources, role.getName());
        }
    }
    @Override
    public void updateRole(String roleName, RetRoleParam roleParam) {
        RetRole role = getRole(roleName);
        RetRole newRole = new RetRole();
        BeanUtils.copyProperties(roleParam, newRole);
        newRole.setId(role.getId());
        int i = roleMapper.updateByPrimaryKey(newRole);
        if (i == 0){
            Asserts.fail("修改角色失败");
        }
    }
    @Override
    public List<RetResource> getRoleResources(Long roleId){
        return roleResourceRelationService.getRoleResources(roleId, false);
    }
    @Override
    public List<RetResource> getRoleResources(Long roleId, Boolean disableCache){
        return roleResourceRelationService.getRoleResources(roleId, disableCache);
    }
    @Override
    public RetRole getRole(String roleName) {
        RetRoleExample retRoleExample = new RetRoleExample();
        retRoleExample.createCriteria().andNameEqualTo(roleName);
        List<RetRole> retRoles = roleMapper.selectByExample(retRoleExample);

        if (retRoles.size() == 0){
            Asserts.fail("没有该角色");
        }
        return retRoles.get(0);
    }
    @Override
    public RetRole getRole(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public void addRole(RetRoleParam roleParam) {
        RetRole role = new RetRole();
        BeanUtil.copyProperties(roleParam, role);
        int insert = roleMapper.insert(role);
        if (insert == 0){
            Asserts.fail("插入角色失败");
        }
    }

    @Override
    public List<RetRole> getAllRoles() {
        return roleMapper.selectByExample(new RetRoleExample());
    }

    private RetRoleExample getRoleExample(RetRole role){
        RetRoleExample roleExample = new RetRoleExample();
        if (role != null){
            RetRoleExample.Criteria criteria = roleExample.createCriteria();
            if (role.getId() != null){
                criteria.andIdEqualTo(role.getId());
            }
            if (role.getName() != null){
                criteria.andNameEqualTo(role.getName());
            }
            if (role.getDescription() != null){
                criteria.andDescriptionLike(role.getDescription());
            }
            if (role.getStatus() != null){
                criteria.andStatusEqualTo(role.getStatus());
            }
        }
        return roleExample;
    }

    @Override
    public List<RetRole> list(PageInfo pageInfo, RetRole role) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return roleMapper.selectByExample(getRoleExample(role));
    }

    /**
     * 删除引用
     * @param roleId 角色id
     */
    private void deleteReference(Long roleId){
        RetAdministrator administrator = new RetAdministrator();
        administrator.setRoleId(roleId);
        administratorService.deleteAdministrators(administrator);
    }

    @Override
    public void deleteRole(String roleName) {
        RetRole role = getRole(roleName);
        roleMenuRelationService.deleteRoleMenus(role.getId());
        roleResourceRelationService.deleteRoleResources(role.getId());
        deleteReference(role.getId());


        int i = roleMapper.deleteByPrimaryKey(role.getId());
        if (i == 0){
            Asserts.fail("删除角色失败");
        }
    }

    @Override
    public List<RetMenu> getMenus(Long roleId) {
        return roleMenuRelationService.getMenus(roleId);
    }

    @Override
    public void deleteRoleMenu(String roleName, Long menuId) {
        RetRole role = getRole(roleName);
        roleMenuRelationService.deleteRoleMenu(role.getId(), menuId);
        refreshCache(role.getId());
    }

    @Override
    public void addRoleMenu(String roleName, Long menuId) {
        RetRole role = getRole(roleName);
        roleMenuRelationService.addRoleMenu(role.getId(), menuId);
        refreshCache(role.getId());
    }

    @Override
    public List<RetMenu> listMenus(PageInfo pageInfo, String roleName) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetRole role = getRole(roleName);
        return getMenus(role.getId());
    }

    @Override
    public void allocMenus(String roleName, List<Long> menuIds) {
        roleMenuRelationService.deleteExistsMenu(roleName);
        RetRole role = getRole(roleName);
        for (Long menuId : menuIds) {
            roleMenuRelationService.addRoleMenu(role.getId(), menuId);
        }
    }

    @Override
    public void allocResources(String roleName, List<Long> resourceIds) {
        RetRole role = getRole(roleName);
        roleResourceRelationService.deleteRoleResources(role.getId());
        for (Long resourceId : resourceIds){
            roleResourceRelationService.addRoleResource(role.getId(), resourceId);
        }
    }

    @Override
    public void run(ApplicationArguments args) {
        //初始化 将所有角色对应资源加载进缓存中
        refreshCache();
    }
}
