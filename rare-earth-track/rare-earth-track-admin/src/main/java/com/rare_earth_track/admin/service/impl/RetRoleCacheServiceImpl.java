package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetRoleCacheService;
import com.rare_earth_track.common.service.RedisService;
import com.rare_earth_track.mgb.model.RetRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/5/14
 **/
@Service
@RequiredArgsConstructor
public class RetRoleCacheServiceImpl implements RetRoleCacheService {
    private final RedisService redisService;
    @Value("${ret.redis.database}")
    private String redisDatabase;
    @Value("${ret.redis.expire.role}")
    private Long redisExpire;
    @Value("${ret.redis.key.role}")
    private String redisKeyAdmin;


    public String generateKeyByUserName(String userName){
        return redisDatabase + ":" + redisKeyAdmin + ":" + userName;
    }
    @Override
    public void setKeyByUserName(String userName, RetRole role) {
        redisService.set(generateKeyByUserName(userName), role, redisExpire);
    }
    @Override
    public void setKeyByUserName(String userName, RetRole role, Long expire) {
        redisService.set(generateKeyByUserName(userName), role, redisExpire);
    }
    @Override
    public RetRole getKeysByUserName(String username) {
        return (RetRole)redisService.get(generateKeyByUserName(username));
    }
}
