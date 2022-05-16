package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/16
 **/
@RestController
@RequiredArgsConstructor
@Tag(description = "RetRoleController", name = "角色管理")
public class RetRoleController {
    private final RetRoleService retRoleService;

    @Operation(summary = "增加角色")
    @PostMapping("/role")
    public CommonResult<String> addRole(@RequestBody RetRoleParam roleParam){
        int i = retRoleService.addRole(roleParam);
        if (i == 0){
            return CommonResult.failed("插入失败");
        }
        return CommonResult.success(null);
    }
    @Operation(summary = "获取所有角色")
    @GetMapping("/roles")
    public CommonResult<List<RetRole>> getAllRoles(){
        List<RetRole> allRoles = retRoleService.getAllRoles();
        return CommonResult.success(allRoles);
    }
}
