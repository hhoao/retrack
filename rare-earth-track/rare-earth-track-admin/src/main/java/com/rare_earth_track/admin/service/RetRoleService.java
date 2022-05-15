package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetRole;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
public interface RetRoleService {
    /**
     * 通过roleId获取角色
     * @param roleId roleId
     * @return 角色
     */
    RetRole getRoleByRoleId(Long roleId);
}
