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

    @Schema(description = "化学成分", required = true)
    private String chemicalComposition;
}
