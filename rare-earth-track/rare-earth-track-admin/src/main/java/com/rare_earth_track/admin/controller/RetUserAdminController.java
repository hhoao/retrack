package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.RetLoginParam;
import com.rare_earth_track.admin.bean.RetUserRegisterParam;
import com.rare_earth_track.admin.bean.RetUserUpdatePasswordParam;
import com.rare_earth_track.admin.service.RetMailService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
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
@Tags({@Tag(name = "RetUserDetailsController", description = "用户登录注销管理")})
@RestController
public class RetUserAdminController {
    private RetUserService userService;
    private JwtSecurityProperties properties;
    private RetMailService mailService;

    @Operation(description = "登录", summary = "用户登录")
    @PostMapping("/user/auth/token")
    public CommonResult<Map<String, String>> login(@RequestBody RetLoginParam loginParam){
        String token = userService.login(loginParam.getName(), loginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", properties.getTokenHead());
        return CommonResult.success(tokenMap);
    }

    @Operation(description = "用户注册", summary = "注册用户")
    @PostMapping("/user")
    public CommonResult<RetUser> register(@RequestBody RetUserRegisterParam userRegisterParam){
        RetUser register = userService.register(userRegisterParam);
        return CommonResult.success(register);
    }

    @Operation(description = "用户退出, 需要前端删除token", summary = "用户退出")
    @DeleteMapping("/user/auth/token")
    public CommonResult<String> logout(){
        return CommonResult.success(null);
    }

    @Operation(description = "更新密码", summary = "更新密码")
    @PatchMapping("/user/password")
    @ResponseBody
    public CommonResult updatePassword(@Schema(description = "验证类型", required = true, allowableValues = {"phone", "email"})
                                           @RequestParam("type") String type,
                                       @RequestBody RetUserUpdatePasswordParam passwordParam) {
        if ("phone".equals(type)){
            userService.updatePasswordWithPhone(passwordParam);
        }else {
            userService.updatePasswordWithMail(passwordParam);
        }
        return CommonResult.success(null,"密码修改成功");
    }

    @Operation(description = "刷新token", summary = "刷新token")
    @PatchMapping(value = "/user/auth/token")
    @ResponseBody
    public CommonResult<Map<String, String>> refreshToken(HttpServletRequest request) {
        String token = request.getHeader(properties.getTokenHeader());
        String refreshToken = userService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>(1);
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", properties.getTokenHead());
        return CommonResult.success(tokenMap);
    }

    @GetMapping(value="/user/auth/code")
    @Operation(description = "获取验证码", summary = "获取验证码", parameters = @Parameter())
    public CommonResult generateAuthCode(@Schema(description = "验证类型", required = true, allowableValues = {"phone", "email"})
                                                 @RequestParam("type") String type,
                                                 @Schema(description = "手机号码或者email", required = true)
                                                 @RequestParam("body") String phoneOrMail){
        if ("phone".equals(type)) {
            userService.generatePhoneAuthCode(phoneOrMail);
        }else{
            Boolean aBoolean = userService.existsMail(phoneOrMail);
            if (aBoolean) {
                mailService.generateAndSendAuthCode(phoneOrMail);
            }else{
                CommonResult.failed("没有该邮箱");
            }
        }
        return CommonResult.success(null);
    }
}
