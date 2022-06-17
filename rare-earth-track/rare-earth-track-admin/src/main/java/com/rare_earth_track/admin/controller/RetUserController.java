package com.rare_earth_track.admin.controller;


import com.rare_earth_track.admin.bean.IdentifyType;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户controller
 * @author hhoa
 **/
@RestController
@RequiredArgsConstructor
@Tags({@Tag(name="用户管理", description = "RetUserController")})
public class RetUserController {
    private final RetUserService userService;
    private final JwtSecurityProperties securityProperties;

    @Operation(summary = "分页获取用户列表")
    @GetMapping("/users")
    public CommonResult<CommonPage<RetUser>> list(PageInfo pageInfo){
        return CommonResult.success(CommonPage.restPage(userService.list(pageInfo)));
    }
    @Operation(summary = "获取已认证用户角色菜单")
    @GetMapping("/user/role/menus")
    public CommonResult<List<RetMenu>> getUserRoleMenus(@RequestHeader Map<String, String> headers){
        List<RetMenu> menus = userService.getMenusByAuthorization(
                headers.get(securityProperties.getTokenHeader().toLowerCase()));
        return CommonResult.success(menus);
    }
    @Operation(summary = "通过认证标识获取用户")
    @GetMapping("/users/{identifier}")
    public CommonResult<RetUser> getUser(@PathVariable("identifier") String identifier){
        RetUser userByName = userService.getUserByIdentifier(identifier);
        return CommonResult.success(userByName);
    }
    @Operation(summary = "获取已认证用户信息")
    @GetMapping("/user")
    public CommonResult<RetUser> getUser(@RequestHeader Map<String, String> headers){
        String authorization =securityProperties.getTokenHeader().toLowerCase();
        RetUser user =  userService.getUserByAuthorization(
                headers.get(authorization));
        return CommonResult.success(user);
    }
    @Operation(summary = "通过用户参数获取用户信息")
    @GetMapping("/users/search")
    public CommonResult<CommonPage<RetUser>> getUserByUserParam(RetUser user,
                                                          PageInfo pageInfo){
        List<RetUser> users = userService.queryUsers(user, pageInfo);
        return CommonResult.success(CommonPage.restPage(users));
    }

    @Operation(summary = "更新当前用户资料")
    @PatchMapping("/user")
    public CommonResult<String> updateUser(@RequestBody RetUser user,
                                           @RequestHeader Map<String, String> headers){
        String authorization = headers.get(securityProperties.getTokenHeader().toLowerCase());
        userService.updateUser(user, authorization);
        return CommonResult.success(null);
    }

    @Operation(summary = "更新用户资料")
    @PatchMapping("/users")
    public CommonResult<String> updateUser(@RequestBody RetUser newUser){
        userService.updateUser(newUser);
        return CommonResult.success(null);
    }
    @Operation(summary = "更改用户角色")
    @PatchMapping("/users/{userId}/role")
    public CommonResult<RetUser> updateUserRole(@PathVariable("userId") Long userId,
                                                @RequestParam("roleId") Long roleId){
        userService.updateUserRole(userId, roleId);
        return CommonResult.success(null);
    }

    @Operation(summary = "获取用户认证")
    @GetMapping("/users/{userId}/auths")
    public CommonResult<Map<String, String>> getUserAuths(@PathVariable("userId") Long userId){
        Map<String, String> userAuth = userService.getUserAuths(userId);
        return CommonResult.success(userAuth);
    }
    @Operation(summary = "删除用户认证")
    @DeleteMapping("/users/{userId}/auths/{authType}")
    public CommonResult<String> deleteUserAuth(@PathVariable("userId") Long userId,
                                               @PathVariable("authType") IdentifyType identifyType){
        userService.deleteUserAuth(userId, identifyType);
        return CommonResult.success(null);
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/users/{userId}")
    public CommonResult<String> deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUserByUserId(userId);
        return CommonResult.success(null);
    }
}
