package com.rare_earth_track.admin.config;


import com.rare_earth_track.admin.bean.RetUserDetails;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.mgb.backup.RetResource;
import com.rare_earth_track.mgb.backup.RetUser;
import com.rare_earth_track.security.component.DynamicSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hhoa
 * @date 2022/5/5
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class AdminJwtSecurityConfig {
    private final RetUserService retUserService;
    private final RetResourceService retResourceService;

    /**
     * 自定义UserDetailsService用来自定义获取用户、更新用户等操作
     * @return userDetailsService
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            RetUser retUser = retUserService.getUserByName(username);
            List<RetResource> retResources = retResourceService.getResourcesByUserId(retUser.getId());
            //获取用户并赋予ROLE_ADMIN权限
            return new RetUserDetails(retUser, retResources);
        };
    }
    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return () -> {
            List<RetResource> retResources = retResourceService.getAllResources();
            Map<AntPathRequestMatcher, ConfigAttribute> map = new ConcurrentHashMap<>(retResources.size());
            for (RetResource retResource : retResources) {
                map.put(new AntPathRequestMatcher(retResource.getUrl(), retResource.getMethod()), new SecurityConfig(retResource.getId() + ":" + retResource.getName()));
            }
            return map;
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
