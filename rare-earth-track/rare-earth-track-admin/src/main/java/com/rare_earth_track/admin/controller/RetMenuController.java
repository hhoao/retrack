package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.service.RetMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhoa
 * @date 2022/6/13
 **/

@RestController
@RequiredArgsConstructor
public class RetMenuController {
    private final RetMenuService menuService;
}
