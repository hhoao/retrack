package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 登录参数
 * @author hhoa
 * @date 2022/5/11
 **/
@Data
@Schema(description = "RetLoginParam", name = "用户登录参数")
public class RetLoginParam {
    @Schema(description = "用户名")
    private String name;
    @Schema(description = "密码")
    private String password;
}
