package com.demo.rare_earth_track.bean;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by macro on 2022/3/19
 *
 * @author hhoa
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Resource implements Serializable {
    private Long id;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "权限名称名称")
    private String name;

    @Schema(description = "权限URL")
    private String url;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "请求方法")
    private String method;

    @Serial
    private static final long serialVersionUID = 1L;
}
