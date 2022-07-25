package com.rare_earth_track.portal.config;


import cn.hutool.jwt.JWT;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetPermission;
import com.rare_earth_track.portal.service.RetMemberJobPermissionRelationService;
import com.rare_earth_track.portal.service.RetPermissionService;
import com.rare_earth_track.portal.service.RetUserCacheService;
import com.rare_earth_track.portal.service.RetUserService;
import com.rare_earth_track.security.component.DynamicSecurityService;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import com.rare_earth_track.security.util.DefaultJwtTokenServiceImpl;
import com.rare_earth_track.security.util.JwtTokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 安全配置
 * @author hhoa
 * @date 2022/5/5
 **/
@Configuration
@RequiredArgsConstructor
public class PortalJwtSecurityConfig {
    /**
     * 自定义UserDetailsService用来自定义获取用户、更新用户等操作
     * @return userDetailsService
     */
    @Bean
    public static UserDetailsService userDetailsService(RetUserService userService) {
        return userService::getUserDetails;
    }

    /**
     * Job权限访问投票者, 用于认证职位认证请求
     * @return 选举者
     */
    @Bean
    public AccessDecisionVoter<FilterInvocation> permissionAccessDecisionVoter(){
        return new AccessDecisionVoter<>() {
            @Override
            public boolean supports(ConfigAttribute attribute) {
                return true;
            }

            @Override
            public boolean supports(Class clazz) {
                return true;
            }

            @Override
            public int vote(Authentication authentication, FilterInvocation invocation, Collection collection) {
                String requestUrl = invocation.getRequestUrl();
                for (Object configAttribute : collection) {
                    String[] jobs = ((ConfigAttribute) configAttribute).getAttribute().split(";");
                    //将需要的jobId和表达式模式提取出来
                    String reg = "factories/(.*)/(.*)";
                    //建立正则表达式, 用来匹配请求的url, 例如/factories/(.*)/(.*)匹配/factories/factoryName/member并获取其中的factoryName。
                    Pattern pattern = Pattern.compile(reg);
                    Matcher matcher = pattern.matcher(requestUrl);
                    //请求url匹配访问所需要的url, 匹配成功则判断用户是否有该权限
                    if (matcher.find()) {
                        String factoryName = matcher.group(1);
                        for (String jobName : jobs) {
                            //访问公司需要"factoryName:jobName"权限
                            String needAuthority = factoryName + ":" + jobName;
                            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                                if (needAuthority.trim().equals(grantedAuthority.getAuthority())) {
                                    return AccessDecisionVoter.ACCESS_GRANTED;
                                }
                            }
                        }
                    }
                }
                return ACCESS_DENIED;
            }
        };
    }
    /**
     * 动态权限服务配置
     */
    @Configuration
    @Aspect
    @RequiredArgsConstructor
    public static class AdminDynamicSecurityServiceConfig{
        private final RetPermissionService permissionService;
        private final RetMemberJobPermissionRelationService memberJobPermissionRelationService;
        private Map<AntPathRequestMatcher, ConfigAttribute> dataSource;

        public Map<AntPathRequestMatcher, ConfigAttribute> getDataSource() {
            refreshDataSource();
            return dataSource;
        }

        /**
         * 目前无法做到动态刷新权限, 必须得重新启动
         * 资源权限变动动态刷新DataSource
         */
//        @Pointcut("execution(* com.rare_earth_track.portal.service.impl.RetPermissionServiceImpl.delete*(..)) ||" +
//                "execution(* com.rare_earth_track.portal.service.impl.RetPermissionServiceImpl.add*(..)) ||" +
//                "execution(* com.rare_earth_track.portal.service.impl.RetPermissionServiceImpl.update*(..))")
//        public void alterDataSource(){
//        }
//
//        /**
//         * 刷新DataSource
//         */
//        @AfterReturning("alterDataSource()")
        public void refreshDataSource(){
            if (this.dataSource == null) {
                this.dataSource = new ConcurrentHashMap<>();
            }
            this.dataSource.clear();
            refreshPermissionsDataSource();
        }


        /**
         * 刷新公司员工权限
         */
        private void refreshPermissionsDataSource() {
            List<RetPermission> permissions = permissionService.getAllPermissions();

            for (RetPermission permission : permissions){
                List<RetMemberJob> jobs = memberJobPermissionRelationService.getJobs(permission.getId());
                StringBuilder jobsStr = new StringBuilder();
                for (RetMemberJob memberJob : jobs) {
                    jobsStr.append(memberJob.getName()).append(";");
                }
                if (!StringUtils.hasLength(jobsStr)){
                    jobsStr.append("NIL");
                }
                this.dataSource.put(new AntPathRequestMatcher(permission.getUrl(), permission.getMethod()),
                        new SecurityConfig(jobsStr.toString()));
            }
        }

        @Bean
        public DynamicSecurityService dynamicSecurityService(){
            return this::getDataSource;
        }
    }

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
     * @param userCacheService token缓存服务
     * @param jwtSecurityProperties jwt安全配置属性
     * @return jwtToken服务
     */
    @Bean
    public static JwtTokenService jwtTokenService(RetUserCacheService userCacheService,
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
                return userCacheService.hasKey(username);
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
                userCacheService.expire(username);
                return oldToken;
            }
        };
        BeanUtils.copyProperties(jwtSecurityProperties, defaultJwtTokenService);
        return defaultJwtTokenService;
    }

}
