package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
 * 反馈
 * @author hhoa 
 * @date 2022-06-16
 */
@Schema(description = "反馈")
public class RetFeedback implements Serializable {
    private Long id;

    private Long feedbackCategoryId;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "状态: 0->未处理, 1->处理中, 2->已处理")
    private Integer status;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "反馈对象")
    private String object;

    @Schema(description = "内容")
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
     * @return feedback_category_id 
     */
    public Long getFeedbackCategoryId() {
        return feedbackCategoryId;
    }

    /**
     * 
     * @param feedbackCategoryId 
     */
    public void setFeedbackCategoryId(Long feedbackCategoryId) {
        this.feedbackCategoryId = feedbackCategoryId;
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
     * 类型
     * @return type 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 类型
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 状态: 0->未处理, 1->处理中, 2->已处理
     * @return status 状态: 0->未处理, 1->处理中, 2->已处理
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态: 0->未处理, 1->处理中, 2->已处理
     * @param status 状态: 0->未处理, 1->处理中, 2->已处理
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 反馈对象
     * @return object 反馈对象
     */
    public String getObject() {
        return object;
    }

    /**
     * 反馈对象
     * @param object 反馈对象
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
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
        sb.append(", feedbackCategoryId=").append(feedbackCategoryId);
        sb.append(", title=").append(title);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", object=").append(object);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}