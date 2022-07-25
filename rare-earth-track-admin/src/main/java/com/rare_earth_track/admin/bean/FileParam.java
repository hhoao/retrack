package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
