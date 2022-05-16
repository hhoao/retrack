package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 产品和产品文档关系
 * @author hhoa 
 * @date 2022-05-16
 */
@Schema(name = "产品和产品文档关系")
public class RetProductDocumentRelation implements Serializable {
    private Long id;

    private Long productId;

    private Long productDocumentId;

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
     * @return product_id 
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId 
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return product_document_id 
     */
    public Long getProductDocumentId() {
        return productDocumentId;
    }

    /**
     * 
     * @param productDocumentId 
     */
    public void setProductDocumentId(Long productDocumentId) {
        this.productDocumentId = productDocumentId;
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
        sb.append(", productId=").append(productId);
        sb.append(", productDocumentId=").append(productDocumentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}