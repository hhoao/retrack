package com.rare_earth_track.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hhoa
 * @date 2022/5/10
 **/
@SpringBootApplication(scanBasePackages = {"com.rare_earth_track.portal", "com.rare_earth_track.mgb", "com.rare_earth_track.common", "com.rare_earth_track.security"})
public class RareEarthTrackPortalApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RareEarthTrackPortalApplication.class, args);
    }

}
