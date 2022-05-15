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
    @Value("${ret.redis.key.mail}")
    private String redisKeyAdmin;
    @Value("${ret.redis.auth-code.mail}")
    private String redisKeyMailAuthCode;

    public String generateAuthCodeKey(String from, String to){
        return redisDatabase + ":" + redisKeyMailAuthCode + ":" + from + ":" + to;
    }
    @Override
    public String getMailAuthCode(String from, String to) {
        return (String) redisService.get(generateAuthCodeKey(from, to));
    }

    @Override
    public boolean existAuthCode(String from, String to) {
        return redisService.hasKey(generateAuthCodeKey(from, to));
    }

    @Override
    public void setMailAuthCode(String from, String to, String authCode) {
        redisService.set(generateAuthCodeKey(from, to), authCode, redisExpire);
    }
}
