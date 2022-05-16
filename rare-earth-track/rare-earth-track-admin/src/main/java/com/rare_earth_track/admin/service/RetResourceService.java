package com.rare_earth_track.admin.service;


import com.rare_earth_track.admin.bean.RetResourceParam;
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
     * 分页获取资源列表
     * @param from the from
     * @param size the size
     * @return 分页资源 list
     */
    List<RetResource> list(Integer from, Integer size);

    /**
     * 通过ResourceId获取Resource
     * @param resourceId 资源id
     * @return resource
     */
    RetResource getResourceByResourceId(Long resourceId);
    /**
     * 通过用户id获取资源
     * @param id id
     * @return 用户资源
     */
    List<RetResource> getResourcesByUserId(Long id);

    /**
     * 添加资源
     * @param resourceParam 资源参数
     * @return 插入资源数量
     */
    int addResource(RetResourceParam resourceParam);
}
