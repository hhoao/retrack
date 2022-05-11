package com.rare_earth_track.admin.service;


import com.rare_earth_track.mgb.model.RetResource;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/6
 **/
public interface RetResourceService {
    /**
     * 获取所有资源
     * @return 所有资源
     */
    List<RetResource> getAllResources();

    /**
     * 通过用户id获取资源
     * @param id id
     * @return 用户资源
     */
    List<RetResource> getResourcesByUserId(Long id);
}
