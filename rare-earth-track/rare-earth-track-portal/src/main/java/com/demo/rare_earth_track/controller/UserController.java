package com.demo.rare_earth_track.controller;

import com.demo.rare_earth_track.bean.User;
import com.demo.rare_earth_track.config.JwtSecurityProperties;
import com.demo.rare_earth_track.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hhoa
 **/
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService, JwtSecurityProperties properties) {
        this.userService = userService;

    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/users")
    public String addUser(User user){
        userService.addUser(user);
        return "success";
    }
}
