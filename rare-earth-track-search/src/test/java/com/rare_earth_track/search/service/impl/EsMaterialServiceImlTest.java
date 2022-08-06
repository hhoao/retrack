package com.rare_earth_track.search.service.impl;

import com.rare_earth_track.search.bean.EsMaterial;
import com.rare_earth_track.search.service.EsMaterialService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hhoa
 * @date 2022/8/4
 **/

@SpringBootTest
class EsMaterialServiceImlTest {
    @Autowired
    EsMaterialService materialServiceIml;

    @Disabled
    @Test
    void search() {
        Page<EsMaterial> ret = materialServiceIml.search("金属", PageRequest.of(0, 5));
        List<EsMaterial> content = ret.getContent();
        System.out.println(content);
    }
}