package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;

import java.util.List;


/**
 * The interface Ret user role relation service.
 *
 * @author hhoa
 * @date 2022 /5/15
 */
public interface RetUserRoleRelationService {
    /**
     * 通过用户id获角色id
     *
     * @param userId 用户id
     * @return 角色id role by user id
     */
    RetRole getRoleByUserId(Long userId);

    /**
     * 通过用户id获取资源
     *
     * @param id id
     * @return 用户资源 resources by user id
     */
    List<RetResource> getResourcesByUserId(Long id);

    /**
     * Alter user role.
     *
     * @param userId the user id
     * @param roleId the role id
     */
    void alterUserRole(Long userId, Long roleId);
}
