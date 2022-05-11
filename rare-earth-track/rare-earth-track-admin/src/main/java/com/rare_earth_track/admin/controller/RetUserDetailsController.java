package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.RetLoginParam;
import com.rare_earth_track.admin.service.RetUserDetailsService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
@AllArgsConstructor
@Tags({@Tag(name = "RetUserDetailsController", description = "用户登录注销管理")})
@RestController
public class RetUserDetailsController {
    private RetUserDetailsService retUserDetailsService;
    private JwtSecurityProperties properties;
    @Operation(description = "登录")
    @PostMapping("/login")
    public CommonResult<Map<String, String>> login(@RequestBody RetLoginParam loginParam){
        String token = retUserDetailsService.login(loginParam.getName(), loginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", properties.getTokenHead());
        return CommonResult.success(tokenMap);
    }
}
