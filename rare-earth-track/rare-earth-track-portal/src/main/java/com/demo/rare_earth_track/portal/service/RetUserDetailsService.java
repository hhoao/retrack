package com.demo.rare_earth_track.portal.service;


import com.demo.rare_earth_track.portal.bean.RetUserParam;
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
     * @param retUserParam userParam
     */
    String login(RetUserParam retUserParam);
}
