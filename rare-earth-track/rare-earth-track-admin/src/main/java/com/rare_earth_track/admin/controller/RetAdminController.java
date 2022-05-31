package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.RetMailService;
import com.rare_earth_track.admin.service.RetUserAuthService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于处理用户隐私数据
 * @author hhoa
 * @date 2022/5/8
 **/
@AllArgsConstructor
@Tags({@Tag(name = "用户登录注销管理", description = "RetUserAdminController")})
@RestController
@Data
public class RetAdminController {
    private RetUserService userService;
    private JwtSecurityProperties properties;
    private RetUserAuthService userAuthService;
    private RetMailService mailService;

    @Operation(summary = "已经认证用户解绑认证方式")
    @DeleteMapping("/user/auth/{authType}")
    public CommonResult<String> unbindUserAuth(@PathVariable("authType") IdentifyType authType,
                                               @RequestHeader Map<String, String> headers){
        userService.unbindUserAuth(authType, headers.get(properties.getTokenHeader()));
        return CommonResult.success(null);
    }
    @Operation(summary = "更新已经认证用户的用户名")
    @PatchMapping("/user/auth/username")
    public CommonResult<String> updateUsername(@RequestHeader Map<String, String> headers,
                                               @RequestParam("newUsername") String newUsername){
        userService.updateUsername(newUsername, headers.get(properties.getTokenHeader()));
        return CommonResult.success(null);
    }
    @Operation(summary = "更改用户密码")
    @PatchMapping("/auth/password")
    public CommonResult<String> updateUserPassword(@RequestBody RetUserAuthParam userAuthParam){
        userService.updateUserPassword(userAuthParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "用户登录")
    @PostMapping("/user/auth/token")
    public CommonResult<Map<String, String>> login(@RequestBody RetLoginParam loginParam){
        String token = userService.login(loginParam);
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", properties.getTokenHead());
        return CommonResult.success(tokenMap);
    }


    @Operation(summary = "注册用户")
    @PostMapping("/user")
    public CommonResult<String> register(@RequestBody RetUserRegisterParam userRegisterParam){
        userService.register(userRegisterParam);
        return CommonResult.success(null);
    }

    @Operation(description = "用户退出, 需要前端删除token", summary = "用户退出")
    @DeleteMapping("/user/auth/token")
    public CommonResult<String> logout(@RequestHeader Map<String, String> headers){
        String bearer = headers.get(properties.getTokenHeader().toLowerCase());
        String authToken = bearer.substring(properties.getTokenHead().length());
        userService.logout(authToken);
        return CommonResult.success(null);
    }


    @Operation(summary = "后台更新用户认证凭证")
    @PatchMapping("/users/{userId}/auths/{authType}")
    @ResponseBody
    public CommonResult<String> updateUserAuth(@PathVariable("userId") Long userId,
                                               @PathVariable("authType") IdentifyType authType,
                                               @RequestBody RetAdminUserAuthParam userAuth) {
        userService.updateUserAuth(userId, authType, userAuth);
        return CommonResult.success(null);
    }

    @Operation(summary = "刷新token")
    @PatchMapping(value = "/user/auth/token")
    @ResponseBody
    public CommonResult<Map<String, String>> refreshToken(HttpServletRequest request) {
        String authorization = request.getHeader(properties.getTokenHeader());
        String refreshToken = userService.refreshToken(authorization);
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", properties.getTokenHead());
        return CommonResult.success(tokenMap);
    }

    @GetMapping(value="/user/auth/code")
    @Operation(summary = "获取验证码")
    public CommonResult<String> generateAuthCode(@Schema(description = "验证类型", required = true, allowableValues = {"phone", "email"})
                                                 @RequestParam("type") IdentifyType type,
                                                 @Schema(description = "手机号码或者email", required = true)
                                                 @RequestParam("body") String phoneOrMail){
        //目前通过phone获取验证码还没有开放
        if (type.name().equals(IdentifyType.email.name())) {
            userService.sendUserRegisterMail(phoneOrMail);
        }
        return CommonResult.success(null);
    }
}
