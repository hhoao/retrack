package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName RetHelpParam
 * @Description: 用户帮助参数
 * @Author 匡龙
 * @Date 2022/6/24 15:04
 * @Version V1.0
 */
@Data
@Schema(description = "用户帮助参数")
public class RetHelpParam {
    @Schema(description = "分类编号", required = true)
    private Integer helpCategoryId;

    @Schema(description = "名称", required = true)
    private String name;

    @Schema(description = "内容", required = true)
    private String content;

    @Schema(description = "标题", required = true)
    private String title;

    @Schema(description = "创建时间", required = true)
    private Date createTime;

    @Schema(description = "阅读量", required = true)
    private Integer reading;

    @Schema(description = "排序", required = true)
    private Integer sort;
}
