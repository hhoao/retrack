package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.common.service.RedisService;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.portal.service.RetUserCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
@Service
@RequiredArgsConstructor
public class RetUserCacheServiceImpl implements RetUserCacheService {
    private final RedisService redisService;

    @Value("${ret.redis.database}")
    private String redisDatabase;
    @Value("${ret.redis.expire.common}")
    private Long redisExpire;
    @Value("${ret.redis.key.user}")
    private String redisKeyUser;
    @Value("${ret.redis.auth-code.phone}")
    private String redisKeyPhoneAuthCode;

    private String getUsernameKey(String user){
        return redisDatabase + ":" + redisKeyUser + ":" + user;
    }
    @Override
    public void expire(String username, Long expiration) {
        redisService.expire(getUsernameKey(username), expiration);
    }

    @Override
    public void expire(String username) {
        redisService.expire(getUsernameKey(username), redisExpire);
    }

    @Override
    public RetUser getUserByName(String username) {
        return (RetUser)redisService.get(getUsernameKey(username));
    }

    @Override
    public void setPhoneAuthCode(String phone, String authCode) {
        String key = redisDatabase+ ":" + redisKeyPhoneAuthCode + ":" + phone;
        redisService.set(key, authCode, redisExpire);
    }

    @Override
    public String getPhoneAuthCode(String phone) {
        String key = redisDatabase+ ":" + redisKeyPhoneAuthCode + ":" + phone;
        return (String)redisService.get(key);
    }

    @Override
    public void deleteUserByName(String username) {
        redisService.del(getUsernameKey(username));
    }
}
