package com.rare_earth_track.portal.controller;

import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.portal.bean.IdentifyType;
import com.rare_earth_track.portal.bean.RetLoginParam;
import com.rare_earth_track.portal.bean.RetUpdateUserPasswordParam;
import com.rare_earth_track.portal.bean.RetUserRegisterParam;
import com.rare_earth_track.portal.service.RetUserService;
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
 * @ClassName RetUserController
 * @Description: 用于用户登录、注册、注销等用户管理
 * @Author 匡龙
 * @Date 2022/6/16 16:22
 * @Version V1.0
 */
@AllArgsConstructor
@Tags({@Tag(name = "用户登录注销管理", description = "RetUserController")})
@RestController
@Data
public class RetUserController {

    private RetUserService userService;
    private JwtSecurityProperties properties;

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

    @Operation(summary = "更改用户密码")
    @PatchMapping("/users/auth/password")
    public CommonResult<String> updateUserPassword(@RequestBody RetUpdateUserPasswordParam userAuthParam){
        userService.updateUserPassword(userAuthParam);
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
