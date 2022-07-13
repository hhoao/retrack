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

    @Operation(summary = "已认证解绑认证")
    @DeleteMapping("/user/auths/{authType}")
    public CommonResult<String> unbindUserAuth(@PathVariable("authType") IdentifyType authType,
                                               @RequestHeader Map<String, String> headers){
        userService.unbindUserAuth(authType, headers.get(properties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }
    @Operation(summary = "已认证更新用户名")
    @PatchMapping("/user/auths/username")
    public CommonResult<String> updateUsername(@RequestHeader Map<String, String> headers,
                                               @RequestParam("newUsername") String newUsername){
        userService.updateUsername(newUsername, headers.get(properties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }
    @Operation(summary = "已认证发送绑定邮箱验证码")
    @GetMapping("/authCodes/binding/email")
    public CommonResult<String> sendBindEmailCode(@RequestHeader Map<String, String> headers,
                                            @RequestParam("email") String email){
        userService.sendBindEmailCode(email, headers.get(properties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }

    @Operation(summary = "已认证绑定邮箱")
    @PatchMapping("/user/auths/email")
    public CommonResult<String> updateEmail(@RequestHeader Map<String, String> headers,
                                               @RequestParam("email") String email,
                                            @RequestParam("authCode") String authCode){
        userService.bindEmail(email, authCode, headers.get(properties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }

    @Operation(summary = "已认证发送绑定手机验证码", description = "未开通")
    @GetMapping("/authCodes/binding/phone")
    public CommonResult<String> sendBindPhoneCode(){
        return CommonResult.failed("未开通");
    }
    @Operation(summary = "已认证绑定电话号码")
    @PatchMapping("/user/auths/phone")
    public CommonResult<String> updatePhone(@RequestHeader Map<String, String> headers,
                                               @RequestParam("phone") String phone,
                                            @RequestParam("authCode") String authCode){
        userService.bindPhone(phone, authCode, headers.get(properties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }
    @Operation(summary = "更改用户密码")
    @PatchMapping("/users/auth/password")
    public CommonResult<String> updateUserPassword(@RequestBody RetUpdateUserPasswordParam userAuthParam){
        userService.updateUserPassword(userAuthParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "用户登录")
    @PostMapping("/users/auth/token")
    public CommonResult<Map<String, String>> login(@RequestBody RetLoginParam loginParam){
        String token = userService.login(loginParam);
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", properties.getTokenHead());
        return CommonResult.success(tokenMap);
    }


    @Operation(summary = "注册用户")
    @PostMapping("/users")
    public CommonResult<String> register(@RequestBody RetUserRegisterParam userRegisterParam){
        userService.register(userRegisterParam);
        return CommonResult.success(null);
    }

    @Operation(description = "用户退出, 需要前端删除token", summary = "用户退出")
    @DeleteMapping("/user/auth/token")
    public CommonResult<String> logout(@RequestHeader Map<String, String> headers){
        String bearer = headers.get(properties.getTokenHeader().toLowerCase());
        userService.logout(bearer);
        return CommonResult.success(null);
    }


    @Operation(summary = "后台更新用户认证凭证")
    @PatchMapping("/users/{userId}/auths/{authType}")
    @ResponseBody
    public CommonResult<String> updateUserAuth(@PathVariable("userId") Long userId,
                                               @PathVariable("authType") IdentifyType authType,
                                               @RequestBody RetUserAuthParam userAuth) {
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

    @GetMapping(value="/users/auth/code")
    @Operation(summary = "获取注册验证码")
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
