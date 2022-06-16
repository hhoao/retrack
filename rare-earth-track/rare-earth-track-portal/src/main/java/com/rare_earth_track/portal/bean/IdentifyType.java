package com.rare_earth_track.portal.bean;

/**
 * @author hhoa
 * @date 2022/5/29
 **/

public enum IdentifyType {
    /**
     * 手机号
     */
    phone("phone"),
    /**
     * 邮件
     */
    email("email"),
    /**
     * 用户名
     */
    username("username");
    private final String value;
    IdentifyType(String value){
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
