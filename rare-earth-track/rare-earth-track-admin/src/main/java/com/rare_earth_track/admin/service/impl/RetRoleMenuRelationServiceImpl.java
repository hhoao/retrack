package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetMenuService;
import com.rare_earth_track.admin.service.RetRoleMenuRelationService;
import com.rare_earth_track.mgb.mapper.RetRoleMenuRelationMapper;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetRoleMenuRelation;
import com.rare_earth_track.mgb.model.RetRoleMenuRelationExample;
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
}
