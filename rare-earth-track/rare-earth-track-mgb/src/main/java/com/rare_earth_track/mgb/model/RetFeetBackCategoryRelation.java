package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

public class RetFeetBackCategoryRelation implements Serializable {
    private Long id;

    private Long feetBackId;

    private Long feetBackCategoryId;

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
     * @return feet_back_id 
     */
    public Long getFeetBackId() {
        return feetBackId;
    }

    /**
     * 
     * @param feetBackId 
     */
    public void setFeetBackId(Long feetBackId) {
        this.feetBackId = feetBackId;
    }

    /**
     * 
     * @return feet_back_category_id 
     */
    public Long getFeetBackCategoryId() {
        return feetBackCategoryId;
    }

    /**
     * 
     * @param feetBackCategoryId 
     */
    public void setFeetBackCategoryId(Long feetBackCategoryId) {
        this.feetBackCategoryId = feetBackCategoryId;
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
        sb.append(", feetBackId=").append(feetBackId);
        sb.append(", feetBackCategoryId=").append(feetBackCategoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}