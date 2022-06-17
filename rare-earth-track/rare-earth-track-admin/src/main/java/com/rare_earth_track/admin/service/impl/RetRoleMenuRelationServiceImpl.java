package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetMenuService;
import com.rare_earth_track.admin.service.RetRoleMenuRelationService;
import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetRoleMenuRelationMapper;
import com.rare_earth_track.mgb.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/6/13
 **/

@Service
@RequiredArgsConstructor
public class RetRoleMenuRelationServiceImpl implements RetRoleMenuRelationService {
    private final RetRoleMenuRelationMapper roleMenuRelationMapper;
    private RetMenuService menuService;
    private RetRoleService roleService;

    @Autowired
    @Lazy
    public void setRoleService(RetRoleService roleService) {
        this.roleService = roleService;
    }

    @Lazy
    @Autowired
    public void setMenuService(RetMenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public List<RetMenu> getMenus(Long roleId) {
        RetRoleMenuRelationExample menuRelationExample = new RetRoleMenuRelationExample();
        menuRelationExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RetRoleMenuRelation> retRoleMenuRelations = roleMenuRelationMapper.selectByExample(menuRelationExample);
        List<RetMenu> menus = new ArrayList<>();
        for (RetRoleMenuRelation roleMenuRelation : retRoleMenuRelations){
            menus.add(menuService.getMenu(roleMenuRelation.getMenuId()));
        }
        return menus;
    }

    @Override
    public void deleteRoleMenus(Long roleId) {
        RetRoleMenuRelationExample roleMenuRelationExample = new RetRoleMenuRelationExample();
        roleMenuRelationExample.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationMapper.deleteByExample(roleMenuRelationExample);
    }

    @Override
    public void deleteRoleMenu(Long roleId, Long menuId) {
        RetRoleMenuRelationExample roleMenuRelationExample = new RetRoleMenuRelationExample();
        roleMenuRelationExample.createCriteria().
                andRoleIdEqualTo(roleId).
                andMenuIdEqualTo(menuId);
        int i = roleMenuRelationMapper.deleteByExample(roleMenuRelationExample);
        if (i == 0){
            Asserts.fail("该角色没有该菜单");
        }
    }

    @Override
    public void addRoleMenu(Long roleId, Long menuId) {
        RetRoleMenuRelation roleMenuRelation = new RetRoleMenuRelation();
        roleMenuRelation.setRoleId(roleId);
        roleMenuRelation.setMenuId(menuId);
        roleMenuRelationMapper.insert(roleMenuRelation);
    }
    @Override
    public List<RetRole> getRoles(Long menuId) {
        RetRoleMenuRelationExample roleRelationExample = new RetRoleMenuRelationExample();
        roleRelationExample.createCriteria().andMenuIdEqualTo(menuId);
        List<RetRoleMenuRelation> roleMenuRelations = roleMenuRelationMapper.selectByExample(roleRelationExample);
        List<RetRole> roles = new ArrayList<>();
        for (RetRoleMenuRelation menuRoleRelation : roleMenuRelations){
            Long roleId = menuRoleRelation.getRoleId();
            RetRole role = roleService.getRole(roleId);
            roles.add(role);
        }
        return roles;
    }
    @Override
    public List<RetRole> getRoles(String menuName) {
        RetMenu menu = menuService.getMenu(menuName);
        return  getRoles(menu.getId());
    }


    @Override
    public List<RetMenu> getRoleMenus(Long roleId) {
        List<RetMenu> byRoleName = new ArrayList<>();
        RetRoleMenuRelationExample roleMenuRelationExample = new RetRoleMenuRelationExample();
        roleMenuRelationExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RetRoleMenuRelation> retRoleMenuRelations = roleMenuRelationMapper.selectByExample(roleMenuRelationExample);
        for (RetRoleMenuRelation roleMenuRelation : retRoleMenuRelations){
            byRoleName.add(menuService.getMenu(roleMenuRelation.getMenuId()));
        }
        return byRoleName;
    }

    @Override
    public List<RetMenu> listRoleMenus(String name, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetRole roleByRoleName = roleService.getRole(name);
        if (roleByRoleName == null){
            Asserts.fail("没有该角色");
        }
        return getRoleMenus(roleByRoleName.getId());
    }

    @Override
    public void deleteRoleMenu(Long menuId) {
        RetRoleMenuRelationExample relationExample = new RetRoleMenuRelationExample();
        relationExample.createCriteria().andMenuIdEqualTo(menuId);
        List<RetRoleMenuRelation> retRoleMenuRelations = roleMenuRelationMapper.selectByExample(relationExample);
        int deleteRelationCount = roleMenuRelationMapper.deleteByExample(relationExample);
        if (deleteRelationCount == 0){
            Asserts.fail("删除角色资源失败");
        }
        //刷新缓存
        for (RetRoleMenuRelation roleMenuRelation : retRoleMenuRelations){
            roleService.refreshCache(roleMenuRelation.getRoleId());
        }
    }

    @Override
    public void deleteRoleMenu(String roleName, String menuName) {
        RetRole role = roleService.getRole(roleName);
        RetMenu menu = menuService.getMenu(menuName);
        deleteRoleMenu(role.getId(), menu.getId());
    }

    @Override
    public void addRoleMenu(String roleName, String menuName) {
        RetMenu menu = menuService.getMenu(menuName);
        RetRole role = roleService.getRole(roleName);
        addRoleMenu(role.getId(), menu.getId());
    }
}
