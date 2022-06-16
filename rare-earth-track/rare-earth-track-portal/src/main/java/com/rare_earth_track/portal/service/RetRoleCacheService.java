package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetRole;

/**
 * 角色缓存服务
 * @author hhoa
 * @date 2022/5/14
 **/
public interface RetRoleCacheService {
    /**
     * 删除key
     * @param userName 用户名
     */
    void delKey(String userName);
    /**
     * 通过用户名名设置角色
     * @param role 角色
     * @param userName 角色名
     */
    void setKeyByUserName(String userName, RetRole role);
    /**
     * 通过用户名名设置角色
     * @param role 角色
     * @param userName 角色名
     * @param expire 过期时间
     */
    void setKeyByUserName(String userName, RetRole role, Long expire);

    /**
     * 通过用户名名获取角色
     * @param userName 用户名
     * @return 角色
     */
    RetRole getKeysByUserName(String userName);

}
