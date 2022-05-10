package com.demo.rare_earth_track.portal.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
public class RetUserParam {
    private int id;
    private String name;
    private String sex;
    private Integer age;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthday;
    private String address;
    private String password;
    private List<RetResource> retResources;
}
