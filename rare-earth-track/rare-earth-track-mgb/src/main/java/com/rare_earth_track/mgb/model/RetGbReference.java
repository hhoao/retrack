package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 国标参考
 * @author 匡龙 
 * @date 2022-06-30
 */
@Schema(description = "国标参考")
public class RetGbReference implements Serializable {
    @Schema(description = "主键")
    private Long id;

    @Schema(description = "材料")
    private String material;

    @Schema(description = "牌号")
    private String mark;

    @Schema(description = "成分1")
    private String component1;

    @Schema(description = "含量1")
    private String content1;

    @Schema(description = "成分2")
    private String component2;

    @Schema(description = "含量2")
    private String content2;

    @Schema(description = "成分3")
    private String component3;

    @Schema(description = "含量3")
    private String content3;

    @Schema(description = "成分4")
    private String component4;

    @Schema(description = "含量4")
    private String content4;

    @Schema(description = "成分5")
    private String component5;

    @Schema(description = "含量5")
    private String content5;

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
     * 材料
     * @return material 材料
     */
    public String getMaterial() {
        return material;
    }

    /**
     * 材料
     * @param material 材料
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * 牌号
     * @return mark 牌号
     */
    public String getMark() {
        return mark;
    }

    /**
     * 牌号
     * @param mark 牌号
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * 成分1
     * @return component1 成分1
     */
    public String getComponent1() {
        return component1;
    }

    /**
     * 成分1
     * @param component1 成分1
     */
    public void setComponent1(String component1) {
        this.component1 = component1;
    }

    /**
     * 含量1
     * @return content1 含量1
     */
    public String getContent1() {
        return content1;
    }

    /**
     * 含量1
     * @param content1 含量1
     */
    public void setContent1(String content1) {
        this.content1 = content1;
    }

    /**
     * 成分2
     * @return component2 成分2
     */
    public String getComponent2() {
        return component2;
    }

    /**
     * 成分2
     * @param component2 成分2
     */
    public void setComponent2(String component2) {
        this.component2 = component2;
    }

    /**
     * 含量2
     * @return content2 含量2
     */
    public String getContent2() {
        return content2;
    }

    /**
     * 含量2
     * @param content2 含量2
     */
    public void setContent2(String content2) {
        this.content2 = content2;
    }

    /**
     * 成分3
     * @return component3 成分3
     */
    public String getComponent3() {
        return component3;
    }

    /**
     * 成分3
     * @param component3 成分3
     */
    public void setComponent3(String component3) {
        this.component3 = component3;
    }

    /**
     * 含量3
     * @return content3 含量3
     */
    public String getContent3() {
        return content3;
    }

    /**
     * 含量3
     * @param content3 含量3
     */
    public void setContent3(String content3) {
        this.content3 = content3;
    }

    /**
     * 成分4
     * @return component4 成分4
     */
    public String getComponent4() {
        return component4;
    }

    /**
     * 成分4
     * @param component4 成分4
     */
    public void setComponent4(String component4) {
        this.component4 = component4;
    }

    /**
     * 含量4
     * @return content4 含量4
     */
    public String getContent4() {
        return content4;
    }

    /**
     * 含量4
     * @param content4 含量4
     */
    public void setContent4(String content4) {
        this.content4 = content4;
    }

    /**
     * 成分5
     * @return component5 成分5
     */
    public String getComponent5() {
        return component5;
    }

    /**
     * 成分5
     * @param component5 成分5
     */
    public void setComponent5(String component5) {
        this.component5 = component5;
    }

    /**
     * 含量5
     * @return content5 含量5
     */
    public String getContent5() {
        return content5;
    }

    /**
     * 含量5
     * @param content5 含量5
     */
    public void setContent5(String content5) {
        this.content5 = content5;
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
        sb.append(", material=").append(material);
        sb.append(", mark=").append(mark);
        sb.append(", component1=").append(component1);
        sb.append(", content1=").append(content1);
        sb.append(", component2=").append(component2);
        sb.append(", content2=").append(content2);
        sb.append(", component3=").append(component3);
        sb.append(", content3=").append(content3);
        sb.append(", component4=").append(component4);
        sb.append(", content4=").append(content4);
        sb.append(", component5=").append(component5);
        sb.append(", content5=").append(content5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}