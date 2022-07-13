package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
 * 产品信
 * @author 匡龙 
 * @date 2022-07-13
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

    @Schema(description = "生产厂家")
    private String factory;

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

    @Schema(description = "原料批次")
    private String rawMaterialBatch;

    @Schema(description = "质量证明书")
    private String qualityCertificate;

    @Schema(description = "牌号")
    private String standardNumber;

    @Schema(description = "生产阶段")
    private String productionPhase;

    @Schema(description = "矿山工艺")
    private String miningTechnology;

    @Schema(description = "冶炼")
    private String mine;

    @Schema(description = "分离")
    private String separate;

    @Schema(description = "含氧量")
    private String oxygenLevels;

    @Schema(description = "压力")
    private String pressure;

    @Schema(description = "磁场大小")
    private String magneticField;

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
     * 生产厂家
     * @return factory 生产厂家
     */
    public String getFactory() {
        return factory;
    }

    /**
     * 生产厂家
     * @param factory 生产厂家
     */
    public void setFactory(String factory) {
        this.factory = factory;
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
     * 原料批次
     * @return raw_material_batch 原料批次
     */
    public String getRawMaterialBatch() {
        return rawMaterialBatch;
    }

    /**
     * 原料批次
     * @param rawMaterialBatch 原料批次
     */
    public void setRawMaterialBatch(String rawMaterialBatch) {
        this.rawMaterialBatch = rawMaterialBatch;
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
     * 生产阶段
     * @return production_phase 生产阶段
     */
    public String getProductionPhase() {
        return productionPhase;
    }

    /**
     * 生产阶段
     * @param productionPhase 生产阶段
     */
    public void setProductionPhase(String productionPhase) {
        this.productionPhase = productionPhase;
    }

    /**
     * 矿山工艺
     * @return mining_technology 矿山工艺
     */
    public String getMiningTechnology() {
        return miningTechnology;
    }

    /**
     * 矿山工艺
     * @param miningTechnology 矿山工艺
     */
    public void setMiningTechnology(String miningTechnology) {
        this.miningTechnology = miningTechnology;
    }

    /**
     * 冶炼
     * @return mine 冶炼
     */
    public String getMine() {
        return mine;
    }

    /**
     * 冶炼
     * @param mine 冶炼
     */
    public void setMine(String mine) {
        this.mine = mine;
    }

    /**
     * 分离
     * @return separate 分离
     */
    public String getSeparate() {
        return separate;
    }

    /**
     * 分离
     * @param separate 分离
     */
    public void setSeparate(String separate) {
        this.separate = separate;
    }

    /**
     * 含氧量
     * @return oxygen_levels 含氧量
     */
    public String getOxygenLevels() {
        return oxygenLevels;
    }

    /**
     * 含氧量
     * @param oxygenLevels 含氧量
     */
    public void setOxygenLevels(String oxygenLevels) {
        this.oxygenLevels = oxygenLevels;
    }

    /**
     * 压力
     * @return pressure 压力
     */
    public String getPressure() {
        return pressure;
    }

    /**
     * 压力
     * @param pressure 压力
     */
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    /**
     * 磁场大小
     * @return magnetic_field 磁场大小
     */
    public String getMagneticField() {
        return magneticField;
    }

    /**
     * 磁场大小
     * @param magneticField 磁场大小
     */
    public void setMagneticField(String magneticField) {
        this.magneticField = magneticField;
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
        sb.append(", factory=").append(factory);
        sb.append(", dispatchTime=").append(dispatchTime);
        sb.append(", moistureProofLogo=").append(moistureProofLogo);
        sb.append(", specification=").append(specification);
        sb.append(", packingType=").append(packingType);
        sb.append(", netWeight=").append(netWeight);
        sb.append(", transportLog=").append(transportLog);
        sb.append(", rawMaterialBatch=").append(rawMaterialBatch);
        sb.append(", qualityCertificate=").append(qualityCertificate);
        sb.append(", standardNumber=").append(standardNumber);
        sb.append(", productionPhase=").append(productionPhase);
        sb.append(", miningTechnology=").append(miningTechnology);
        sb.append(", mine=").append(mine);
        sb.append(", separate=").append(separate);
        sb.append(", oxygenLevels=").append(oxygenLevels);
        sb.append(", pressure=").append(pressure);
        sb.append(", magneticField=").append(magneticField);
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