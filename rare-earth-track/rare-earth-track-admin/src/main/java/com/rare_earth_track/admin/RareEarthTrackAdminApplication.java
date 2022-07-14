package com.rare_earth_track.admin;

import com.rare_earth_track.common.service.RedisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hhoa
 * @date 2022/5/10
 **/
@SpringBootApplication(scanBasePackages = "com.rare_earth_track")
public class RareEarthTrackAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(RareEarthTrackAdminApplication.class, args);

    }
}
