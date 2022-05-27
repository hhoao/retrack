package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetTokenCacheService;
import com.rare_earth_track.admin.service.RetUserRoleCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * token缓存
 * @author hhoa
 * @date 2022/5/14
 **/
@Service
@RequiredArgsConstructor
public class RetTokenCacheServiceImpl implements RetTokenCacheService {
    @Value("${ret.redis.expire.token}")
    private Long redisExpire;
    private final RetUserRoleCacheService userRoleCacheService;

    @Override
    public void expire(String username) {
        userRoleCacheService.expireByUsername(username, redisExpire);
    }

    @Override
    public void expire(String username, Long expiration) {
        userRoleCacheService.expireByUsername(username, expiration);
    }

    @Override
    public void setKey(String username, String roleName) {
        userRoleCacheService.setByUsername(username, roleName, redisExpire);
    }

    @Override
    public boolean hasKey(String username){
        return userRoleCacheService.hasByUserName(username);
    }

    @Override
    public String getKey(String username) {
        return userRoleCacheService.getByUsername(username);
    }

    @Override
    public void delKey(String username){
        userRoleCacheService.deleteByUsername(username);
    }
}
