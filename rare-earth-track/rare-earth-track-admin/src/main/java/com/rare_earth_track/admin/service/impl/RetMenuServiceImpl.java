package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetMenuService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMenuMapper;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetMenuExample;
import com.rare_earth_track.security.util.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/6/13
 **/

@RequiredArgsConstructor
@Service
public class RetMenuServiceImpl implements RetMenuService {
    private final RetMenuMapper menuMapper;
    private final JwtTokenService jwtTokenService;
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

}
