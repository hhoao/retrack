package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.admin.service.RetRoleResourceRelationService;
import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理
 * @author hhoa
 * @date 2022/5/16
 **/
@RestController
@Tag(description = "RetRoleController", name = "角色管理")
@RequiredArgsConstructor
public class RetRoleController {
    private final RetRoleService roleService;
    private final RetRoleResourceRelationService resourceRoleRelationService;

    @Operation(summary = "授予角色资源")
    @PostMapping("/roles/{roleName}/resource/{resourceName}")
    public CommonResult<String> insertRoleResource(@PathVariable("roleName") String roleName,
                                                   @PathVariable("resourceName") String resourceName){
        resourceRoleRelationService.addRoleResource(roleName, resourceName);

        return CommonResult.success(null);
    }
    @Operation(summary = "分页获取角色所有资源")
    @GetMapping("/roles/{roleName}/resources")
    public CommonResult<CommonPage<RetResource>> listRoleResources(@Parameter(description = "角色名字") @PathVariable("roleName") String roleName,
                                                                   PageInfo pageInfo){
        List<RetResource> resources = resourceRoleRelationService.listRoleResources(roleName, pageInfo);
        return CommonResult.success(CommonPage.restPage(resources));
    }

    @Operation(summary = "删除角色资源")
    @DeleteMapping("/roles/{roleName}/resources/{resourceName}")
    public CommonResult<String> deleteRoleResource(@PathVariable("roleName") String roleName,
                                                   @PathVariable("resourceName") String resourceName){
        resourceRoleRelationService.deleteRoleResource(roleName, resourceName);
        return CommonResult.success(null);
    }
    @Operation(summary = "删除角色菜单")
    @DeleteMapping("/roles/{roleName}/menus/{menuId}")
    public CommonResult<String> deleteRoleMenu(@PathVariable("roleName") String roleName,
                                                   @PathVariable("menuId") Long menuId){
        roleService.deleteRoleMenu(roleName, menuId);
        return CommonResult.success(null);
    }
    @Operation(summary = "添加角色菜单")
    @PostMapping("/roles/{roleName}/menus/{menuId}")
    public CommonResult<String> addRoleMenu(@PathVariable("roleName") String roleName,
                                                   @PathVariable("menuId") Long menuId){
        roleService.addRoleMenu(roleName, menuId);
        return CommonResult.success(null);
    }

    @Operation(summary = "增加角色")
    @PostMapping("/roles")
    public CommonResult<String> addRole(@RequestBody RetRoleParam roleParam) {
        roleService.addRole(roleParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "分页获取角色列表")
    @GetMapping("/roles")
    public CommonResult<CommonPage<RetRole>> list(PageInfo pageInfo, RetRole role){
        List<RetRole> list = roleService.list(pageInfo, role);
        return CommonResult.success(CommonPage.restPage(list));
    }
    @Operation(summary = "删除角色")
    @DeleteMapping("/roles/{roleName}")
    public CommonResult<String> delRole(@PathVariable("roleName") String roleName){
        roleService.deleteRole(roleName);
        return CommonResult.success(null);
    }
    @Operation(summary = "修改角色")
    @PatchMapping("/roles/{roleName}")
    public CommonResult<String> updateRole(@PathVariable("roleName") String roleName,
                                           @RequestBody RetRoleParam roleParam){
        roleService.updateRole(roleName, roleParam);
        return CommonResult.success(null);
    }
}
