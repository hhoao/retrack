package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.IdentifyType;
import com.rare_earth_track.admin.bean.RetLoginParam;
import com.rare_earth_track.admin.bean.RetUserRegisterParam;
import com.rare_earth_track.admin.bean.RetUserUpdatePasswordByAuthCodeParam;
import com.rare_earth_track.admin.service.RetMailService;
import com.rare_earth_track.admin.service.RetUserAuthService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetUser;
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


    @Operation(summary = "用户登录")
    @PostMapping("/user/auth/token")
    public CommonResult<Map<String, String>> login(@RequestBody RetLoginParam loginParam){
        String token = userService.login(loginParam.getName(), loginParam.getPassword());
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", properties.getTokenHead());
        return CommonResult.success(tokenMap);
    }

    @Operation(summary = "注册用户")
    @PostMapping("/user")
    public CommonResult<RetUser> register(@RequestBody RetUserRegisterParam userRegisterParam){
        RetUser register = userService.register(userRegisterParam);
        return CommonResult.success(register);
    }

    @Operation(description = "用户退出, 需要前端删除token", summary = "用户退出")
    @DeleteMapping("/user/auth/token")
    public CommonResult<String> logout(@RequestHeader Map<String, String> headers){
        String bearer = headers.get(properties.getTokenHeader().toLowerCase());
        String authToken = bearer.substring(properties.getTokenHead().length());
        userService.logout(authToken);
        return CommonResult.success(null);
    }

    @Operation(summary = "更新密码")
    @PatchMapping("/user/password")
    @ResponseBody
    public CommonResult<String> updatePassword(@RequestBody RetUserUpdatePasswordByAuthCodeParam passwordParam) {
        userService.updatePasswordByAuthCode(passwordParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "刷新token")
    @PatchMapping(value = "/user/auth/token")
    @ResponseBody
    public CommonResult<Map<String, String>> refreshToken(HttpServletRequest request) {
        String token = request.getHeader(properties.getTokenHeader());
        String refreshToken = userService.refreshToken(token);
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
//        if ("phone".equals(type)) {
            //...
//        }else{
        userService.sendMailAuthCode(phoneOrMail);
//        }
        return CommonResult.success(null);
    }
}
