package com.rare_earth_track.admin.service;

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
     * 刷新缓存
     *
     * @param roleId roleId
     */
    void refreshCacheByRoleId(Long roleId);

    /**
     * 刷新缓存
     *
     * @param resourceId 资源id
     */
    void refreshCacheByResourceId(Long resourceId);

    /**
     * 刷新
     *
     * @param role role
     */
    void refreshCacheByRole(RetRole role);

    /**
     * 刷新缓存
     */
    void refreshCacheByAllRoleNames();

    /**
     * 刷新缓存
     *
     * @param roleName 角色名
     */
    void refreshCacheByRoleName(String roleName);

    /**
     * 通过资源Id获取所有相关联角色
     *
     * @param resourceId 资源Id
     * @return 关联角色 roles by resource id
     */
    List<RetRole> getRolesByResourceId(Long resourceId);

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
    void deleteRole(Long roleId);

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
    void addResourceRoleRelation(Long roleId, Long resourceId);

    /**
     * 分页获取角色资源列表
     *
     * @param name     角色名
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 角色资源列表页 list
     */
    List<RetResource> listRoleResources(String name, Integer pageNum, Integer pageSize);

    /**
     * 删除资源
     *
     * @param id 资源id
     */
    @Transactional
    void deleteResourceRoleRelation(Long id);
}
