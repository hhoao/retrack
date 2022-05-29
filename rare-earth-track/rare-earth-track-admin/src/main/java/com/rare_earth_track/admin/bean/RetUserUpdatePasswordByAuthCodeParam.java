package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户密码更新需要的参数
 * @author hhoa
 * @date 2022/5/13
 **/
@Schema(name = "用户通过验证码密码参数", description = "RetUserUpdatePasswordParam")
@Data
public class RetUserUpdatePasswordByAuthCodeParam {
    @Schema(description = "验证方式", required = true , allowableValues = {"email", "phone"})
    private IdentifyType identifyType;

    @Schema(description = "验证标识")
    private String identifier;

    @Schema(description = "验证码", required = true)
    private String authCode;

    @Schema(description = "新密码", required = true)
    private String password;
}
