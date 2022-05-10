package com.demo.rare_earth_track.portal.controller;

import com.demo.rare_earth_track.common.api.CommonResult;
import com.demo.rare_earth_track.portal.bean.RetUserParam;
import com.demo.rare_earth_track.security.config.JwtSecurityProperties;
import com.demo.rare_earth_track.portal.service.RetUserDetailsService;
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
public class RetUserDetailsController {
    private RetUserDetailsService retUserDetailsService;
    private JwtSecurityProperties properties;
    @PostMapping("/login")
    public CommonResult<Map<String, String>> login(@RequestBody RetUserParam retUserParam){
        String token = retUserDetailsService.login(retUserParam);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", properties.getTokenHead());
        return CommonResult.success(tokenMap);
    }
}
