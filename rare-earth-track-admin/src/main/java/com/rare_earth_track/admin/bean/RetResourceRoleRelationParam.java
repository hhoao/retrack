package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hhoa
 * @date 2022/5/16
 **/
@Data
@Schema(description= "资源角色关系参数")
public class RetResourceRoleRelationParam {
    @Schema(description = "资源Id")
    private Long resourceId;

    @Schema(description = "角色id")
    private Long roleId;
}
