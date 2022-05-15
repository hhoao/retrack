package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetResource;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/13
 **/
public interface RetTokenCacheService {
    /**
     * 延长时间
     * @param username 用户名
     */
    void expire(String username);
    /**
     * 延长时间
     * @param username 用户名
     * @param expiration 时间
     */
    void expire(String username, Long expiration);
    /**
     *
     * 通过角色名和资源设置token
     * @param username 用户名
     * @param roleName 角色名
     * @param resources 资源
     */
    void setKey(String username, String roleName, List<RetResource> resources);

    /**
     * 判断是否有该key
     * @param username username
     * @return 是否存在
     */
   boolean hasKey(String username);

    /**
     * 获取
     * @param username 用户名
     * @return 资源
     */
    List<RetResource> getKey(String username);

    /**
     * 删除key
     * @param username 用户名
     */
   void delKey(String username);
}
