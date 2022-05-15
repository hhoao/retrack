package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetUserCacheService;
import com.rare_earth_track.common.service.RedisService;
import com.rare_earth_track.mgb.model.RetUser;
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
    @Value("${ret.redis.key.admin}")
    private String redisKeyAdmin;
    @Value("${ret.redis.auth-code.phone}")
    private String redisKeyPhoneAuthCode;


    @Override
    public RetUser getUserByName(String username) {
        String key = redisDatabase + ":" + redisKeyAdmin + ":" + username;
        return (RetUser)redisService.get(key);
    }

    @Override
    public void setUser(RetUser retUser){
        String key = redisDatabase + ":" + redisKeyAdmin + ":" + retUser.getName();
        redisService.set(key, retUser, redisExpire);
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
        String key = redisDatabase + ":" + redisKeyAdmin + ":" + username;
        redisService.del(key);
    }
}
