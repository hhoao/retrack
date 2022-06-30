package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName RetProductParam
 * @Description: TODO
 * @Author 匡龙
 * @Date 2022/6/6 10:39
 * @Version V1.0
 */
@Data
@Schema(description = "产品参数")
public class RetProductParam {

    @Schema(description = "工厂编号", required = true)
    private Integer factoryId;

    @Schema(description = "产品名称", required = true)
    private String name;

    @Schema(description = "产品批次", required = true)
    private String batchId;

    @Schema(description = "描述", required = true)
    private String description;

    @Schema(description = "出货日期", required = true)
    private Date dispatchTime;

    @Schema(description = "防潮标识", required = true)
    private String moistureProofLogo;

    @Schema(description = "规格", required = true)
    private String specification;

    @Schema(description = "包装类型", required = true)
    private String packingType;

    @Schema(description = "净重", required = true)
    private String netWeight;

    @Schema(description = "运输标志", required = true)
    private String transportLog;

    @Schema(description = "图片", required = true)
    private String pic;

    @Schema(description = "纯度", required = true)
    private String purity;

    @Schema(description = "生产设备", required = true)
    private String productionEquipment;

    @Schema(description = "物料配比", required = true)
    private String materialRatio;

    @Schema(description = "提取单位", required = true)
    private String extractionUnit;

    @Schema(description = "画册图片", required = true)
    private String albumPics;

    @Schema(description = "钕", required = true)
    private String Nd;

    @Schema(description = "钴", required = true)
    private String Co;

    @Schema(description = "硼", required = true)
    private String B;

    @Schema(description = "镝铽镨", required = true)
    private String DyTbPr;

    @Schema(description = "其他成分", required = true)
    private String other;

    @Schema(description = "稀土成分", required = true)
    private String RE;

    @Schema(description = "钕稀土混合成分", required = true)
    private String Nd_RE;

    @Schema(description = "镝稀土混合成分", required = true)
    private String Dy_RE;

    @Schema(description = "稀土氧化成分", required = true)
    private String REO;

    @Schema(description = "氧化钕稀土混合成分", required = true)
    private String Nd2O3_REO;

    @Schema(description = "氧化钕成分", required = true)
    private String Nd2O3;

    @Schema(description = "氧化镝稀土混合成分", required = true)
    private String Dy2O3_REO;

    @Schema(description = "稀土杂质", required = true)
    private String RE_impurities;

    @Schema(description = "非稀土杂质", required = true)
    private String non_RE_impurities;
}
