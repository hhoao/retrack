package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.bean.MailType;
import com.rare_earth_track.admin.service.RetMailCacheService;
import com.rare_earth_track.admin.service.RetMailService;
import com.rare_earth_track.common.exception.Asserts;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
@Service
@Data
@RequiredArgsConstructor
public class RetMailServiceImpl implements RetMailService {
    /**
     * 邮件类型
     */

    private final MailSender mailSender;
    private final RetMailCacheService mailCacheService;
    /**
     * 发送方邮箱
     */
    @Value("${ret.mail.from}")
    private String from;

    /**
     * 发送要缓存的信息
     * @param to 接收方
     * @param subject 主题
     * @param body 消息体
     * @param cacheBody 需要缓存的消息
     * @param typeId 类型Id
     */
    private void sendTerminableMessage(String to, String subject, String body, String cacheBody, String typeId) {
        sendMessage(to, subject, body);
        mailCacheService.setMailMessage(from, to, cacheBody, typeId);
    }

    /**
     * 发送普通消息
     * @param to 接收方
     * @param subject 主题
     * @param body 消息体
     */
    private void sendMessage(String to, String subject, String body){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(this.from);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(body);
        mailSender.send(simpleMailMessage);
    }

    /**
     * 发送消息
     * @param to 接收方
     * @param type 类型
     */
    public void sendMessage(String to, MailType type){
        switch (type) {
            case USER_REGISTER -> {
                String authCode = generateAuthCode();
                sendTerminableMessage( to, "验证码", authCode, authCode, MailType.USER_REGISTER.toString());
            }
            case FACTORY_INVITATION -> sendTerminableMessage( to, "邀请地址", "http://localhost:8080/", null, MailType.USER_REGISTER.toString());
        }
    }
    @Override
    public boolean existMessage(String to, MailType type){
        return mailCacheService.existMessage(from, to, type.toString());
    }

    @Override
    public boolean validateMessage(String to, String code, MailType type) {
        return getMessage(to, type).equals(code);
    }

    @Override
    public void generateAndSendMessage(String to, MailType type) {
        if (existMessage(to, type)){
            Asserts.fail("短时间内不能再验证码");
        }
        String authCode = generateAuthCode();

        sendMessage(to, type);
    }

    @Override
    public String getMessage(String to, MailType type) {
        String mailAuthCode = mailCacheService.getMailMessage(from, to, type.toString());
        if (mailAuthCode == null){
            Asserts.fail("没有该验证码或验证码已失效");
        }
        return mailAuthCode;
    }

    private String generateAuthCode() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
