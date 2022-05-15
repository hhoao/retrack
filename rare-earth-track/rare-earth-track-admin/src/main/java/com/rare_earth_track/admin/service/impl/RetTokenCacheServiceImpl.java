package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetTokenCacheService;
import com.rare_earth_track.common.service.RedisService;
import com.rare_earth_track.mgb.model.RetResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/14
 **/
@Service
@RequiredArgsConstructor
public class RetTokenCacheServiceImpl implements RetTokenCacheService {
    private final RedisService redisService;
    @Value("${ret.redis.database}")
    private String redisDatabase;
    @Value("${ret.redis.expire.token}")
    private Long redisExpire;
    @Value("${ret.redis.key.token}")
    private String redisKeyRole;
    private String redisKeyTokenResources;

    public String generateRoleKey(String username){
        return  redisDatabase + ":" + redisKeyRole + ":" + username;
    }
    public String generateResourcesKey(String roleName){
        return  redisDatabase + ":" + redisKeyRole + ":" + roleName;
    }
    @Override
    public void expire(String username) {
        String roleNameByUserName = getRoleNameByUserName(username);
        redisService.expire(roleNameByUserName, redisExpire);
        redisService.expire(username, redisExpire);
    }

    @Override
    public void expire(String username, Long expiration) {
        String roleNameByUserName = getRoleNameByUserName(username);
        redisService.expire(roleNameByUserName, expiration);
        redisService.expire(username, expiration);
    }

    @Override
    public void setKey(String username, String roleName, List<RetResource> resources) {
        setRoleNameByUserName(username, roleName);
        setResourcesByRoleName(roleName, resources);
    }
    @Override
    public List<RetResource> getKey(String username){
        String roleNameByUserName = getRoleNameByUserName(username);
        return getResourcesByRoleName(roleNameByUserName);
    }
    @Override
    public boolean hasKey(String username){
        return hasRoleNameByUserName(username);
    }
    @Override
    public void delKey(String username){
        String roleNameByUserName = getRoleNameByUserName(username);
        delResourcesByRoleName(roleNameByUserName);
        delRoleNameByUserName(username);
    }

    private void setResourcesByRoleName(String roleName, List<RetResource> resources){
        redisService.set(generateResourcesKey(roleName), resources, redisExpire);
    }
    private List<RetResource> getResourcesByRoleName(String roleName){
        return (List<RetResource>)redisService.get(generateResourcesKey(roleName));
    }

    private void setRoleNameByUserName(String username, String role) {
        redisService.set(generateRoleKey(username), role, redisExpire);
    }

    private boolean hasRoleNameByUserName(String username) {
        return redisService.hasKey(generateRoleKey(username));
    }

    private String getRoleNameByUserName(String username) {
        return (String)redisService.get(generateRoleKey(username));
    }

    private boolean delRoleNameByUserName(String username) {
        return redisService.del(generateRoleKey(username));
    }
    private boolean delResourcesByRoleName(String roleName){
        return redisService.del(generateResourcesKey(roleName));
    }
}
