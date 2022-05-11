package com.rare_earth_track.mgb.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author hhoa
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Schema(description = "用户")
public class RetUser {
    @Schema(description = "id")
    private int id;

    @Schema(description = "性名")
    private String name;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "年龄")
    private Integer age;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Schema(description = "生日")
    private LocalDate birthday;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "状态")
    private String status;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "头像")
    private String icon;

    @Schema(description = " 工作")
    private String job;

    @Schema(description = "个性签名")
    private String personalizedSignature;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "最后登录时间")
    private Date latestTime;
}
