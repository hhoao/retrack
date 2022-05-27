package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetMailCacheService;
import com.rare_earth_track.common.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
@Service
@RequiredArgsConstructor
public class RetMailCacheServiceImpl implements RetMailCacheService {
    private final RedisService redisService;
    @Value("${ret.redis.database}")
    private String redisDatabase;
    @Value("${ret.redis.expire.mail}")
    private Long redisExpire;
    @Value("${ret.redis.auth-code.mail}")
    private String redisKeyMailAuthCode;

    public String generateAuthCodeKey(String from, String to, String type){
        return redisDatabase + ":" + redisKeyMailAuthCode + ":" + type + ":" + from + ":" + to;
    }
    @Override
    public String getMailMessage(String from, String to, String type) {
        return (String) redisService.get(generateAuthCodeKey(from, to, type));
    }

    @Override
    public boolean existMessage(String from, String to, String type) {
        return redisService.hasKey(generateAuthCodeKey(from, to, type));
    }

    @Override
    public void setMailMessage(String from, String to, String authCode, String type) {
        redisService.set(generateAuthCodeKey(from, to, type), authCode, redisExpire);
    }
}
