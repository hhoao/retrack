package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.bean.RetUserDetails;
import com.rare_earth_track.admin.service.RetUserRoleCacheService;
import com.rare_earth_track.common.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/5/18
 **/
@Service
public class RetUserRoleCacheServiceImpl implements RetUserRoleCacheService {
    @Value("${ret.redis.database}")
    private String redisDatabase;
    @Value("${ret.redis.expire.common}")
    private Long redisExpire;

    @Value("${ret.redis.key.user-role}")
    private String redisKeyRole;
    private RedisService redisService;

    @Lazy
    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }


    public String getUserNameKey(String username){
        return redisDatabase + ":" + redisKeyRole + ":" + username;
    }

    @Override
    public boolean hasByUserName(String username) {
        return redisService.hasKey(getUserNameKey(username));
    }

    @Override
    public void expireByUsername(String username, Long expiration) {
        if (expiration != null) {
            redisService.expire(getUserNameKey(username), expiration);
        }else {
            redisService.expire(getUserNameKey(username), redisExpire);
        }
    }


    @Override
    public String getByUsername(String username) {
        return (String)redisService.get(getUserNameKey(username));
    }


    @Override
    public void setByUsername(String username, RetUserDetails userDetails, Long expiration) {
        if (expiration == null){
            redisService.set(getUserNameKey(username), userDetails, redisExpire);
        }else {
            redisService.set(getUserNameKey(username), userDetails, expiration);
        }
    }

    @Override
    public void deleteByUsername(String username) {
        redisService.del(getUserNameKey(username));
    }
}
