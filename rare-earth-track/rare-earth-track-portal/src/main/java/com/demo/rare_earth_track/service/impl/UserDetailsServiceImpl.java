package com.demo.rare_earth_track.service.impl;

import com.demo.rare_earth_track.bean.MyUserDetails;
import com.demo.rare_earth_track.bean.Resource;
import com.demo.rare_earth_track.bean.User;
import com.demo.rare_earth_track.bean.UserParam;
import com.demo.rare_earth_track.config.JwtSecurityProperties;
import com.demo.rare_earth_track.service.ResourceService;
import com.demo.rare_earth_track.service.UserDetailsService;
import com.demo.rare_earth_track.service.UserService;
import com.demo.rare_earth_track.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;
    private final ResourceService resourceService;
    private final PasswordEncoder passwordEncoder;
    private final JwtSecurityProperties properties;
    private final JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
    @Override
    public String login(UserParam userParam) {
        String token = null;
        try {
            UserDetails userDetails = getUserDetailsByUserName(userParam.getName());
            if(!passwordEncoder.matches(userParam.getPassword(), userDetails.getPassword())){
                throw new BadCredentialsException("密码错误");
            }
            if(!userDetails.isEnabled()){
                throw new DisabledException("用户已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails, properties.getSecret());
            log.info(userDetails.getUsername() + "登录成功");
        }catch (AuthenticationException e){
            log.warn("登录异常:{}", e.getMessage());
        }

        return token;
    }
    @Override
    public UserDetails getUserDetailsByUserName(String username) {
        UserDetails userDetails = null;
        User userByName = userService.getUserByName(username);
        if (userByName != null){
            List<Resource> resources = resourceService.getResourcesByUserId(userByName.getId());
            userDetails = new MyUserDetails(userByName, resources);
        }
        return userDetails;
    }
}
