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
     */
    void setMailAuthCode(String from, String to, String authCode);

    /**
     * 获取邮箱验证码
     * @param from 发送方
     * @param to 接收方
     * @return 验证码
     */
    String getMailAuthCode(String from, String to);

    /**
     * 判断是否存在验证码
     * @param from 接收方
     * @param to 发送方
     * @return 是否存在
     */
    boolean existAuthCode(String from, String to);
}
