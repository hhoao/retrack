package com.rare_earth_track.admin.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.rare_earth_track.mgb.model.RetResource;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/7
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Schema(description = "用户参数")
public class RetUserParam {
    @Schema(description = "用户id")
    private int id;
    @Schema(description = "用户名")
    private String name;
    @Schema(description = "用户性别")
    private String sex;
    @Schema(description = "用户年龄")
    private Integer age;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Schema(description = "生日")
    private LocalDate birthday;
    @Schema(description = "用户地址")
    private String address;
    @Schema(description = "用户密码")
    private String password;
    @Schema(description = "用户拥有的资源")
    private List<RetResource> retResources;
}
