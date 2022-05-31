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
    @Schema(description = "认证类型")
    private IdentifyType identifyType;

    @Schema(description = "认证标识")
    private String identifier;

    @Schema(description = "验证码")
    private String authCode;

}
