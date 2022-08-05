package com.rare_earth_track.search.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.PageRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hhoa
 * @date 2022/8/4
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EsMaterialControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void search() {
        String forObject = testRestTemplate.getForObject("/materials", String.class, Map.of("queryInfo", "金属"));
        System.out.println(forObject);
    }
}