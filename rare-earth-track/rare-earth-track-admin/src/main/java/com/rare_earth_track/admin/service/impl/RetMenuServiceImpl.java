package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetMenuParam;
import com.rare_earth_track.admin.service.RetMenuService;
import com.rare_earth_track.admin.service.RetRoleMenuRelationService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMenuMapper;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetMenuExample;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/6/13
 **/

@Service
@RequiredArgsConstructor
public class RetMenuServiceImpl implements RetMenuService {
    private final RetMenuMapper menuMapper;

    private RetRoleMenuRelationService roleMenuRelationService;
    @Lazy
    @Autowired
    public void setRoleMenuRelationService(RetRoleMenuRelationService roleMenuRelationService) {
        this.roleMenuRelationService = roleMenuRelationService;
    }


    @Override
    public RetMenu getMenu(String menuName) {
        RetMenuExample menuExample = new RetMenuExample();
        menuExample.createCriteria().andNameEqualTo(menuName);
        List<RetMenu> retMenus = menuMapper.selectByExample(menuExample);
        if (retMenus.size() == 0){
            Asserts.fail("没有该菜单");
        }
        return retMenus.get(0);
    }

    @Override
    public RetMenu getMenu(Long menuId) {
        RetMenu retMenu = menuMapper.selectByPrimaryKey(menuId);
        if (retMenu == null){
            Asserts.fail("没有该菜单");
        }
        return retMenu;
    }

    @Override
    public List<RetMenu> getAllMenus() {
        return menuMapper.selectByExample(new RetMenuExample());
    }

    private RetMenuExample getMenuExample(RetMenu menu){
        RetMenuExample menuExample = new RetMenuExample();
        if (menu != null) {
            if (menu.getName() != null) {
                menuExample.createCriteria().andNameEqualTo(menu.getName());
            }
            if (menu.getId() != null) {
                menuExample.createCriteria().andIdEqualTo(menu.getId());
            }
            if (menu.getHidden() != null) {
                menuExample.createCriteria().andHiddenEqualTo(menu.getHidden());
            }
            if (menu.getTitle() != null) {
                menuExample.createCriteria().andTitleLike(menu.getTitle());
            }
        }
        return menuExample;
    }

    @Override
    public List<RetMenu> list(PageInfo pageInfo, RetMenu menuParams) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetMenuExample menuExample = getMenuExample(menuParams);
        return menuMapper.selectByExample(menuExample);
    }


    @Override
    public void addMenu(RetMenuParam menuParam) {
        RetMenu menu = new RetMenu();
        BeanUtil.copyProperties(menuParam, menu);
        int insert = menuMapper.insert(menu);
        if (insert == 0){
            Asserts.fail("插入资源失败");
        }
    }

    @Override
    public void updateMenu(String menuName, RetMenuParam menuParam) {
        RetMenu menuByName = getMenu(menuName);

        BeanUtils.copyProperties(menuParam, menuByName);
        int successCount = menuMapper.updateByPrimaryKeySelective(menuByName);
        if (successCount == 0){
            Asserts.fail("更新失败");
        }
    }
    @Override
    public void deleteMenu(Long menuId) {
        //删除角色菜单关系
        roleMenuRelationService.deleteRoleMenu(menuId);
        //删除菜单
        int i = menuMapper.deleteByPrimaryKey(menuId);
        if (i == 0){
            Asserts.fail("删除资源失败");
        }
    }

    @Override
    public void deleteMenu(String menuName) {
        //删除角色菜单关系
        RetMenu menu = getMenu(menuName);
        roleMenuRelationService.deleteRoleMenu(menu.getId());
        //删除菜单
        RetMenuExample menuExample = new RetMenuExample();
        menuExample.createCriteria().andNameEqualTo(menuName);
        int i = menuMapper.deleteByExample(menuExample);
        if (i == 0){
            Asserts.fail("删除资源失败");
        }
    }
}
