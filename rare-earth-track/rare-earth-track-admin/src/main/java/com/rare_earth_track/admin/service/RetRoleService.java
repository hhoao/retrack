package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.mgb.model.RetRole;

import java.util.List;

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

    /**
     * 增加角色
     * @param roleParam 角色参数
     * @return 增加角色数量
     */
    int addRole(RetRoleParam roleParam);

    /**
     * 获取所有角色
     * @return role
     */
    List<RetRole> getAllRoles();
}
