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
     * 通过资源名获取资源
     * @return 资源
     */
    RetResource getResourceByName(String name);
    /**
     * 获取所有资源

     * @return 所有资源
     */
    List<RetResource> getAllResources();

    /**
     * 分页获取资源列表
     * @param pageNum the pageNum
     * @param pageSize the size
     * @return 分页资源 list
     */
    List<RetResource> list(Integer pageNum, Integer pageSize);

    /**
     * 通过ResourceId获取Resource
     * @param resourceId 资源id
     * @return resource
     */
    RetResource getResourceByResourceId(Long resourceId);

    /**
     * 添加资源
     * @param resourceParam 资源参数
     * @return 插入资源数量
     */
    int addResource(RetResourceParam resourceParam);
    /**
     * 修改资源
     * @param resourceParam 资源参数
     * @return 修改成功个数
     */
    int updateResource(RetResourceParam resourceParam);
    /**
     * 删除资源
     * @param id 资源id
     * @return 删除资源id数量
     */
    int delResource(Long id);
}
