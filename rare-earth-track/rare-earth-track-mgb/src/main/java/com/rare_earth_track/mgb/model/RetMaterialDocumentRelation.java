package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 材料和文档关系
 * @author hhoa 
 * @date 2022-05-16
 */
@Schema(name = "材料和文档关系")
public class RetMaterialDocumentRelation implements Serializable {
    private Long id;

    private Long materialId;

    private Long documentId;

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
     * @return document_id 
     */
    public Long getDocumentId() {
        return documentId;
    }

    /**
     * 
     * @param documentId 
     */
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
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
        sb.append(", documentId=").append(documentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}