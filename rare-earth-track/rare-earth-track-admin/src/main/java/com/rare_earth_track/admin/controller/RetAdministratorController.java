package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.RetAdministratorService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetAdministrator;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetAdministrator;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员管理
 * @author hhoa
 * @date 2022/5/8
 **/
@AllArgsConstructor
@Tags({@Tag(name = "管理员管理", description = "RetAdministratorController")})
@RestController
public class RetAdministratorController {
    private final RetAdministratorService administratorService;
    private final JwtSecurityProperties securityProperties;

    @Operation(summary = "已认证分页获取管理员角色菜单")
    @GetMapping("/administrator/role/menus")
    public CommonResult<CommonPage<RetMenu>> getAdministratorRoleMenus(@RequestHeader Map<String, String> headers){
        List<RetMenu> menus = administratorService.getMenusByAuthorization(
                headers.get(securityProperties.getTokenHeader().toLowerCase()));
        return CommonResult.success(CommonPage.restPage(menus));
    }

    @Operation(summary = "已认证获取管理员信息")
    @GetMapping("/administrator")
    public CommonResult<RetAdministrator> getAdministrator(@RequestHeader Map<String, String> headers){
        String authorization =securityProperties.getTokenHeader().toLowerCase();
        RetAdministrator administrator =  administratorService.getAdministratorByAuthorization(
                headers.get(authorization));
        return CommonResult.success(administrator);
    }
    @Operation(summary = "管理员登录")
    @PostMapping("/administrators/auth/token")
    public CommonResult<Map<String, String>> login(@RequestBody RetLoginParam loginParam){
        String token = administratorService.login(loginParam);
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", securityProperties.getTokenHead());
        return CommonResult.success(tokenMap);
    }
    @Operation(description = "管理员退出, 需要前端删除token", summary = "管理员退出")
    @DeleteMapping("/administrator/auth/token")
    public CommonResult<String> logout(@RequestHeader Map<String, String> headers){
        String bearer = headers.get(securityProperties.getTokenHeader().toLowerCase());
        administratorService.logout(bearer);
        return CommonResult.success(null);
    }
    @Operation(summary = "刷新token")
    @PatchMapping(value = "/administrator/auth/token")
    @ResponseBody
    public CommonResult<Map<String, String>> refreshToken(HttpServletRequest request) {
        String authorization = request.getHeader(securityProperties.getTokenHeader());
        String refreshToken = administratorService.refreshToken(authorization);
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", securityProperties.getTokenHead());
        return CommonResult.success(tokenMap);
    }
    
    @Operation(summary = "通过管理员参数获取管理员信息")
    @GetMapping("/administrators")
    public CommonResult<CommonPage<RetAdministrator>> getAdministratorByAdministratorParam(RetAdministrator administrator,
                                                                PageInfo pageInfo){
        List<RetAdministrator> administrators = administratorService.list(pageInfo, administrator);
        return CommonResult.success(CommonPage.restPage(administrators));
    }

    @Operation(summary = "更新管理员资料")
    @PatchMapping("/administrators")
    public CommonResult<String> updateAdministrator(@RequestBody RetAdministrator newAdministrator){
        administratorService.updateAdministrator(newAdministrator);
        return CommonResult.success(null);
    }

    @Operation(summary = "删除管理员")
    @DeleteMapping("/administrators/{administratorId}")
    public CommonResult<String> deleteAdministrator(@PathVariable("administratorId") Long administratorId){
        administratorService.deleteAdministratorByAdministratorId(administratorId);
        return CommonResult.success(null);
    }
}
