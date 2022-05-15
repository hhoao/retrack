package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hhoa
 * @date 2022/5/13
 **/
@Schema(description = "用户密码参数")
@Data
public class RetUserUpdatePasswordParam {
    @Schema(description = "手机号或者密码", required = true)
    private String phoneOrEmail;
    @Schema(description = "验证码", required = true)
    private String authCode;
    @Schema(description = "密码", required = true)
    private String password;
}
