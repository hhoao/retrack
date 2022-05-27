package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 材料和材料二次分类关系
 * @author hhoa 
 * @date 2022-05-27
 */
@Schema(name = "材料和材料二次分类关系")
public class RetMaterialCategoryRelation implements Serializable {
    private Long id;

    private Long materialId;

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
     * @return material_id 
     */
    public Long getMaterialId() {
        return materialId;
    }

    /**
     * 
     * @param materialId 
     */
    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
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
        sb.append(", materialId=").append(materialId);
        sb.append(", doubleCategoryId=").append(doubleCategoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}