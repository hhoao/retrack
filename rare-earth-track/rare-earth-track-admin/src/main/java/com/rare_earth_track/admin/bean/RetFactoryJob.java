package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * The type Ret factory job.
 *
 * @author hhoa
 * @date 2022 /5/27
 */
@Data
@Schema(description = "RetFactoryJob", name = "工厂职位")
@AllArgsConstructor
public class RetFactoryJob implements Serializable {
    @Schema(description = "工厂id")
    private Long factoryId;
    @Schema(description = "职位Id")
    private Long jobId;
}
