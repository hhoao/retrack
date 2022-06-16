package com.rare_earth_track.portal.config;

import cn.hutool.jwt.JWT;
import com.rare_earth_track.portal.service.RetTokenCacheService;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import com.rare_earth_track.security.util.DefaultJwtTokenServiceImpl;
import com.rare_earth_track.security.util.JwtTokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AdminJwtSecurityConfig
 * @Description: 安全配置
 * @Author 匡龙
 * @Date 2022/6/16 9:39
 * @Version V1.0
 */
@Configuration
@RequiredArgsConstructor
public class PortalJwtSecurityConfig {

    /**
     * 编码器配置
     * @return 编码器
     */
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * token服务
     * @param tokenCacheService token缓存服务
     * @param jwtSecurityProperties jwt安全配置属性
     * @return jwtToken服务
     */
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
