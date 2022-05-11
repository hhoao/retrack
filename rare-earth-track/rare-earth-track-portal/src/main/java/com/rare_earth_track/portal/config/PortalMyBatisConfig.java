package com.rare_earth_track.portal.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhoa
 * @date 2022/5/5
 **/
@Configuration
@MapperScan(basePackages = {"com.demo.rare_earth_track.portal.dao"})
public class PortalMyBatisConfig {
}
