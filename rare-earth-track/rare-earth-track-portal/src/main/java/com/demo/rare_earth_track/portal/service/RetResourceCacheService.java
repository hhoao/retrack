package com.demo.rare_earth_track.portal.service;

import com.demo.rare_earth_track.portal.bean.RetResource;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
public interface RetResourceCacheService {
    /**
     * 通过用户名获取资源
     * @param id id
     * @return resources
     */
    List<RetResource> getResourcesByUserId(Integer id);

    /**
     * 通过用户名设置资源
     * @param retResources resources
     * @param id id
     */
    void setResourcesByUserId(List<RetResource> retResources, Integer id);

}
