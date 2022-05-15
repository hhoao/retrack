package com.rare_earth_track.admin.service;


import com.rare_earth_track.mgb.model.RetResource;

import java.util.List;

;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
public interface RetResourceCacheService {
    /**
     * 通过用户名获取资源
     * @param role role
     * @return resources
     */
    List<RetResource> getResourcesByRoleName(String role);

    /**
     * 通过用户名设置资源
     * @param retResources resources
     * @param role role
     */
    void setResourcesByRoleName(List<RetResource> retResources, String role);
}
