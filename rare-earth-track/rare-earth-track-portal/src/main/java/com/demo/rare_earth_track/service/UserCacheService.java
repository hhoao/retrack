package com.demo.rare_earth_track.service;

import com.demo.rare_earth_track.bean.User;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
public interface UserCacheService {
    /**
     * 获取用户
     * @return 用户
     * @param username username
     */
    User getUserByName(String username);

    /**
     * 设置用户
     * @param user 用户
     */
    void setUser(User user);
}
