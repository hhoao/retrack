package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ret role service.
 *
 * @author hhoa
 * @date 2022 /5/15
 */
public interface RetRoleService {
    /**
     * 更新角色
     *
     * @param roleParam 角色参数
     */
    @Transactional
    void updateRole(RetRoleParam roleParam);

    /**
     * Gets role resources.
     *
     * @param roleId the role id
     * @return the role resources
     */
    List<RetResource> getRoleResources(Long roleId);

    /**
     * 通过roleId获取角色
     *
     * @param roleId roleId
     * @return 角色 role by role id
     */
    RetRole getRoleByRoleId(Long roleId);

    /**
     * 增加角色
     *
     * @param roleParam 角色参数
     */
    @Transactional
    void addRole(RetRoleParam roleParam);

    /**
     * 获取所有角色
     *
     * @return role all roles
     */
    List<RetRole> getAllRoles();

    /**
     * 分页获取角色列表
     *
     * @param pageNum  the pageNum
     * @param pageSize the pageSize
     * @return 分页角色 list
     */
    List<RetRole> list(Integer pageNum, Integer pageSize);

    /**
     * 删除角色
     *
     * @param id 角色id
     */
    @Transactional
    void deleteRole(Long id);
}
