package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetMenuParam;
import com.rare_earth_track.admin.service.RetMenuService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetMenu;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/6/13
 **/

@RestController
@RequiredArgsConstructor
@Tag(name = "菜单管理", description = "RetMenuController")
public class RetMenuController {
    private final RetMenuService menuService;
    @Operation(description = "分页获取菜单列表", summary = "分页获取菜单列表")
    @GetMapping("/menus")
    public CommonResult<CommonPage<RetMenu>> list(PageInfo pageInfo,
                                                  RetMenu menuParams){
        List<RetMenu> allMenus = menuService.list(pageInfo, menuParams);
        return CommonResult.success(CommonPage.restPage(allMenus));
    }

    @Operation(description = "添加菜单", summary = "添加菜单")
    @PostMapping("/menus")
    public CommonResult<String> addMenu(@RequestBody RetMenuParam menuParam){
        menuService.addMenu(menuParam);
        return CommonResult.success(null);
    }
    @Operation(summary = "修改菜单")
    @PatchMapping("/menus/{menuName}")
    public CommonResult<String> updateMenu(@PathVariable("menuName") String menuName,
                                               @RequestBody RetMenuParam menuParam){
        menuService.updateMenu(menuName, menuParam);
        return CommonResult.success(null);
    }
    @Operation(summary = "删除菜单")
    @DeleteMapping("/menus/{menuName}")
    public CommonResult<String> delMenu(@PathVariable String menuName){
        menuService.deleteMenu(menuName);
        return CommonResult.success(null);
    }
}
