package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
 * 专题
 * @author 匡龙 
 * @date 2022-07-13
 */
@Schema(description = "专题")
public class RetSubject implements Serializable {
    private Long id;

    private Long subjectId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "阅读量")
    private Long reading;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "描述")
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return subject_id 
     */
    public Long getSubjectId() {
        return subjectId;
    }

    /**
     * 
     * @param subjectId 
     */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 阅读量
     * @return reading 阅读量
     */
    public Long getReading() {
        return reading;
    }

    /**
     * 阅读量
     * @param reading 阅读量
     */
    public void setReading(Long reading) {
        this.reading = reading;
    }

    /**
     * 排序
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 描述
     * @return content 描述
     */
    public String getContent() {
        return content;
    }

    /**
     * 描述
     * @param content 描述
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * toString
     * @return java.lang.String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", subjectId=").append(subjectId);
        sb.append(", name=").append(name);
        sb.append(", title=").append(title);
        sb.append(", createTime=").append(createTime);
        sb.append(", reading=").append(reading);
        sb.append(", sort=").append(sort);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}