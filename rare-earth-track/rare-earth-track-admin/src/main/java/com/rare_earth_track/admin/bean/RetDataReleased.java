package com.rare_earth_track.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zgr
 * @version 1.0
 * @date 2022/7/11 8:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetDataReleased {
    /**
     * 资源ID
     */
    private Integer res_id;
    /**
     * 下发的数据
     */
    private String val;
}