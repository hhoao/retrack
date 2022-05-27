package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 专题专题分类关系
 * @author hhoa 
 * @date 2022-05-27
 */
@Schema(name = "专题专题分类关系")
public class RetSubjectCategorySubjectRelation implements Serializable {
    private Long id;

    private Long subjectId;

    private Long subjectCategoryId;

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
     * @return subject_id 
     */
    public Long getSubjectId() {
        return subjectId;
    }

    /**
     * 
     * @param subjectId 
     */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 
     * @return subject_category_id 
     */
    public Long getSubjectCategoryId() {
        return subjectCategoryId;
    }

    /**
     * 
     * @param subjectCategoryId 
     */
    public void setSubjectCategoryId(Long subjectCategoryId) {
        this.subjectCategoryId = subjectCategoryId;
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
        sb.append(", subjectId=").append(subjectId);
        sb.append(", subjectCategoryId=").append(subjectCategoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}