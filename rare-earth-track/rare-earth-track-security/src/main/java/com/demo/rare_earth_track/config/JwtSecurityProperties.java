package com.demo.rare_earth_track.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/5
 **/

@Data
@ConfigurationProperties("jwt")
public class JwtSecurityProperties {
    private String secret;
    private Long expiration;
    private String tokenHeader;
    private String tokenHead;
    private Integer refreshTime;
    private IgnoreUrlsConfig ignored =new IgnoreUrlsConfig();
    @Data
    public static class IgnoreUrlsConfig {
        private List<String> urls;
    }
}
