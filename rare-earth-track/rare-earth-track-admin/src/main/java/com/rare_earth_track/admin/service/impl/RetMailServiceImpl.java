package com.rare_earth_track.admin.service.impl;

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
    private final MailSender mailSender;
    private final RetMailCacheService mailCacheService;
    /**
     * 发送方邮箱
     */
    @Value("${ret.mail.from}")
    private String from;

    @Override
    public void sendAuthCode(String authCode, String to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setSubject("验证码");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(authCode);
        mailSender.send(simpleMailMessage);
    }
    @Override
    public boolean existAuthCode(String to){
        return mailCacheService.existAuthCode(from, to);
    }

    @Override
    public boolean validateAuthCode(String to, String code) {
        return getAuthCode(to).equals(code);
    }

    @Override
    public void generateAndSendAuthCode(String to) {
        if (existAuthCode(to)){
            Asserts.fail("短时间内不能再验证码");
        }
        String authCode = generateAuthCode();
        mailCacheService.setMailAuthCode(from, to, authCode);
        sendAuthCode(authCode, to);
    }

    @Override
    public String getAuthCode(String to) {
        String mailAuthCode = mailCacheService.getMailAuthCode(from, to);
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
