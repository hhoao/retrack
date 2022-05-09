package com.demo.rare_earth_track.service.impl;

import com.demo.rare_earth_track.bean.User;
import com.demo.rare_earth_track.service.RedisService;
import com.demo.rare_earth_track.service.UserCacheService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
@Service
public class UserCacheServiceImpl implements UserCacheService {
    private final RedisService redisService;
    public UserCacheServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Value("${redis.database}")
    private String redisDatabase;
    @Value("${redis.expire.common}")
    private Long redisExpire;
    @Value("${redis.key.admin}")
    private String redisKeyAdmin;

    @Override
    public User getUserByName(String username) {
        String key = redisDatabase + ":" + redisKeyAdmin + ":" + username;
        return (User)redisService.get(key);
    }

    @Override
    public void setUser(User user){
        String key = redisDatabase + ":" + redisKeyAdmin + ":" + user.getName();
        redisService.set(key, user, redisExpire);
    }
}
