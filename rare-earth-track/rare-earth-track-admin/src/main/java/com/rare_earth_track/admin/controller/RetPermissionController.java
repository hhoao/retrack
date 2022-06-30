package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetPermissionParam;
import com.rare_earth_track.admin.service.RetPermissionService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetPermission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限管理
 * @author hhoa
 * @date 2022/5/16
 **/
@RestController
@AllArgsConstructor
@Tag(description = "RetPermissionController", name = "权限管理")
public class RetPermissionController {
    private final RetPermissionService permissionService;

    @Operation(description = "分页获取权限列表", summary = "分页获取资源列表")
    @GetMapping("/permissions")
    public CommonResult<CommonPage<RetPermission>> list(PageInfo pageInfo,
                                                      RetPermission permission){
        List<RetPermission> allPermissions = permissionService.list(pageInfo , permission);
        return CommonResult.success(CommonPage.restPage(allPermissions));
    }

    @Operation(description = "添加权限", summary = "添加资源")
    @PostMapping("/permissions")
    public CommonResult<String> addPermission(@RequestBody RetPermissionParam permissionParam){
        permissionService.addPermission(permissionParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "修改权限")
    @PatchMapping("/permissions/{permissionName}")
    public CommonResult<String> updatePermission(@PathVariable("permissionName") String permissionName,
                                               @RequestBody RetPermissionParam permissionParam){
        permissionService.updatePermission(permissionName, permissionParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "删除权限")
    @DeleteMapping("/permissions/{permissionName}")
    public CommonResult<String> delPermission(@PathVariable("permissionName") String permissionName){
        permissionService.deletePermission(permissionName);
        return CommonResult.success(null);
    }
}
