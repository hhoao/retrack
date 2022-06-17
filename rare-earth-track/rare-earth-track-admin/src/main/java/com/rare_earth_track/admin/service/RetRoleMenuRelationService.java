package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetRole;

import java.util.List;

/**
 * The interface Ret role menu relation service.
 *
 * @author hhoa
 * @date 2022 /6/13
 */
public interface RetRoleMenuRelationService {
    /**
     * Gets menus.
     *
     * @param roleId the role id
     * @return the menus
     */
    List<RetMenu> getMenus(Long roleId);

    /**
     * Delete role menus.
     *
     * @param roleId the id
     */
    void deleteRoleMenus(Long roleId);

    /**
     * Delete role menu.
     *
     * @param roleId the id
     * @param menuId the menu id
     */
    void deleteRoleMenu(Long roleId, Long menuId);

    /**
     * Gets roles.
     *
     * @param menuId the menu id
     * @return the roles
     */
    List<RetRole> getRoles(Long menuId);

    /**
     * Gets roles.
     *
     * @param menuName the menu name
     * @return the roles
     */
    List<RetRole> getRoles(String menuName);

    /**
     * Gets role menus.
     *
     * @param roleId the role id
     * @return the role menus
     */
    List<RetMenu> getRoleMenus(Long roleId);

    /**
     * Add role menu.
     *
     * @param roleId the id
     * @param menuId the menu id
     */
    void addRoleMenu(Long roleId, Long menuId);

    /**
     * List role menus list.
     *
     * @param name     the name
     * @param pageInfo the page info
     * @return the list
     */
    List<RetMenu> listRoleMenus(String name, PageInfo pageInfo);

    /**
     * Delete role menu.
     *
     * @param menuId the id
     */
    void deleteRoleMenu(Long menuId);

    /**
     * Delete role menu.
     *
     * @param roleName the role name
     * @param menuName the menu name
     */
    void deleteRoleMenu(String roleName, String menuName);

    /**
     * Add role menu.
     *
     * @param roleName the role name
     * @param menuName the menu name
     */
    void addRoleMenu(String roleName, String menuName);
}
