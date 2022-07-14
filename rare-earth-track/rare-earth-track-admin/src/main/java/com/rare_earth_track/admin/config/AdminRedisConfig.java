package com.rare_earth_track.admin.config;

import com.rare_earth_track.common.service.RedisService;
import com.rare_earth_track.common.service.impl.RedisServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author hhoa
 * @date 2022/5/10
 **/
@Configuration
public class AdminRedisConfig {
    @Bean
    public RedisService redisService(RedisTemplate<String, Object> redisTemplate){
        return new RedisServiceImpl(redisTemplate);
    }
}
