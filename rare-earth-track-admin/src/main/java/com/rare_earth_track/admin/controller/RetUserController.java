package com.rare_earth_track.admin.controller;


import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetUser;
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

    @Operation(summary = "通过认证标识获取用户")
    @GetMapping("/users/{identifier}")
    public CommonResult<RetUser> getUser(@PathVariable("identifier") String identifier){
        RetUser userByName = userService.getUserByIdentifier(identifier);
        return CommonResult.success(userByName);
    }

    @Operation(summary = "更新用户认证凭证")
    @PatchMapping("/users/{userId}/auths/{authType}")
    @ResponseBody
    public CommonResult<String> updateUserAuth(@PathVariable("userId") Long userId,
                                               @PathVariable("authType") IdentifyType authType,
                                               @RequestBody RetUserAuthParam userAuth) {
        userService.updateUserAuth(userId, authType, userAuth);
        return CommonResult.success(null);
    }

    @Operation(summary = "通过用户参数获取用户信息")
    @GetMapping("/users")
    public CommonResult<CommonPage<RetUserParam>> getUserByUserParam(RetUserParam user,
                                                                     PageInfo pageInfo){
        List<RetUserParam> users = userService.list(user, pageInfo);
        return CommonResult.success(CommonPage.restPage(users));
    }

    @Operation(summary = "更新用户资料")
    @PatchMapping("/users")
    public CommonResult<String> updateUser(@RequestBody RetUser newUser){
        userService.updateUser(newUser);
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
