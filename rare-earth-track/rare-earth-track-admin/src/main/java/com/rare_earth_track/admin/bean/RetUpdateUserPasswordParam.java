package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户认证更新需要的参数
 * @author hhoa
 * @date 2022/5/13
 **/
@Schema(name = "用户通过验证码密码参数", description = "RetUserUpdatePasswordParam")
@Data
public class RetUpdateUserPasswordParam {
    @Schema(description = "验证方式, 如果使用username方式，则必填identifier、oldPassword和newPassword," +
            "如果使用email或phone方式, 则必填identifier和authCode", required = true , allowableValues = {"username", "email", "phone"})
    private IdentifyType identifyType;

    @Schema(description = "验证标识", required = true)
    private String identifier;

    @Schema(description = "验证码")
    private String authCode;

    @Schema(description = "旧密码")
    private String oldPassword;

    @Schema(description = "新密码", required = true)
    private String newPassword;
}
