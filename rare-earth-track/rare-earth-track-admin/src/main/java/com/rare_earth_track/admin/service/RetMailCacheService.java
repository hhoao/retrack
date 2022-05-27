package com.rare_earth_track.admin.service;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
public interface RetMailCacheService {
    /**
     * 设置mail验证码
     * @param to 接收方
     * @param from 发送方
     * @param authCode 验证码
     * @param type 类型
     */
    void setMailMessage(String from, String to, String authCode, String type);

    /**
     * 获取邮箱验证码
     * @param from 发送方
     * @param to 接收方
     * @param type 类型
     * @return 验证码
     */
    String getMailMessage(String from, String to, String type);

    /**
     * 判断是否存在验证码
     * @param from 接收方
     * @param to 发送方
     * @param type 类型
     * @return 是否存在
     */
    boolean existMessage(String from, String to, String type);
}
