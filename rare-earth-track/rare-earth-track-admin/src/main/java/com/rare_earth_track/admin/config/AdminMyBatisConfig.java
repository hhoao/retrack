package com.rare_earth_track.admin.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhoa
 * @date 2022/5/5
 **/
@Configuration
@MapperScan(basePackages = {"com.rare_earth_track.admin.dao", "com.rare_earth_track.mgb.mapper"})
public class AdminMyBatisConfig {
}
