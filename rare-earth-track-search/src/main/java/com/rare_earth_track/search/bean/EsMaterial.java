package com.rare_earth_track.search.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * 材料
 *
 * @author hhoa
 * @date 2022-07-15
 */
@Data
@Schema(description = "材料")
@Document(indexName = "materials", createIndex = false)
public class EsMaterial implements Serializable {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    @Schema(description = "名称")
    private String name;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "描述")
    private String description;
}