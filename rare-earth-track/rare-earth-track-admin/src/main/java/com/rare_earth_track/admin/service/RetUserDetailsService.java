package com.rare_earth_track.admin.service;


import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
public interface RetUserDetailsService {
    /**
     * 获取UserDetails
     * @param username username
     * @return userDetails
     */
    UserDetails getUserDetailsByUserName(String username);

    /**
     * 登录
     * @return token
     * @param username 用户名
     * @param password 密码
     */
    String login(String username, String password);
}
