package com.rare_earth_track.portal.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hhoa
 * @date 2022/7/13
 **/

@Schema(description = "FileParam", name = "FileParam")
@Data
public class FileParam {
//    @Schema( type = "string", format = "binary")
//    private MultipartFile file;
    private String name;
}
