package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.service.RetFactoryService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetMember;
import com.rare_earth_track.security.config.JwtSecurityProperties;
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
    private final JwtSecurityProperties securityProperties;

    @Operation(summary = "分页获取工厂")
    @GetMapping("/factories")
    public CommonResult<List<RetFactory>> list(@Parameter(description = "页码") @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @Parameter(description = "页面大小") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<RetFactory> list = factoryService.list(pageNum, pageSize);
        return CommonResult.success(list);
    }
    @Operation(summary = "添加工厂")
    @PostMapping("/factory")
    public CommonResult<String> addFactory(@RequestBody RetFactory factory){
        factoryService.addFactory(factory);
        return CommonResult.success(null);
    }
    @Operation(summary = "删除工厂")
    @DeleteMapping("/factory/{id}")
    public CommonResult<String> deleteFactory(@PathVariable(value="id") Long id){
        factoryService.deleteFactoryByFactoryId(id);
        return CommonResult.success(null);
    }
    @Operation(summary = "更新工厂")
    @PatchMapping("/factory")
    public CommonResult<String> updateFactory(@RequestBody RetFactory factory){
        factoryService.updateFactory(factory);
        return CommonResult.success(null);
    }
    @Operation(summary = "邀请用户成员")
    @PostMapping("/factories/{factoryId}/member")
    public CommonResult<String> inviteUser(@RequestParam(value = "type", defaultValue = "email") String type,
                                          @RequestParam("emailOrPhone") String emailOrPhone,
                                          @PathVariable("factoryId") Long factoryId){
        if ("email".equals(type)){
            factoryService.inviteUserByEmail(factoryId, emailOrPhone);
        } else{
            factoryService.inviteUserByPhone(factoryId, emailOrPhone);
        }
        return CommonResult.success(null);
    }
    @Operation(summary = "获取工厂所有成员")
    @GetMapping("/factories/{factoryId}/members")
    public CommonResult<List<RetMember>> listMembers(@RequestParam(value = "from", defaultValue = "1") Integer from,
                                                     @RequestParam(value = "size", defaultValue = "5") Integer size,
                                                     @PathVariable(value="factoryId") Long factoryId){
        List<RetMember> members = factoryService.listFactoryMembers(from, size, factoryId);
        return CommonResult.success(members);
    }
    @Operation(summary = "删除成员")
    @DeleteMapping("/factory/members/{memberId}")
    public CommonResult<String> deleteMember(@PathVariable(value="memberId") Long memberId){
        factoryService.deleteFactoryMemberByMemberId(memberId);
        return CommonResult.success(null);
    }
    @Operation(summary = "更新成员职位")
    @PatchMapping("/factory/members/{memberId}")
    public CommonResult<String> updateMemberJob(@PathVariable(value = "memberId") Long memberId,
                                                @RequestParam(value = "job") Long jobId){
        factoryService.updateFactoryMemberJob(memberId, jobId);
        return CommonResult.success(null);
    }
    @Operation(summary = "处理邀请")
    @GetMapping("/factories/{id}/invitations")
    public CommonResult<String> handleInvitation(@PathVariable(value="id") Long factoryId,
                                                 @CookieValue(value="Authorization") String bearer){
        String authToken = bearer.substring(securityProperties.getTokenHead().length());
        factoryService.handleInvitation(factoryId, authToken);
        return CommonResult.success(null);
    }
}
