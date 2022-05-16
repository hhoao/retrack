package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hhoa
 * @date 2022/5/16
 **/
@Data
@Schema(description = "RetResourceParam", name = "资源参数")
public class RetResourceParam {
    @Schema(description = "资源名称", required = true)
    private String name;

    @Schema(description = "请求方法", required = true)
    private String method;

    @Schema(description = "请求路径", required = true)
    private String url;

    @Schema(description = "描述", required = true)
    private String description;
}
