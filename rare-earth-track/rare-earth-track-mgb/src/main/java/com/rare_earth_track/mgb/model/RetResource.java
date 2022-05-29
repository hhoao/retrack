package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
 * 资源
 * @author hhoa 
 * @date 2022-05-29
 */
@Schema(name = "资源")
public class RetResource implements Serializable {
    private Long id;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "资源名称")
    private String name;

    @Schema(description = "请求方法")
    private String method;

    @Schema(description = "请求路径")
    private String url;

    @Schema(description = "描述")
    private String description;

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
     * 资源名称
     * @return name 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 资源名称
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 请求方法
     * @return method 请求方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 请求方法
     * @param method 请求方法
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 请求路径
     * @return url 请求路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 请求路径
     * @param url 请求路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
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
        sb.append(", createTime=").append(createTime);
        sb.append(", name=").append(name);
        sb.append(", method=").append(method);
        sb.append(", url=").append(url);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}