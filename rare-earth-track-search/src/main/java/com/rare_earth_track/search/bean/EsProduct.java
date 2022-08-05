package com.rare_earth_track.search.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 产品信息
 * @author hhoa
 * @date 2022-07-15
 */
@Schema(description = "产品信")
@Data
@Document(indexName = "products", createIndex = false)
public class EsProduct implements Serializable {
    @Id
    private String id;
    @Schema(description = "工厂id")
    private Long factoryId;

    @Field(type = FieldType.Keyword)
    @Schema(description = "名称")
    private String name;

    @Field(type = FieldType.Keyword)
    @Schema(description = "批次")
    private String batchId;

    @Schema(description = "生产厂家")
    private String factory;

    @Schema(description = "图片")
    private String pic;

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

    @Serial
    private static final long serialVersionUID = 1L;
}