package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 工厂成员
 * @author hhoa 
 * @date 2022-05-29
 */
@Schema(name = "工厂成员")
public class RetMember implements Serializable {
    private Long id;

    @Schema(description = "联系方式")
    private String phone;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "职位id")
    private Long jobId;

    @Schema(description = "工厂id")
    private Long factoryId;

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
     * 联系方式
     * @return phone 联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系方式
     * @param phone 联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 昵称
     * @return nickname 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 职位id
     * @return job_id 职位id
     */
    public Long getJobId() {
        return jobId;
    }

    /**
     * 职位id
     * @param jobId 职位id
     */
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    /**
     * 工厂id
     * @return factory_id 工厂id
     */
    public Long getFactoryId() {
        return factoryId;
    }

    /**
     * 工厂id
     * @param factoryId 工厂id
     */
    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
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
        sb.append(", phone=").append(phone);
        sb.append(", nickname=").append(nickname);
        sb.append(", userId=").append(userId);
        sb.append(", jobId=").append(jobId);
        sb.append(", factoryId=").append(factoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}