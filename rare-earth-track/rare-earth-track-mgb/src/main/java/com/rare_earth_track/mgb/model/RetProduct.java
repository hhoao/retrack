package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
 * 产品信
 * @author 匡龙 
 * @date 2022-07-04
 */
@Schema(description = "产品信")
public class RetProduct implements Serializable {
    private Long id;

    @Schema(description = "工厂id")
    private Long factoryId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "批次")
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

    @Schema(description = "质量证明书")
    private String qualityCertificate;

    @Schema(description = "牌号")
    private String standardNumber;

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

    @Schema(description = "钕成分")
    private String nd;

    @Schema(description = "钴成分")
    private String co;

    @Schema(description = "硼成分")
    private String b;

    @Schema(description = "镝铽镨成分")
    private String dyTbPr;

    @Schema(description = "其他成分")
    private String other;

    @Schema(description = "稀土成分")
    private String re;

    @Schema(description = "钕稀土混合成分")
    private String ndRe;

    @Schema(description = "镝稀土混合成分")
    private String dyRe;

    @Schema(description = "稀土氧化成分")
    private String reo;

    @Schema(description = "氧化钕稀土混合成分")
    private String nd2o3Reo;

    @Schema(description = "氧化钕成分")
    private String nd2o3;

    @Schema(description = "氧化镝稀土混合成分")
    private String dy2o3Reo;

    @Schema(description = "稀土杂质")
    private String reImpurities;

    @Schema(description = "非稀土杂质")
    private String nonReImpurities;

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
     * 批次
     * @return batch_id 批次
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * 批次
     * @param batchId 批次
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
     * 质量证明书
     * @return quality_certificate 质量证明书
     */
    public String getQualityCertificate() {
        return qualityCertificate;
    }

    /**
     * 质量证明书
     * @param qualityCertificate 质量证明书
     */
    public void setQualityCertificate(String qualityCertificate) {
        this.qualityCertificate = qualityCertificate;
    }

    /**
     * 牌号
     * @return standard_number 牌号
     */
    public String getStandardNumber() {
        return standardNumber;
    }

    /**
     * 牌号
     * @param standardNumber 牌号
     */
    public void setStandardNumber(String standardNumber) {
        this.standardNumber = standardNumber;
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
     * 钕成分
     * @return Nd 钕成分
     */
    public String getNd() {
        return nd;
    }

    /**
     * 钕成分
     * @param nd 钕成分
     */
    public void setNd(String nd) {
        this.nd = nd;
    }

    /**
     * 钴成分
     * @return Co 钴成分
     */
    public String getCo() {
        return co;
    }

    /**
     * 钴成分
     * @param co 钴成分
     */
    public void setCo(String co) {
        this.co = co;
    }

    /**
     * 硼成分
     * @return B 硼成分
     */
    public String getB() {
        return b;
    }

    /**
     * 硼成分
     * @param b 硼成分
     */
    public void setB(String b) {
        this.b = b;
    }

    /**
     * 镝铽镨成分
     * @return Dy_Tb_Pr 镝铽镨成分
     */
    public String getDyTbPr() {
        return dyTbPr;
    }

    /**
     * 镝铽镨成分
     * @param dyTbPr 镝铽镨成分
     */
    public void setDyTbPr(String dyTbPr) {
        this.dyTbPr = dyTbPr;
    }

    /**
     * 其他成分
     * @return other 其他成分
     */
    public String getOther() {
        return other;
    }

    /**
     * 其他成分
     * @param other 其他成分
     */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * 稀土成分
     * @return RE 稀土成分
     */
    public String getRe() {
        return re;
    }

    /**
     * 稀土成分
     * @param re 稀土成分
     */
    public void setRe(String re) {
        this.re = re;
    }

    /**
     * 钕稀土混合成分
     * @return Nd_RE 钕稀土混合成分
     */
    public String getNdRe() {
        return ndRe;
    }

    /**
     * 钕稀土混合成分
     * @param ndRe 钕稀土混合成分
     */
    public void setNdRe(String ndRe) {
        this.ndRe = ndRe;
    }

    /**
     * 镝稀土混合成分
     * @return Dy_RE 镝稀土混合成分
     */
    public String getDyRe() {
        return dyRe;
    }

    /**
     * 镝稀土混合成分
     * @param dyRe 镝稀土混合成分
     */
    public void setDyRe(String dyRe) {
        this.dyRe = dyRe;
    }

    /**
     * 稀土氧化成分
     * @return REO 稀土氧化成分
     */
    public String getReo() {
        return reo;
    }

    /**
     * 稀土氧化成分
     * @param reo 稀土氧化成分
     */
    public void setReo(String reo) {
        this.reo = reo;
    }

    /**
     * 氧化钕稀土混合成分
     * @return Nd2O3_REO 氧化钕稀土混合成分
     */
    public String getNd2o3Reo() {
        return nd2o3Reo;
    }

    /**
     * 氧化钕稀土混合成分
     * @param nd2o3Reo 氧化钕稀土混合成分
     */
    public void setNd2o3Reo(String nd2o3Reo) {
        this.nd2o3Reo = nd2o3Reo;
    }

    /**
     * 氧化钕成分
     * @return Nd2O3 氧化钕成分
     */
    public String getNd2o3() {
        return nd2o3;
    }

    /**
     * 氧化钕成分
     * @param nd2o3 氧化钕成分
     */
    public void setNd2o3(String nd2o3) {
        this.nd2o3 = nd2o3;
    }

    /**
     * 氧化镝稀土混合成分
     * @return Dy2O3_REO 氧化镝稀土混合成分
     */
    public String getDy2o3Reo() {
        return dy2o3Reo;
    }

    /**
     * 氧化镝稀土混合成分
     * @param dy2o3Reo 氧化镝稀土混合成分
     */
    public void setDy2o3Reo(String dy2o3Reo) {
        this.dy2o3Reo = dy2o3Reo;
    }

    /**
     * 稀土杂质
     * @return RE_impurities 稀土杂质
     */
    public String getReImpurities() {
        return reImpurities;
    }

    /**
     * 稀土杂质
     * @param reImpurities 稀土杂质
     */
    public void setReImpurities(String reImpurities) {
        this.reImpurities = reImpurities;
    }

    /**
     * 非稀土杂质
     * @return non_RE_impurities 非稀土杂质
     */
    public String getNonReImpurities() {
        return nonReImpurities;
    }

    /**
     * 非稀土杂质
     * @param nonReImpurities 非稀土杂质
     */
    public void setNonReImpurities(String nonReImpurities) {
        this.nonReImpurities = nonReImpurities;
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
        sb.append(", qualityCertificate=").append(qualityCertificate);
        sb.append(", standardNumber=").append(standardNumber);
        sb.append(", purity=").append(purity);
        sb.append(", productionEquipment=").append(productionEquipment);
        sb.append(", materialRatio=").append(materialRatio);
        sb.append(", extractionUnit=").append(extractionUnit);
        sb.append(", albumPics=").append(albumPics);
        sb.append(", nd=").append(nd);
        sb.append(", co=").append(co);
        sb.append(", b=").append(b);
        sb.append(", dyTbPr=").append(dyTbPr);
        sb.append(", other=").append(other);
        sb.append(", re=").append(re);
        sb.append(", ndRe=").append(ndRe);
        sb.append(", dyRe=").append(dyRe);
        sb.append(", reo=").append(reo);
        sb.append(", nd2o3Reo=").append(nd2o3Reo);
        sb.append(", nd2o3=").append(nd2o3);
        sb.append(", dy2o3Reo=").append(dy2o3Reo);
        sb.append(", reImpurities=").append(reImpurities);
        sb.append(", nonReImpurities=").append(nonReImpurities);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}