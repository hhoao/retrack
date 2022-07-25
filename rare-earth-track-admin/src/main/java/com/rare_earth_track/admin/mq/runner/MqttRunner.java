package com.rare_earth_track.admin.mq.runner;

import com.rare_earth_track.admin.mq.MqClient;
import com.rare_earth_track.admin.mq.handler.DataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author zgr
 * @version 1.0
 * @date 2022/7/7 10:12
 */
@Component
@ComponentScan("com.rare_earth_track.mgb.mapper")
public class MqttRunner implements CommandLineRunner {

    @Autowired
    DataHandler handler;
    @Autowired
    Environment env;

    @Override
    public void run(String... args) throws Exception {
        MqClient mqClient = new MqClient(handler, env);
        mqClient.connect();
    }

}