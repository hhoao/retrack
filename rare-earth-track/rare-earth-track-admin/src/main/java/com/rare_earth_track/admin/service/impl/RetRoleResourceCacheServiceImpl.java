package com.rare_earth_track.admin.service.impl;


import com.rare_earth_track.admin.service.RetRoleResourceCacheService;
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
public class RetRoleResourceCacheServiceImpl implements RetRoleResourceCacheService {
    private final RedisService redisService;

    @Value("${ret.redis.database}")
    private String redisDatabase;
    @Value("${ret.redis.key.resource-role}")
    private String redisKeyResourceRole;

    public String getRoleNameKey(String role){
        return redisDatabase + ":" + redisKeyResourceRole + ":" + role;
    }

    @Override
    public Boolean deleteByRoleName(String roleName) {
        return redisService.del(getRoleNameKey(roleName));
    }

    @Override
    public List<RetResource> getByRoleName(String role) {
        return (List<RetResource>)redisService.get(getRoleNameKey(role));
    }

    @Override
    public void setByRoleName(List<RetResource> retResources, String role){
        redisService.set(getRoleNameKey(role), retResources);
    }

}
