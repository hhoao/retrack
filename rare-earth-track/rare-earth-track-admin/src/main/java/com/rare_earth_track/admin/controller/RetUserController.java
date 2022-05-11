package com.rare_earth_track.admin.controller;


import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.security.config.JwtSecurityProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

;

/**
 * @author hhoa
 **/
@RestController
@Tags({@Tag(name="RetUserController", description = "用户管理")})
public class RetUserController {
    private final RetUserService retUserService;

    public RetUserController(RetUserService retUserService, JwtSecurityProperties properties) {
        this.retUserService = retUserService;
    }

    @Operation(description = "获取索引用户", summary = "获取所有用户")
    @GetMapping("/users")
    public List<RetUser> getAllUsers(){
        return retUserService.getAllUsers();
    }
    @Operation(description = "增加用户", summary = "增加用户")
    @PostMapping("/users")
    public String addUser(RetUser retUser){
        retUserService.addUser(retUser);
        return "success";
    }
}
