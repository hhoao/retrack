package com.rare_earth_track.portal.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hhoa
 * @date 2022/6/16
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "单页信息")
public class PageInfo {
    @Schema(description = "页码", defaultValue = "1")
    private Integer pageNum = 1;
    @Schema(description = "页面大小", defaultValue = "5")
    private Integer pageSize = 5;
}
