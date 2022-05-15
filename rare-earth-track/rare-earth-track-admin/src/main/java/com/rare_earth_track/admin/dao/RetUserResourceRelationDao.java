package com.rare_earth_track.admin.dao;

import com.rare_earth_track.mgb.model.RetResource;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/11
 **/
public interface RetUserResourceRelationDao {
    /**
     * 通过用户id获取用户资源
     * @param id id
     * @return 资源
     */
    List<RetResource> getResourcesByUserId(Long id);
}
