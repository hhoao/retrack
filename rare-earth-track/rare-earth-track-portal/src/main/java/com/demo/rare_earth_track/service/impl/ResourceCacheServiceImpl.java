package com.demo.rare_earth_track.service.impl;

import com.demo.rare_earth_track.bean.Resource;
import com.demo.rare_earth_track.service.RedisService;
import com.demo.rare_earth_track.service.ResourceCacheService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
@Service
public class ResourceCacheServiceImpl implements ResourceCacheService {
    private final RedisService redisService;
    public ResourceCacheServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    @Value("${redis.database}")
    private String redisDatabase;
    @Value("${redis.expire.common}")
    private Long redisExpire;
    @Value("${redis.key.resources}")
    private String redisKeyResources;

    @Override
    public List<Resource> getResourcesByUserId(Integer id) {
        String key = redisDatabase + ":" + redisKeyResources + ":" + id;
        return (List<Resource>)redisService.get(key);
    }

    @Override
    public void setResourcesByUserId(List<Resource> resources, Integer id){
        String key = redisDatabase + ":" + redisKeyResources + ":" + id;
        redisService.set(key, resources, redisExpire);
    }
}
