package com.demo.rare_earth_track.service;

import com.demo.rare_earth_track.bean.Resource;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/6
 **/
public interface ResourceService {
    /**
     * 获取所有资源
     * @return 所有资源
     */
    List<Resource> getAllResources();

    /**
     * 通过用户id获取资源
     * @param id id
     * @return 用户资源
     */
    List<Resource> getResourcesByUserId(Integer id);
}
