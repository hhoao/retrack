package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.portal.bean.RetResourceParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ret resource service.
 *
 * @author hhoa
 * @date 2022 /5/6
 */
public interface RetResourceService {
    /**
     * 通过资源名获取资源
     *
     * @param name the name
     * @return 资源 resource by name
     */
    RetResource getResource(String name);

    /**
     * 获取所有资源
     *
     * @return 所有资源 all resources
     */
    List<RetResource> getAllResources();

    /**
     * 分页获取资源列表
     *
     * @param pageNum  the pageNum
     * @param pageSize the size
     * @return 分页资源 list
     */
    List<RetResource> list(Integer pageNum, Integer pageSize);

    /**
     * 通过ResourceId获取Resource
     *
     * @param resourceId 资源id
     * @return resource resource by resource id
     */
    RetResource getResource(Long resourceId);

    /**
     * 添加资源
     *
     * @param resourceParam 资源参数
     */
    @Transactional
    void addResource(RetResourceParam resourceParam);

    /**
     * 修改资源
     *
     * @param resourceName  the resource name
     * @param resourceParam 资源参数
     */
    @Transactional
    void updateResource(String resourceName, RetResourceParam resourceParam);

    /**
     * 删除资源
     *
     * @param resourceId 资源id
     */
    @Transactional
    void deleteResource(Long resourceId);

    /**
     * Delete resource.
     *
     * @param resourceName the resource name
     */
    @Transactional
    void deleteResource(String resourceName);
}
