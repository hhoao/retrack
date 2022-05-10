package com.demo.rare_earth_track.portal.dao;

import com.demo.rare_earth_track.portal.bean.RetResource;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/6
 **/
public interface RetResourceDao {
    /**
     * 获取所有资源
     * @return 资源
     */
    List<RetResource> getAllResources();

    /**
     * 通过用户id获取资源
     * @param id 用户id
     * @return 用户资源表
     */
    List<RetResource> getResourcesByUserId(Integer id);
}
