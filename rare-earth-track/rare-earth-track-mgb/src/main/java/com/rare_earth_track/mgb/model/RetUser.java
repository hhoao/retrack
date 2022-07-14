package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * @author hhoa 
 * @date 2022-07-14
 */
@Schema(description = "用户")
public class RetUser implements Serializable {
    private Long id;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "性别: 0->未知, 1->男, 2->女")
    private Integer sex;

    @Schema(description = "生日")
    private Date birthday;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "账号启用状态: 0->禁言， 1->启用")
    private Integer status;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "最后登录时间")
    private Date latestTime;

    @Schema(description = "头像")
    private String icon;

    @Schema(description = "职业")
    private String job;

    @Schema(description = "个性签名")
    private String personalizedSignature;

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
     * 年龄
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 性别: 0->未知, 1->男, 2->女
     * @return sex 性别: 0->未知, 1->男, 2->女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别: 0->未知, 1->男, 2->女
     * @param sex 性别: 0->未知, 1->男, 2->女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 生日
     * @return birthday 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 账号启用状态: 0->禁言， 1->启用
     * @return status 账号启用状态: 0->禁言， 1->启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 账号启用状态: 0->禁言， 1->启用
     * @param status 账号启用状态: 0->禁言， 1->启用
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
     * 最后登录时间
     * @return latest_time 最后登录时间
     */
    public Date getLatestTime() {
        return latestTime;
    }

    /**
     * 最后登录时间
     * @param latestTime 最后登录时间
     */
    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }

    /**
     * 头像
     * @return icon 头像
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 头像
     * @param icon 头像
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 职业
     * @return job 职业
     */
    public String getJob() {
        return job;
    }

    /**
     * 职业
     * @param job 职业
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 个性签名
     * @return personalized_signature 个性签名
     */
    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    /**
     * 个性签名
     * @param personalizedSignature 个性签名
     */
    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
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
        sb.append(", nickname=").append(nickname);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", latestTime=").append(latestTime);
        sb.append(", icon=").append(icon);
        sb.append(", job=").append(job);
        sb.append(", personalizedSignature=").append(personalizedSignature);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}