package com.demo.rare_earth_track.service;

import com.demo.rare_earth_track.bean.Resource;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
public interface ResourceCacheService {
    /**
     * 通过用户名获取资源
     * @param id id
     * @return resources
     */
    List<Resource> getResourcesByUserId(Integer id);

    /**
     * 通过用户名设置资源
     * @param resources resources
     * @param id id
     */
    void setResourcesByUserId(List<Resource> resources, Integer id);

}
