package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFactoryParam;
import com.rare_earth_track.admin.bean.RetMemberParam;
import com.rare_earth_track.admin.service.RetFactoryService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetMember;
import com.rare_earth_track.mgb.model.RetProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hhoa
 */

@RestController
@RequiredArgsConstructor
@Tag(name = "工厂管理", description = "RetFactoryController")
public class RetFactoryController {
    private final RetFactoryService factoryService;

    @Operation(summary = "创建工厂")
    @PostMapping("/factories")
    public CommonResult<String> addFactory(@RequestBody RetFactoryParam factoryParam){
        factoryService.addFactory(factoryParam);
        return CommonResult.success(null);
    }
    @Operation(summary = "删除工厂")
    @DeleteMapping("/factories/{factoryName}")
    public CommonResult<String> deleteFactory(@PathVariable(value= "factoryName") String factoryName){
        factoryService.deleteFactoryByName(factoryName);
        return CommonResult.success(null);
    }
    @Operation(summary = "更新工厂")
    @PatchMapping("/factories/{factoryName}")
    public CommonResult<String> updateFactory(@PathVariable("factoryName") String factoryName,
                                              @RequestBody RetFactoryParam factoryParam){
        factoryService.updateFactory(factoryName, factoryParam);
        return CommonResult.success(null);
    }
    @Operation(summary = "邀请用户成员")
    @PostMapping("/factories/{factoryName}/member")
    public CommonResult<String> inviteUser(@RequestParam(value = "type", defaultValue = "email") String type,
                                          @RequestParam("emailOrPhone") String emailOrPhone,
                                          @PathVariable("factoryName") String factoryName){
        if ("email".equals(type)){
            factoryService.inviteUserByEmail(factoryName, emailOrPhone);
        } else{
            factoryService.inviteUserByPhone(factoryName, emailOrPhone);
        }
        return CommonResult.success(null);
    }

    @Operation(summary = "根据条件查询工厂信息")
    @GetMapping("/factories")
    public CommonResult<List<RetFactory>> getFactory(PageInfo pageInfo, RetFactory factory){
        List<RetFactory> factories = factoryService.getFactory(pageInfo, factory);
        return CommonResult.success(factories);
    }
    @Operation(summary = "获取工厂所有成员")
    @GetMapping("/factories/{factoryName}/members")
    public CommonResult<List<RetMember>> listMembers(PageInfo pageInfo,
                                                     @PathVariable(value="factoryName") String factoryName){
        List<RetMember> members = factoryService.listFactoryMembers(pageInfo, factoryName);
        return CommonResult.success(members);
    }

    @Operation(summary = "通过用户名删除工厂成员")
    @DeleteMapping("/factories/{factoryName}/members/{username}")
    public CommonResult<String> deleteMember(@PathVariable("factoryName") String factoryName,
                                             @PathVariable("username") String username){
        factoryService.deleteFactoryMemberByUsername(factoryName, username);
        return CommonResult.success(null);
    }
    @Operation(summary = "更新工厂成员")
    @PatchMapping("/factories/{factoryName}/members/{username}")
    public CommonResult<String> updateMemberJob(@PathVariable("factoryName") String factoryName,
                                                @PathVariable(value = "username") String username,
                                                @RequestBody RetMemberParam memberParam){
        factoryService.updateFactoryMember(factoryName, username, memberParam);
        return CommonResult.success(null);
    }
    @Operation(summary = "处理邀请")
    @GetMapping("/factories/{factoryName}/invitations")
    public CommonResult<String> handleInvitation(@PathVariable(value= "factoryName") String factoryName,
                                                 @CookieValue(value="Authorization") String authorization){
        factoryService.handleInvitation(factoryName, authorization);
        return CommonResult.success(null);
    }

    @Operation(summary = "分页获取工厂产品")
    @GetMapping("/factories/{factoryName}/products")
    public CommonResult<List<RetProduct>> listProducts(@PathVariable(value = "factoryName") String factoryName,
                                                       PageInfo pageInfo,
                                                       RetProduct product){
        List<RetProduct> products = factoryService.listProducts(factoryName, product, pageInfo);
        return CommonResult.success(products);
    }

    @Operation(summary = "通过工厂名称查询工厂信息")
    @GetMapping("/factories/{factoryName}")
    public CommonResult<RetFactory> getFactoryByFactoryName(@PathVariable("factoryName") String factoryName) {
        RetFactory factory = factoryService.getFactoryByFactoryName(factoryName);
        return CommonResult.success(factory);
    }


}
