package com.rare_earth_track.admin.config;


import cn.hutool.jwt.JWT;
import com.rare_earth_track.admin.bean.RetUserDetails;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.admin.service.RetTokenCacheService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.security.component.DynamicSecurityService;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import com.rare_earth_track.security.util.DefaultJwtTokenServiceImpl;
import com.rare_earth_track.security.util.JwtTokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 安全配置
 * @author hhoa
 * @date 2022/5/5
 **/
@Configuration
@RequiredArgsConstructor
public class AdminJwtSecurityConfig {
    /**
     * 自定义UserDetailsService用来自定义获取用户、更新用户等操作
     * @return userDetailsService
     */
    @Bean
    public static UserDetailsService userDetailsService(RetTokenCacheService tokenCacheService,
                                                        RetUserService userService) {
        return (username)->{
            List<RetResource> resourcesByRoleName = tokenCacheService.getKey(username);
            if (resourcesByRoleName == null){
                resourcesByRoleName = new ArrayList<>();
            }
            RetUser userCacheByUserName = userService.getUserCacheByUserName(username);
            return new RetUserDetails(userCacheByUserName, resourcesByRoleName);
        };
    }


    @Bean
    public static DynamicSecurityService dynamicSecurityService(RetResourceService resourceService) {
        return () -> {
            List<RetResource> allResources = resourceService.getAllResources();
            Map<AntPathRequestMatcher, ConfigAttribute> map = new ConcurrentHashMap<>(allResources.size());
            for (RetResource retResource : allResources) {
                map.put(new AntPathRequestMatcher(retResource.getUrl(), retResource.getMethod()), new SecurityConfig(retResource.getId() + ":" + retResource.getName()));
            }
            return map;
        };
    }
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public static JwtTokenService jwtTokenService(RetTokenCacheService tokenCacheService,
                                                  JwtSecurityProperties jwtSecurityProperties){
        DefaultJwtTokenServiceImpl defaultJwtTokenService = new DefaultJwtTokenServiceImpl() {
            @Override
            public String generateToken(Object subject) {
                Map<String, Object> claims = new HashMap<>(2);
                claims.put(CLAIM_KEY_CREATED, new Date());
                claims.put(JWT.SUBJECT, subject);
                return Jwts.builder()
                        .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, getSecret())
                        .compact();
            }

            @Override
            public boolean isTokenExpired(String token) {
                String username = getSubjectFromToken(token);
                return tokenCacheService.hasKey(username);
            }

            @Override
            public boolean validateToken(String token) {
                return isTokenExpired(token);
            }

            @Override
            public String refreshHeadToken(String oldToken) {
                if (tokenRefreshJustBefore(oldToken, getRefreshTime())) {
                    return oldToken;
                }
                String username = getSubjectFromToken(oldToken);
                tokenCacheService.expire(username);
                return oldToken;
            }
        };
        BeanUtils.copyProperties(jwtSecurityProperties, defaultJwtTokenService);
        return defaultJwtTokenService;
    }

}
