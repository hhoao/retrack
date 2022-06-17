package com.rare_earth_track.portal.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetMenuParam;
import com.rare_earth_track.mgb.model.RetMenu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    /**
     * 获取所有资源
     *
     * @return 所有资源 all menus
     */
    List<RetMenu> getAllMenus();

    /**
     * 分页获取资源列表
     *
     * @param pageInfo@return 分页资源 list
     */
    List<RetMenu> list(PageInfo pageInfo);
    /**
     * 添加资源
     *
     * @param menuParam 资源参数
     */
    @Transactional
    void addMenu(RetMenuParam menuParam);

    /**
     * 修改资源
     *
     * @param menuName  the menu name
     * @param menuParam 资源参数
     */
    @Transactional
    void updateMenu(String menuName, RetMenuParam menuParam);

    /**
     * 删除资源
     *
     * @param menuId 资源id
     */
    @Transactional
    void deleteMenu(Long menuId);

    /**
     * Delete menu.
     *
     * @param menuName the menu name
     */
    @Transactional
    void deleteMenu(String menuName);
}
