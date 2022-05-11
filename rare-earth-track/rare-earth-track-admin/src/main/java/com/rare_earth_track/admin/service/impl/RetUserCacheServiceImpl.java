package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetUserCacheService;
import com.rare_earth_track.common.service.RedisService;
import com.rare_earth_track.mgb.model.RetUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
@Service
public class RetUserCacheServiceImpl implements RetUserCacheService {
    private final RedisService redisService;
    public RetUserCacheServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Value("${redis.database}")
    private String redisDatabase;
    @Value("${redis.expire.common}")
    private Long redisExpire;
    @Value("${redis.key.admin}")
    private String redisKeyAdmin;

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
}
