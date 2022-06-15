package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 资源角色关系
 * @author hhoa 
 * @date 2022-06-13
 */
@Schema(name = "资源角色关系")
public class RetRoleMenuRelation implements Serializable {
    private Long id;

    private Long roleId;

    private Long menuId;

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return role_id 
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 
     * @param roleId 
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 
     * @return menu_id 
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 
     * @param menuId 
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * toString
     * @return java.lang.String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", menuId=").append(menuId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}