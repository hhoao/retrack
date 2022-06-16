package com.rare_earth_track.admin.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hhoa
 * @date 2022/5/31
 **/

@Schema(description= "成员参数")
@Data
public class RetMemberParam {
    @Schema(description = "联系方式")
    private String phone;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "职位id")
    private Long jobId;
}
