package com.rare_earth_track.portal.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
public class RetFactoryJob implements Serializable {
    @Schema(description = "工厂名")
    private String factoryName;
    @Schema(description = "职位名")
    private String jobName;
}
