package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetRole;


/**
 * @author hhoa
 * @date 2022/5/15
 **/
public interface RetUserRoleRelationService {
    /**
     * 通过用户id获角色id
     * @param userId 用户id
     * @return 角色id
     */
    RetRole getRoleByUserId(Long userId);
}
