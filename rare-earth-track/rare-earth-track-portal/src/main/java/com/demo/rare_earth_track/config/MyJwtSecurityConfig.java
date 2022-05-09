package com.demo.rare_earth_track.config;


import com.demo.rare_earth_track.bean.MyUserDetails;
import com.demo.rare_earth_track.bean.Resource;
import com.demo.rare_earth_track.bean.User;
import com.demo.rare_earth_track.component.DynamicSecurityService;
import com.demo.rare_earth_track.dao.ResourceDao;
import com.demo.rare_earth_track.dao.UserDao;
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
public class MyJwtSecurityConfig{
    private final UserDao userDao;
    private final ResourceDao resourceDao;
    public MyJwtSecurityConfig(UserDao userDao, ResourceDao resourceDao) {
        this.userDao = userDao;
        this.resourceDao = resourceDao;
    }
    /**
     * 自定义UserDetailsService用来自定义获取用户、更新用户等操作
     * @return userDetailsService
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userDao.getUserByName(username);
            List<Resource> resources = resourceDao.getResourcesByUserId(user.getId());
            //获取用户并赋予ROLE_ADMIN权限
            return new MyUserDetails(user, resources);
        };
    }
    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return () -> {
            List<Resource> resources= resourceDao.getAllResources();
            Map<AntPathRequestMatcher, ConfigAttribute> map = new ConcurrentHashMap<>(resources.size());
            for (Resource resource: resources) {
                map.put(new AntPathRequestMatcher(resource.getUrl(), resource.getMethod()), new SecurityConfig(resource.getId() + ":" + resource.getName()));
            }
            return map;
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
