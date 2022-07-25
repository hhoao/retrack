package com.rare_earth_track.admin.bean;

import cn.hutool.core.date.DateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @ClassName RetFeedbackParam
 * @Description: 反馈参数
 * @Author 匡龙
 * @Date 2022/6/20 14:56
 * @Version V1.0
 */
@Schema(description= "反馈参数")
@Data
public class RetFeedbackParam {

    @Schema(description = "反馈分类id")
    private Integer feedbackCategoryId;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "状态")
    private Integer status;

    @Schema(description = "创建时间")
    private DateTime createTime;

    @Schema(description = "反馈对象")
    private String object;
}
