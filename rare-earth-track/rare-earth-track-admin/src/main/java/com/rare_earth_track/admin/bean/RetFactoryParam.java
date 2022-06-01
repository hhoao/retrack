package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author hhoa
 * @date 2022/5/31
 **/
@Schema(name = "工厂参数")
public class RetFactoryParam {
    @Schema(description = "工厂名")
    private String name;

    @Schema(description = "联系电话")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "描述")
    private String description;

}
