package com.rare_earth_track.admin;

import com.rare_earth_track.common.service.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author hhoa
 * @date 2022/5/10
 **/
@SpringBootApplication(scanBasePackages = "com.rare_earth_track")
public class RareEarthTrackAdminApplication {
    @Value("${server.port}")
    private int port;
    public static void main(String[] args) {
        SpringApplication.run(RareEarthTrackAdminApplication.class, args);
    }
}
