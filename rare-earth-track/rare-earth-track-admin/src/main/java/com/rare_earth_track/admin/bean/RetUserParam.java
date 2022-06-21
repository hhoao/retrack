package com.rare_earth_track.admin.bean;

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

/**
 * 用户参数
 * @author hhoa
 * @date 2022/5/7
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Schema(description="用户参数")
public class RetUserParam {
    @Schema(description = "id")
    private String id;
    @Schema(description = "角色id")
    private String roleId;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别: 0->未知, 1->男, 2->女", allowableValues = {"1", "0"})
    private Integer sex;

    @Schema(description = "用户年龄")
    private Integer age;
    
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Schema(description = "生日")
    private LocalDate birthday;
    
    @Schema(description = "用户地址")
    private String address;

    @Schema(description = "头像")
    private String icon;

    @Schema(description = "职业")
    private String job;

    @Schema(description = "个性签名")
    private String personalizedSignature;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "启用状态 1->启用, 0->禁用")
    private String status;
}
