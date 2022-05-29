package com.rare_earth_track.admin.controller;

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
@RequiredArgsConstructor
@Tag(description = "RetRoleController", name = "角色管理")
public class RetRoleController {
    private final RetRoleService roleService;
    private final RetRoleResourceRelationService resourceRoleRelationService;

    @Operation(summary = "授予角色资源")
    @PostMapping("/role/{roleId}/resource/{resourceId}")
    public CommonResult<String> insertRoleResource(@PathVariable("roleId") Long roleId,
                                                   @PathVariable("resourceId") Long resourceId){
        resourceRoleRelationService.addResourceRoleRelation(roleId, resourceId);

        return CommonResult.success(null);
    }
    @Operation(summary = "分页获取角色所有资源")
    @GetMapping("/roles/{roleName}/resources")
    public CommonResult<CommonPage<RetResource>> listRoleResources(@Parameter(description = "角色名字") @PathVariable("roleName") String roleName,
                                                                   @Parameter(description = "页码") @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                   @Parameter(description = "页面大小") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<RetResource> resources = resourceRoleRelationService.listRoleResources(roleName, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(resources));
    }

    @Operation(summary = "删除角色资源")
    @DeleteMapping("/roles/{roleId}/resources/{resourceId}")
    public CommonResult<String> deleteRoleResource(@PathVariable("roleId") Long roleId,
                                                   @PathVariable("resourceId") Long resourceId){
        resourceRoleRelationService.deleteRoleResource(roleId, resourceId);
        return CommonResult.success(null);
    }

    @Operation(summary = "增加角色")
    @PostMapping("/role")
    public CommonResult<String> addRole(@RequestBody RetRoleParam roleParam) {
        roleService.addRole(roleParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "分页获取角色列表")
    @GetMapping("/roles")
    public CommonResult<CommonPage<RetRole>> list(@Parameter(description = "页码") @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                  @Parameter(description = "页面大小") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<RetRole> list = roleService.list(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }
    @Operation(summary = "删除角色")
    @DeleteMapping("/role/{id}")
    public CommonResult<String> delRole(@PathVariable("id") Long roleId){
        roleService.deleteRole(roleId);

        return CommonResult.success(null);
    }
    @Operation(summary = "修改角色")
    @PatchMapping("/role")
    public CommonResult<String> updateRole(@RequestBody RetRoleParam roleParam){
        roleService.updateRole(roleParam);
        return CommonResult.success(null);
    }
}
