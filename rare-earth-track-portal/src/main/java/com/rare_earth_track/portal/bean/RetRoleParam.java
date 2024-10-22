package com.rare_earth_track.portal.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hhoa
 * @date 2022/5/16
 **/
@Data
@Schema(description= "角色参数")
public class RetRoleParam {
    @Schema(description = "名称")
    private String name;

    @Schema(description = "描述")
    private String description;
}
