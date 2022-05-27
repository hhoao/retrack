package com.rare_earth_track.admin.controller;


import com.rare_earth_track.admin.bean.RetUserParam;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.model.RetUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.*;

/**
 * 用户controller
 * @author hhoa
 **/
@RestController
@Tags({@Tag(name="用户管理", description = "RetUserController")})
public class RetUserController {
    private final RetUserService retUserService;

    public RetUserController(RetUserService retUserService) {
        this.retUserService = retUserService;
    }

    @Operation(summary = "分页获取用户列表")
    @GetMapping("/users")
    public CommonResult<CommonPage<RetUser>> list(@Parameter(description = "页码") @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                  @Parameter(description = "页面大小") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        return CommonResult.success(CommonPage.restPage(retUserService.list(pageNum, pageSize)));
    }

    @Operation(summary = "通过用户名获取用户")
    @GetMapping("/users/{username}")
    public CommonResult<RetUser> getUser(@PathVariable("username") String username){
        RetUser userByName = retUserService.getUserByName(username);
        if (userByName == null){
            Asserts.fail("没有该用户");
        }
        return CommonResult.success(userByName);
    }

    @Operation(summary = "更新用户角色")
    @PatchMapping("/user")
    public CommonResult<RetUser> updateUserRole(@RequestBody RetUserParam userParam){
        return CommonResult.success(retUserService.updateUser(userParam));
    }
}
