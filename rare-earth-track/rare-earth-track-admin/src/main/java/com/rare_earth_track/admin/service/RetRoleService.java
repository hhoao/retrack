package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.mgb.model.RetMenu;
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
     * Refresh cache by role id.
     *
     * @param roleId the role id
     */
    void refreshCache(Long roleId);

    /**
     * Refresh cache.
     *
     * @param role the role
     */
    void refreshCache(RetRole role);

    /**
     * Refresh cache.
     *
     * @param roleName the role name
     */
    void refreshCache(String roleName);

    /**
     * Refresh cache.
     */
    void refreshCache();

    /**
     * 更新角色
     *
     * @param roleName  the role name
     * @param roleParam 角色参数
     */
    @Transactional
    void updateRole(String roleName, RetRoleParam roleParam);

    /**
     * Gets role resources.
     *
     * @param roleId the role id
     * @return the role resources
     */
    List<RetResource> getRoleResources(Long roleId);

    /**
     * Gets role.
     *
     * @param roleName the role name
     * @return the role
     */
    RetRole getRole(String roleName);

    /**
     * 通过roleId获取角色
     *
     * @param roleId roleId
     * @return 角色 role by role id
     */
    RetRole getRole(Long roleId);

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
     * @param pageInfo @return 分页角色 list
     * @param role
     * @return the list
     */
    List<RetRole> list(PageInfo pageInfo, RetRole role);

    /**
     * 删除角色
     *
     * @param roleName 角色id
     */
    @Transactional
    void deleteRole(String roleName);

    /**
     * Gets menus.
     *
     * @param roleId the role id
     * @return the menus
     */
    List<RetMenu> getMenus(Long roleId);

    /**
     * Delete role menu.
     *
     * @param roleName the role name
     * @param menuId   the menu id
     */
    @Transactional
    void deleteRoleMenu(String roleName, Long menuId);

    @Transactional
    void addRoleMenu(String roleName, Long menuId);
}
