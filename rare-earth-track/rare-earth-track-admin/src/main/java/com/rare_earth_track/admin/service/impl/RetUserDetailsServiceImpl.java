package com.rare_earth_track.admin.service.impl;


import com.rare_earth_track.admin.bean.RetUserDetails;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.admin.service.RetUserDetailsService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import com.rare_earth_track.security.util.JwtTokenUtil;
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
public class RetUserDetailsServiceImpl implements RetUserDetailsService {
    private final RetUserService retUserService;
    private final RetResourceService retResourceService;
    private final PasswordEncoder passwordEncoder;
    private final JwtSecurityProperties properties;
    private final JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = getUserDetailsByUserName(username);
            if(!passwordEncoder.matches(password, userDetails.getPassword())){
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
        RetUser retUserByName = retUserService.getUserByName(username);
        if (retUserByName != null){
            List<RetResource> retResources = retResourceService.getResourcesByUserId(retUserByName.getId());
            userDetails = new RetUserDetails(retUserByName, retResources);
        }
        return userDetails;
    }
}
