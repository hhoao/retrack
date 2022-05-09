package com.demo.rare_earth_track.service;


import com.demo.rare_earth_track.bean.UserParam;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
public interface UserDetailsService {
    /**
     * 获取UserDetails
     * @param username username
     * @return userDetails
     */
    UserDetails getUserDetailsByUserName(String username);

    /**
     * 登录
     * @return token
     * @param userParam userParam
     */
    String login(UserParam userParam);
}
