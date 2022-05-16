package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
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

    @Operation(summary = "增加角色")
    @PostMapping("/role")
    public CommonResult<String> addRole(@RequestBody RetRoleParam roleParam) {
        int i = roleService.addRole(roleParam);
        if (i == 0) {
            return CommonResult.failed("插入失败");
        }
        return CommonResult.success(null);
    }

    @Operation(summary = "获取所有角色")
    @GetMapping("/roles")
    public CommonResult<List<RetRole>> getAllRoles() {
        List<RetRole> allRoles = roleService.getAllRoles();
        return CommonResult.success(allRoles);
    }
    @Operation(summary = "分页获取角色列表")
    @GetMapping()
    public CommonResult<CommonPage<RetRole>> list(@Parameter(description = "页面起始") @RequestParam(value = "from", defaultValue = "1") Integer from,
                                                  @Parameter(description = "页面大小") @RequestParam(value = "size", defaultValue = "5") Integer size){
        List<RetRole> list = roleService.list(from, size);
        return CommonResult.success(CommonPage.restPage(list));
    }
}
