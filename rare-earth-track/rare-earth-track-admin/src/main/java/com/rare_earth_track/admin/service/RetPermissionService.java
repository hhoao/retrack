package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetPermissionParam;
import com.rare_earth_track.mgb.model.RetPermission;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ret permission service.
 *
 * @author hhoa
 * @date 2022 /5/26
 */
public interface RetPermissionService {
    /**
     * 通过权限名获取资源
     *
     * @param permissionName the permissionName
     * @return 权限 permission by permissionName
     */
    RetPermission getPermission(String permissionName);

    /**
     * 获取所有权限
     *
     * @return 所有权限 all permissions
     */
    List<RetPermission> getAllPermissions();

    /**
     * 分页获取权限列表
     *
     * @param pageInfo   the page info
     * @param permission the permission
     * @return 分页权限 list
     */
    List<RetPermission> list(PageInfo pageInfo, RetPermission permission);

    /**
     * 通过PermissionId获取Permission
     *
     * @param resourceId 权限id
     * @return resource permission by permission id
     */
    RetPermission getPermission(Long resourceId);


    /**
     * 添加权限
     *
     * @param resourceParam 权限参数
     * @return 插入权限数量 int
     */
    @Transactional
    Long addPermission(RetPermissionParam resourceParam);

    /**
     * 修改权限
     *
     * @param permissionName the permission name
     * @param resourceParam  权限参数
     * @return 修改成功个数 int
     */
    @Transactional
    int updatePermission(String permissionName, RetPermissionParam resourceParam);

    /**
     * Del permission int.
     *
     * @param permissionId the permission id
     * @return the int
     */
    @Transactional
    int deletePermission(Long permissionId);

    /**
     * Delete permission.
     *
     * @param permissionName the permission name
     */
    void deletePermission(String permissionName);
}
