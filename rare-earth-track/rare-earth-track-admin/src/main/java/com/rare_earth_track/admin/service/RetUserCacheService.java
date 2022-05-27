package com.rare_earth_track.admin.service;


import com.rare_earth_track.mgb.model.RetUser;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
public interface RetUserCacheService {
    /**
     * 设置过期时间
     * @param username 用户名
     * @param expiration 时间
     */
    void expire(String username, Long expiration);
    /**
     * 设置过期时间
     * @param username 用户名
     */
    void expire(String username);
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

    /**
     * 设置短信验证码
     * @param phone 手机号
     * @param authCode 验证码
     */
    void setPhoneAuthCode(String phone, String authCode);
    /**
     * 获取手机验证码
     * @param phone 手机号
     * @return 验证码
     */
    String getPhoneAuthCode(String phone);

    /**
     * 通过用户名删除用户
     * @param name name
     */
    void deleteUserByName(String name);
}
