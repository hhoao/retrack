package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.RetFactoryParam;
import com.rare_earth_track.admin.bean.RetMemberParam;
import com.rare_earth_track.admin.service.RetFactoryService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetMember;
import com.rare_earth_track.mgb.model.RetProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "分页获取工厂")
    @GetMapping("/factories")
    public CommonResult<List<RetFactory>> list(@Parameter(description = "页码") @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @Parameter(description = "页面大小") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<RetFactory> list = factoryService.list(pageNum, pageSize);
        return CommonResult.success(list);
    }
    @Operation(summary = "添加工厂")
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
    @GetMapping("/factories/search")
    public CommonResult<List<RetFactory>> getFactory(RetFactory factory){
        List<RetFactory> factories = factoryService.getFactory(factory);
        return CommonResult.success(factories);
    }
    @Operation(summary = "获取工厂所有成员")
    @GetMapping("/factories/{factoryName}/members")
    public CommonResult<List<RetMember>> listMembers(@RequestParam(value = "from", defaultValue = "1") Integer from,
                                                     @RequestParam(value = "size", defaultValue = "5") Integer size,
                                                     @PathVariable(value="factoryName") String factoryName){
        List<RetMember> members = factoryService.listFactoryMembers(from, size, factoryName);
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
    public CommonResult<List<RetProduct>> listProducts(@PathVariable(value = "factoryName") String factoryName){
        List<RetProduct> products = factoryService.listProducts(factoryName);
        return CommonResult.success(products);
    }
}
