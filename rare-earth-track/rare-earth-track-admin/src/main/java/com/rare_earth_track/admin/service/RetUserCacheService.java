package com.rare_earth_track.admin.service;


import com.rare_earth_track.mgb.backup.RetUser;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
public interface RetUserCacheService {
    /**
     * 获取用户
     * @return 用户
     * @param username username
     */
    RetUser getUserByName(String username);

    /**
     * 设置用户
     * @param retUser 用户
     */
    void setUser(RetUser retUser);
}
