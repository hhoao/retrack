package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetMenu;

/**
 * The interface Ret menu service.
 *
 * @author hhoa
 * @date 2022 /6/13
 */
public interface RetMenuService {
    /**
     * Gets menu.
     *
     * @param menuName the menu name
     * @return the menu
     */
    RetMenu getMenu(String menuName);

    /**
     * Gets menu.
     *
     * @param menuId the menu id
     * @return the menu
     */
    RetMenu getMenu(Long menuId);
}
