package com.demo.rare_earth_track.controller;

import com.demo.rare_earth_track.api.CommonResult;
import com.demo.rare_earth_track.bean.UserParam;
import com.demo.rare_earth_track.config.JwtSecurityProperties;
import com.demo.rare_earth_track.service.UserDetailsService;
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
@RestController
public class UserDetailsController {
    private UserDetailsService userDetailsService;
    private JwtSecurityProperties properties;
    @PostMapping("/login")
    public CommonResult<Map<String, String>> login(@RequestBody UserParam userParam){
        String token = userDetailsService.login(userParam);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", properties.getTokenHead());
        return CommonResult.success(tokenMap);
    }
}
