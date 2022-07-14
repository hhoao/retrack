package com.rare_earth_track.portal.controller;


import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.portal.bean.IdentifyType;
import com.rare_earth_track.portal.bean.RetLoginParam;
import com.rare_earth_track.portal.bean.RetUserRegisterParam;
import com.rare_earth_track.portal.service.RetUserService;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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

    @Operation(summary = "已认证解绑认证")
    @DeleteMapping("/user/auths/{authType}")
    public CommonResult<String> unbindUserAuth(@PathVariable("authType") IdentifyType authType,
                                               @RequestHeader Map<String, String> headers){
        userService.unbindUserAuth(authType, headers.get(securityProperties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }
    @Operation(summary = "已认证获取用户信息")
    @GetMapping("/user")
    public CommonResult<RetUser> getUser(@RequestHeader Map<String, String> headers){
        String authorization =securityProperties.getTokenHeader().toLowerCase();
        RetUser user =  userService.getUserByAuthorization(
                headers.get(authorization));
        return CommonResult.success(user);
    }
    @Operation(summary = "用户登录")
    @PostMapping("/users/auth/token")
    public CommonResult<Map<String, String>> login(@RequestBody RetLoginParam loginParam){
        String token = userService.login(loginParam);
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", securityProperties.getTokenHead());
        return CommonResult.success(tokenMap);
    }
    @Operation(description = "用户退出, 需要前端删除token", summary = "用户退出")
    @DeleteMapping("/user/auth/token")
    public CommonResult<String> logout(@RequestHeader Map<String, String> headers){
        String bearer = headers.get(securityProperties.getTokenHeader().toLowerCase());
        userService.logout(bearer);
        return CommonResult.success(null);
    }
    @Operation(summary = "刷新token")
    @PatchMapping(value = "/user/auth/token")
    @ResponseBody
    public CommonResult<Map<String, String>> refreshToken(HttpServletRequest request) {
        String authorization = request.getHeader(securityProperties.getTokenHeader());
        String refreshToken = userService.refreshToken(authorization);
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", securityProperties.getTokenHead());
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
    @Operation(summary = "注册用户")
    @PostMapping("/users")
    public CommonResult<String> register(@RequestBody RetUserRegisterParam userRegisterParam){
        userService.register(userRegisterParam);
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
        userService.bindPhone(phone, authCode, headers.get(securityProperties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }
    @Operation(summary = "已认证更新用户名")
    @PatchMapping("/user/auths/username")
    public CommonResult<String> updateUsername(@RequestHeader Map<String, String> headers,
                                               @RequestParam("newUsername") String newUsername){
        userService.updateUsername(newUsername, headers.get(securityProperties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }
    @Operation(summary = "已认证发送绑定邮箱验证码")
    @GetMapping("/authCodes/binding/email")
    public CommonResult<String> sendBindEmailCode(@RequestHeader Map<String, String> headers,
                                                  @RequestParam("email") String email){
        userService.sendBindEmailCode(email, headers.get(securityProperties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }

    @Operation(summary = "已认证绑定邮箱")
    @PatchMapping("/user/auths/email")
    public CommonResult<String> updateEmail(@RequestHeader Map<String, String> headers,
                                            @RequestParam("email") String email,
                                            @RequestParam("authCode") String authCode){
        userService.bindEmail(email, authCode, headers.get(securityProperties.getTokenHeader().toLowerCase()));
        return CommonResult.success(null);
    }
    @Operation(summary = "已认证更新用户资料")
    @PatchMapping("/user")
    public CommonResult<String> updateUser(@RequestBody RetUser user,
                                           @RequestHeader Map<String, String> headers){
        String authorization = headers.get(securityProperties.getTokenHeader().toLowerCase());
        userService.updateUser(user, authorization);
        return CommonResult.success(null);
    }

    @Operation(summary = "已认证获取用户认证")
    @GetMapping("/user/auths")
    public CommonResult<Map<String, String>> getUserAuths(@RequestHeader Map<String, String> headers){
        String authorization = headers.get(securityProperties.getTokenHeader().toLowerCase());
        Map<String, String> userAuth = userService.getVerifiedUserAuths(authorization);
        return CommonResult.success(userAuth);
    }
}
