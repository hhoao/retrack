package com.rare_earth_track.portal.service;

/**
 * @author hhoa
 * @date 2022/5/24
 **/

public interface RetFactoryInvitationCacheService {
    /**
     * 是否有该key
     * @param username username
     * @return boolean
     */
    boolean hasByUserName(String username);

    /**
     * 设置username key的过期时间
     * @param userName 用户名
     * @param expiration 可以为空
     */
    void expireByUsername(String userName, Long expiration);
    /**
     * 通过用户名获取角色名
     * @param username 用户名
     * @return 角色名
     */
    String getByUsername(String username);

    /**
     * 设置角色名
     * @param username 用户名
     * @param roleName 角色名
     * @param expiration 过期时间 空则使用默认
     */
    void setByUsername(String username, String roleName, Long expiration);

    /**
     * 删除userNameKey
     * @param username 用户名
     */
    void deleteByUsername(String username);
}
