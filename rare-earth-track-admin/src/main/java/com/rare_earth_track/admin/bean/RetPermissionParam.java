package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hhoa
 * @date 2022/5/16
 **/
@Data
@Schema(description = "权限参数")
public class RetPermissionParam {
    @Schema(description = "权限名称", required = true)
    private String name;

    @Schema(description = "请求方法", required = true, allowableValues = {"POST", "GET", "PUT", "PATCH", "DELETE"})
    private String method;

    @Schema(description = "请求路径", required = true)
    private String url;

    @Schema(description = "描述", required = true)
    private String description;
}
