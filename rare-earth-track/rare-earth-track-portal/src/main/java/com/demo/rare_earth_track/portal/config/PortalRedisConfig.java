package com.demo.rare_earth_track.portal.config;

import com.demo.rare_earth_track.common.config.RedisConfig;
import com.demo.rare_earth_track.common.service.RedisService;
import com.demo.rare_earth_track.common.service.impl.RedisServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author hhoa
 * @date 2022/5/10
 **/
@Configuration
public class PortalRedisConfig extends RedisConfig {
    @Bean
    public RedisService redisService(RedisTemplate<String, Object> redisTemplate){
        return new RedisServiceImpl(redisTemplate);
    }
}
