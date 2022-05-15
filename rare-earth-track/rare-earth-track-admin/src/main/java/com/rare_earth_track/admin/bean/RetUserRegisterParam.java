package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hhoa
 * @date 2022/5/12
 **/
@Data
public class RetUserRegisterParam {
    @Schema(description = "用户名")
    private String name;

    @Schema(description = "用户邮箱")
    private String email;

    @Schema(description = "用户地址")
    private String address;
    @Schema(description = "用户密码")
    private String password;

    @Schema(description = "手机号")
    private Long phone;
}
