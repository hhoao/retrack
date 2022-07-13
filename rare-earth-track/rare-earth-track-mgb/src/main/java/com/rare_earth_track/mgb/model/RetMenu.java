package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
 * 后台菜单
 * @author 匡龙 
 * @date 2022-07-13
 */
@Schema(description = "后台菜单")
public class RetMenu implements Serializable {
    private Long id;

    @Schema(description = "父级id")
    private Long parentId;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "菜单名称")
    private String title;

    @Schema(description = "菜单级数")
    private Integer level;

    @Schema(description = "菜单排序")
    private Integer sort;

    @Schema(description = "前端名称")
    private String name;

    @Schema(description = "前端图标")
    private String icon;

    @Schema(description = "前端隐藏")
    private Integer hidden;

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
     * 父级id
     * @return parent_id 父级id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父级id
     * @param parentId 父级id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 菜单名称
     * @return title 菜单名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 菜单名称
     * @param title 菜单名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 菜单级数
     * @return level 菜单级数
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 菜单级数
     * @param level 菜单级数
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 菜单排序
     * @return sort 菜单排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 菜单排序
     * @param sort 菜单排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 前端名称
     * @return name 前端名称
     */
    public String getName() {
        return name;
    }

    /**
     * 前端名称
     * @param name 前端名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 前端图标
     * @return icon 前端图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 前端图标
     * @param icon 前端图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 前端隐藏
     * @return hidden 前端隐藏
     */
    public Integer getHidden() {
        return hidden;
    }

    /**
     * 前端隐藏
     * @param hidden 前端隐藏
     */
    public void setHidden(Integer hidden) {
        this.hidden = hidden;
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
        sb.append(", parentId=").append(parentId);
        sb.append(", createTime=").append(createTime);
        sb.append(", title=").append(title);
        sb.append(", level=").append(level);
        sb.append(", sort=").append(sort);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", hidden=").append(hidden);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}