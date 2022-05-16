package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.RetResourceRoleRelationParam;
import com.rare_earth_track.admin.service.RetResourceRoleRelationService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色资源管理
 * @author hhoa
 * @date 2022/5/16
 **/
@RestController
@RequiredArgsConstructor
@Tag(description = "RetRoleResourceController", name = "角色资源管理")
public class RetRoleResourceController {
    private final RetResourceRoleRelationService resourceRoleRelationService;

    @Operation(summary = "授予角色资源")
    @PostMapping("/relations/role-resource")
    public CommonResult<String> insertRoleResourceRelation(@RequestBody RetResourceRoleRelationParam roleResourceRelationParam){
        int i = resourceRoleRelationService.addResourceRoleRelation(roleResourceRelationParam);
        if (i == 0){
            return CommonResult.failed("插入失败");
        }
        return CommonResult.success(null);
    }
    @Operation(summary = "分页获取角色所有资源")
    @GetMapping("/roles/{roleName}/resources")
    public CommonResult<CommonPage<RetResource>> listRoleResources(@Parameter(description = "角色名字") @PathVariable("roleName") String roleName,
                                                                   @Parameter(description = "页面起始") @RequestParam(value = "from", defaultValue = "1") Integer from,
                                                                   @Parameter(description = "页面大小") @RequestParam(value = "size", defaultValue = "5") Integer size){
        List<RetResource> resources = resourceRoleRelationService.listRoleResources(roleName, from, size);
        return CommonResult.success(CommonPage.restPage(resources));
    }
}

