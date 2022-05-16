package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 帮助和帮助分类关系
 * @author hhoa 
 * @date 2022-05-16
 */
@Schema(name = "帮助和帮助分类关系")
public class RetHelpCategoryHelpRelation implements Serializable {
    private Long id;

    private Long helpId;

    private Long helpCategoryId;

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
     * @return help_id 
     */
    public Long getHelpId() {
        return helpId;
    }

    /**
     * 
     * @param helpId 
     */
    public void setHelpId(Long helpId) {
        this.helpId = helpId;
    }

    /**
     * 
     * @return help_category_id 
     */
    public Long getHelpCategoryId() {
        return helpCategoryId;
    }

    /**
     * 
     * @param helpCategoryId 
     */
    public void setHelpCategoryId(Long helpCategoryId) {
        this.helpCategoryId = helpCategoryId;
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
        sb.append(", helpId=").append(helpId);
        sb.append(", helpCategoryId=").append(helpCategoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}