package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetMenuParam;
import com.rare_earth_track.admin.service.RetMenuService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hhoa
 * @date 2022/6/17
 **/

class RetMenuServiceImplTest extends TransactionTest {
    @Autowired
    RetMenuService menuService;

    @Test
    void getMenu() {
        RetMenu allGetMenus = menuService.getMenu("home");
        assertNotNull(allGetMenus);
        RetMenu menu = menuService.getMenu(1L);
        assertEquals(menu.getName(), allGetMenus.getName());
    }

    @Test
    void getAllMenus() {
        List<RetMenu> allMenus = menuService.getAllMenus();
        Assertions.assertTrue(allMenus.size() > 0);
    }


    @Test
    void addMenu() {
        RetMenuParam menuParam = new RetMenuParam();
        menuParam.setLevel(0);
        menuParam.setName("哈哈哈");
        menuParam.setHidden(1);
        menuService.addMenu(menuParam);
        assertNotNull(menuService.getMenu("哈哈哈"));

    }

    @Test
    void updateMenu() {
        RetMenuParam menuParam = new RetMenuParam();
        menuParam.setTitle("GET");
        menuParam.setName("我的世界");
        menuService.updateMenu("home", menuParam);
        assertNotNull(menuService.getMenu("我的世界"));
    }

    @ParameterizedTest
    @ValueSource(longs = {1L})
    void deleteMenu(Long menuId) {
        menuService.deleteMenu(menuId);
        assertThrows(ApiException.class, ()-> menuService.getMenu(menuId));
    }
    @ParameterizedTest
    @ValueSource(strings = {"home"})
    void deleteMenu(String menuName) {
        menuService.deleteMenu(menuName);
        assertThrows(ApiException.class, ()-> menuService.getMenu(menuName));
    }

    static List<Object[]> listParamsProvider(){
        List<Object[]> params = new ArrayList<>();
        RetMenu menu1 = new RetMenu();
        menu1.setHidden(0);
        params.add(new Object[]{new PageInfo(1, 5), menu1});

        RetMenu menu2 = new RetMenu();
        menu2.setId(1L);
        params.add(new Object[]{new PageInfo(1, 5), menu2});

        RetMenu menu3 = new RetMenu();
        menu3.setName("home");
        params.add(new Object[]{new PageInfo(1, 5), menu3});
        return params;
    }

    @ParameterizedTest
    @MethodSource("listParamsProvider")
    void list(PageInfo pageInfo, RetMenu menu) {
        List<RetMenu> list = menuService.list(pageInfo, menu);
        Assertions.assertTrue(list.size() > 0);
    }
}