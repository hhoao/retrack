package com.rare_earth_track.portal.config;

import com.rare_earth_track.common.config.BaseSwaggerConfig;
import com.rare_earth_track.common.domain.SwaggerProperties;

/**
 * @author hhoa
 * @date 2022/5/11
 **/
public class PortalSwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.demo.rare_earth_track.portal.controller")
                .title("RETrack前台系统")
                .description("RETrack前台相关接口")
                .contactName("hhoa")
                .contactUrl("")
                .contactEmail("huanghaohhoa@163.com")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
