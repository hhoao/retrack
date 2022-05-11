package com.rare_earth_track.admin.service.impl;


import com.rare_earth_track.admin.service.RetResourceCacheService;
import com.rare_earth_track.common.service.RedisService;
import com.rare_earth_track.mgb.model.RetResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
@Service
public class RetResourceCacheServiceImpl implements RetResourceCacheService {
    private final RedisService redisService;
    public RetResourceCacheServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Value("${redis.database}")
    private String redisDatabase;
    @Value("${redis.expire.common}")
    private Long redisExpire;
    @Value("${redis.key.resources}")
    private String redisKeyResources;

    @Override
    public List<RetResource> getResourcesByUserId(Long id) {
        String key = redisDatabase + ":" + redisKeyResources + ":" + id;
        return (List<RetResource>)redisService.get(key);
    }

    @Override
    public void setResourcesByUserId(List<RetResource> retResources, Long id){
        String key = redisDatabase + ":" + redisKeyResources + ":" + id;
        redisService.set(key, retResources, redisExpire);
    }
}
