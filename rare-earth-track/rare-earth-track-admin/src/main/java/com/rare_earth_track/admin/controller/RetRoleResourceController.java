package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.RetResourceRoleRelationParam;
import com.rare_earth_track.admin.service.RetResourceRoleRelationService;
import com.rare_earth_track.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhoa
 * @date 2022/5/16
 **/
@RestController
@RequiredArgsConstructor
@Tag(description = "RetRoleResourceController", name = "角色资源管理")
public class RetRoleResourceController {
    private final RetResourceRoleRelationService resourceRoleRelationService;

    @Operation(description = "授予角色资源", summary = "授予角色资源")
    @PostMapping("/relations/role-resource")
    public CommonResult<String> insertRoleResourceRelation(@RequestBody RetResourceRoleRelationParam roleResourceRelationParam){
        int i = resourceRoleRelationService.addResourceRoleRelation(roleResourceRelationParam);
        if (i == 0){
            return CommonResult.failed("插入失败");
        }
        return CommonResult.success(null);
    }
}
