package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 帮助分类
 * @author hhoa 
 * @date 2022-06-16
 */
@Schema(description = "帮助分类")
public class RetHelpCategory implements Serializable {
    private Long id;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "图标")
    private String logo;

    @Schema(description = "状态: 0->禁用, 1->启用")
    private Integer status;

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
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 图标
     * @return logo 图标
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 图标
     * @param logo 图标
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 状态: 0->禁用, 1->启用
     * @return status 状态: 0->禁用, 1->启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态: 0->禁用, 1->启用
     * @param status 状态: 0->禁用, 1->启用
     */
    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", logo=").append(logo);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}