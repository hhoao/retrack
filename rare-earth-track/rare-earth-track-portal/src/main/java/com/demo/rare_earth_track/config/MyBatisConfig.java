package com.demo.rare_earth_track.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hhoa
 * @date 2022/5/5
 **/
@Configuration
@MapperScan(basePackages = {"org.hhoa.dao"})
public class MyBatisConfig {
}
