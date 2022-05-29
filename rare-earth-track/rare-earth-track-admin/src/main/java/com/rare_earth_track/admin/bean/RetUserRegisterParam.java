package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 注册需要的参数
 * @author hhoa
 * @date 2022/5/12
 **/
@Data
@Schema(name = "用户注册参数", description = "RetUserRegisterParam")
public class RetUserRegisterParam {
    @Schema(description = "用户名")
    private String name;

    @Schema(description = "用户邮箱")
    private String email;
    @Schema(description = "用户密码")
    private String password;

    @Schema(description = "手机号")
    private String phone;
}
