package com.demo.rare_earth_track.portal.controller;

import com.demo.rare_earth_track.portal.bean.RetUser;
import com.demo.rare_earth_track.security.config.JwtSecurityProperties;
import com.demo.rare_earth_track.portal.service.RetUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hhoa
 **/
@RestController
public class RetUserController {
    private final RetUserService retUserService;

    public RetUserController(RetUserService retUserService, JwtSecurityProperties properties) {
        this.retUserService = retUserService;
    }

    @GetMapping("/users")
    public List<RetUser> getAllUsers(){
        return retUserService.getAllUsers();
    }
    @PostMapping("/users")
    public String addUser(RetUser retUser){
        retUserService.addUser(retUser);
        return "success";
    }
}
