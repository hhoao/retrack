package com.rare_earth_track.admin.service;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
public interface RetMailService {
    /**
     * 发送验证码
     * @param authCode 验证码
     * @param to 接受方
     */
    void sendAuthCode(String authCode, String to);

    /**
     * 生成并且发送验证码
     * @param to 接收方
     */
    void generateAndSendAuthCode(String to);

    /**
     * 获取验证码
     * @param to 接收方
     * @return 验证码
     */
    String getAuthCode(String to);

    /**
     * 是否存在验证码
     * @param to 接收方
     * @return boolean
     */
    boolean existAuthCode(String to);

    /**
     * 验证验证码
     * @param to 接收方
     * @param code 验证码
     * @return boolean
     */
    boolean validateAuthCode(String to, String code);
}
