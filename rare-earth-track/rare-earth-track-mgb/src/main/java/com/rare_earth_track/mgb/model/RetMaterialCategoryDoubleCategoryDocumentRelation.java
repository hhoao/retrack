package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 材料分类和材料二次分类关系
 * @author hhoa 
 * @date 2022-05-27
 */
@Schema(name = "材料分类和材料二次分类关系")
public class RetMaterialCategoryDoubleCategoryDocumentRelation implements Serializable {
    private Long id;

    private Long categoryId;

    private Long doubleCategoryId;

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
     * @return category_id 
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId 
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * @return double_category_id 
     */
    public Long getDoubleCategoryId() {
        return doubleCategoryId;
    }

    /**
     * 
     * @param doubleCategoryId 
     */
    public void setDoubleCategoryId(Long doubleCategoryId) {
        this.doubleCategoryId = doubleCategoryId;
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
        sb.append(", categoryId=").append(categoryId);
        sb.append(", doubleCategoryId=").append(doubleCategoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}