package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ret role resource relation service.
 *
 * @author hhoa
 * @date 2022 /5/15
 */
public interface RetRoleResourceRelationService {

    /**
     * 通过资源Id获取所有相关联角色
     *
     * @param resourceId 资源Id
     * @return 关联角色 roles by resource id
     */
    List<RetRole> getRoles(Long resourceId);

    /**
     * Gets roles.
     *
     * @param resourceName the resource name
     * @return the roles
     */
    List<RetRole> getRoles(String resourceName);

    /**
     * 删除角色资源
     *
     * @param roleId     角色id
     * @param resourceId 资源id
     */
    @Transactional
    void deleteRoleResource(Long roleId, Long resourceId);

    /**
     * 删除角色
     *
     * @param roleId 角色id
     */
    @Transactional
    void deleteRoleResources(Long roleId);

    /**
     * 通过角色id获取资源
     *
     * @param roleId 角色id
     * @return 资源 resources by role id
     */
    List<RetResource> getRoleResources(Long roleId);

    /**
     * 添加关系
     *
     * @param roleId     角色id
     * @param resourceId 资源id
     */
    @Transactional
    void addRoleResource(Long roleId, Long resourceId);

    /**
     * 分页获取角色资源列表
     *
     * @param name     角色名
     * @param pageInfo the page info
     * @return 角色资源列表页 list
     */
    List<RetResource> listRoleResources(String name, PageInfo pageInfo);

    /**
     * 删除资源
     *
     * @param id 资源id
     */
    @Transactional
    void deleteRoleResource(Long id);

    /**
     * Delete role resource.
     *
     * @param roleName     the role name
     * @param resourceName the resource name
     */
    void deleteRoleResource(String roleName, String resourceName);

    /**
     * Add resource role relation.
     *
     * @param roleName     the role name
     * @param resourceName the resource name
     */
    void addRoleResource(String roleName, String resourceName);
}
