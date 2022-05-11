package com.rare_earth_track.admin.config;

import com.rare_earth_track.common.config.BaseSwaggerConfig;
import com.rare_earth_track.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhoa
 * @date 2022/5/11
 **/
@Configuration
public class AdminSwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.demo.rare_earth_track.portal.controller")
                .title("RETrack后台系统")
                .description("RETrack后台相关接口")
                .contactName("")
                .contactUrl("")
                .contactEmail("huanghaohhoa@163.com")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
