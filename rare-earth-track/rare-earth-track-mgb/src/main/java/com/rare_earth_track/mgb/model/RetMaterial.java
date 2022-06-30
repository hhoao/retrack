package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 材料
 * @author hhoa 
 * @date 2022-06-30
 */
@Schema(description = "材料")
public class RetMaterial implements Serializable {
    private Long id;

    private Long materialDoubleCategoryId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "产地")
    private String origin;

    @Schema(description = "出产公司名")
    private String createCompanyName;

    @Schema(description = "描述")
    private String description;

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
     * @return material_double_category_id 
     */
    public Long getMaterialDoubleCategoryId() {
        return materialDoubleCategoryId;
    }

    /**
     * 
     * @param materialDoubleCategoryId 
     */
    public void setMaterialDoubleCategoryId(Long materialDoubleCategoryId) {
        this.materialDoubleCategoryId = materialDoubleCategoryId;
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
     * 产地
     * @return origin 产地
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 产地
     * @param origin 产地
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 出产公司名
     * @return create_company_name 出产公司名
     */
    public String getCreateCompanyName() {
        return createCompanyName;
    }

    /**
     * 出产公司名
     * @param createCompanyName 出产公司名
     */
    public void setCreateCompanyName(String createCompanyName) {
        this.createCompanyName = createCompanyName;
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
        sb.append(", materialDoubleCategoryId=").append(materialDoubleCategoryId);
        sb.append(", name=").append(name);
        sb.append(", origin=").append(origin);
        sb.append(", createCompanyName=").append(createCompanyName);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}