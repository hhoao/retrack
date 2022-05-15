package com.rare_earth_track.admin.service.impl;


import com.rare_earth_track.admin.service.RetResourceCacheService;
import com.rare_earth_track.common.service.RedisService;
import com.rare_earth_track.mgb.model.RetResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/8
 **/
@Service
@RequiredArgsConstructor
public class RetResourceCacheServiceImpl implements RetResourceCacheService {
    private final RedisService redisService;

    @Value("${ret.redis.database}")
    private String redisDatabase;
    @Value("${ret.redis.expire.common}")
    private Long redisExpire;
    @Value("${ret.redis.key.resources}")
    private String redisKeyResources;

    public String getKey(String role){
        return redisDatabase + ":" + redisKeyResources + ":" + role;
    }
    @Override
    public List<RetResource> getResourcesByRoleName(String role) {
        return (List<RetResource>)redisService.get(getKey(role));
    }

    @Override
    public void setResourcesByRoleName(List<RetResource> retResources, String role){
        redisService.set(getKey(role), retResources, redisExpire);
    }
}
