package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 国标参考
 * @author 匡龙 
 * @date 2022-07-04
 */
@Schema(description = "国标参考")
public class RetGbReference implements Serializable {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "材料名称")
    private String name;

    @Schema(description = "牌号")
    private String standardNumber;

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

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 材料名称
     * @return name 材料名称
     */
    public String getName() {
        return name;
    }

    /**
     * 材料名称
     * @param name 材料名称
     */
    public void setName(String name) {
        this.name = name;
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
        sb.append(", name=").append(name);
        sb.append(", standardNumber=").append(standardNumber);
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}