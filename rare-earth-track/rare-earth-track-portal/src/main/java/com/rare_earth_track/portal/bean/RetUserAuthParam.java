package com.rare_earth_track.portal.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hhoa
 * @date 2022/5/30
 **/

@Data
@Schema(name = "用户认证参数", description = "RetUserAuthParam")
public class RetUserAuthParam {
    @Schema(description = "标识")
    private String identifier;

    @Schema(description = "凭证")
    private String credential;
}
