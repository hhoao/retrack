package com.rare_earth_track.admin.bean;

/**
 * 邮件类型
 */
public enum MailType {
    /**
     * 用户注册类型
     */
    USER_REGISTER(1),
    /**
     * 工厂邀请类型
     */
    FACTORY_INVITATION(2);
    /**
     * 类型唯一标志
     */
    private final Integer id;
    MailType(Integer id){
        this.id = id;
    }
    public String toString() {
        return id.toString();
    }
}