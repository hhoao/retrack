package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
 * 产品信
 * @author hhoa 
 * @date 2022-05-29
 */
@Schema(name = "产品信")
public class RetProduct implements Serializable {
    private Long id;

    @Schema(description = "工厂id")
    private Long factoryId;

    @Schema(description = "名称")
    private String name;

    private String batchId;

    @Schema(description = "出货日期")
    private Date dispatchTime;

    @Schema(description = "防潮标识")
    private String moistureProofLogo;

    @Schema(description = "规格")
    private String specification;

    @Schema(description = "包装类型")
    private String packingType;

    @Schema(description = "净重")
    private String netWeight;

    @Schema(description = "运输标志")
    private String transportLog;

    @Schema(description = "图片")
    private String pic;

    @Schema(description = "纯度")
    private String purity;

    @Schema(description = "生产设备")
    private String productionEquipment;

    @Schema(description = "物料配比")
    private String materialRatio;

    @Schema(description = "提取单位")
    private String extractionUnit;

    @Schema(description = "画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;

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
     * 工厂id
     * @return factory_id 工厂id
     */
    public Long getFactoryId() {
        return factoryId;
    }

    /**
     * 工厂id
     * @param factoryId 工厂id
     */
    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
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
     * 
     * @return batch_id 
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * 
     * @param batchId 
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * 出货日期
     * @return dispatch_time 出货日期
     */
    public Date getDispatchTime() {
        return dispatchTime;
    }

    /**
     * 出货日期
     * @param dispatchTime 出货日期
     */
    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    /**
     * 防潮标识
     * @return moisture_proof_logo 防潮标识
     */
    public String getMoistureProofLogo() {
        return moistureProofLogo;
    }

    /**
     * 防潮标识
     * @param moistureProofLogo 防潮标识
     */
    public void setMoistureProofLogo(String moistureProofLogo) {
        this.moistureProofLogo = moistureProofLogo;
    }

    /**
     * 规格
     * @return specification 规格
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 规格
     * @param specification 规格
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * 包装类型
     * @return packing_type 包装类型
     */
    public String getPackingType() {
        return packingType;
    }

    /**
     * 包装类型
     * @param packingType 包装类型
     */
    public void setPackingType(String packingType) {
        this.packingType = packingType;
    }

    /**
     * 净重
     * @return net_weight 净重
     */
    public String getNetWeight() {
        return netWeight;
    }

    /**
     * 净重
     * @param netWeight 净重
     */
    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    /**
     * 运输标志
     * @return transport_log 运输标志
     */
    public String getTransportLog() {
        return transportLog;
    }

    /**
     * 运输标志
     * @param transportLog 运输标志
     */
    public void setTransportLog(String transportLog) {
        this.transportLog = transportLog;
    }

    /**
     * 图片
     * @return pic 图片
     */
    public String getPic() {
        return pic;
    }

    /**
     * 图片
     * @param pic 图片
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 纯度
     * @return purity 纯度
     */
    public String getPurity() {
        return purity;
    }

    /**
     * 纯度
     * @param purity 纯度
     */
    public void setPurity(String purity) {
        this.purity = purity;
    }

    /**
     * 生产设备
     * @return production_equipment 生产设备
     */
    public String getProductionEquipment() {
        return productionEquipment;
    }

    /**
     * 生产设备
     * @param productionEquipment 生产设备
     */
    public void setProductionEquipment(String productionEquipment) {
        this.productionEquipment = productionEquipment;
    }

    /**
     * 物料配比
     * @return material_ratio 物料配比
     */
    public String getMaterialRatio() {
        return materialRatio;
    }

    /**
     * 物料配比
     * @param materialRatio 物料配比
     */
    public void setMaterialRatio(String materialRatio) {
        this.materialRatio = materialRatio;
    }

    /**
     * 提取单位
     * @return extraction_unit 提取单位
     */
    public String getExtractionUnit() {
        return extractionUnit;
    }

    /**
     * 提取单位
     * @param extractionUnit 提取单位
     */
    public void setExtractionUnit(String extractionUnit) {
        this.extractionUnit = extractionUnit;
    }

    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     * @return album_pics 画册图片，连产品图片限制为5张，以逗号分割
     */
    public String getAlbumPics() {
        return albumPics;
    }

    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     * @param albumPics 画册图片，连产品图片限制为5张，以逗号分割
     */
    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
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
        sb.append(", factoryId=").append(factoryId);
        sb.append(", name=").append(name);
        sb.append(", batchId=").append(batchId);
        sb.append(", dispatchTime=").append(dispatchTime);
        sb.append(", moistureProofLogo=").append(moistureProofLogo);
        sb.append(", specification=").append(specification);
        sb.append(", packingType=").append(packingType);
        sb.append(", netWeight=").append(netWeight);
        sb.append(", transportLog=").append(transportLog);
        sb.append(", pic=").append(pic);
        sb.append(", purity=").append(purity);
        sb.append(", productionEquipment=").append(productionEquipment);
        sb.append(", materialRatio=").append(materialRatio);
        sb.append(", extractionUnit=").append(extractionUnit);
        sb.append(", albumPics=").append(albumPics);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}