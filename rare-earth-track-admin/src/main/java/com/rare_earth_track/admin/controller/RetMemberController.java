package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetMemberService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetMember;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/24
 **/
@RequiredArgsConstructor
@RestController
@Tag(name = "RetMemberController", description = "成员管理")
public class RetMemberController {
    private final RetMemberService memberService;

    @Operation(summary = "分页获取成员")
    @GetMapping("/members")
    public CommonResult<CommonPage<RetMember>> list(PageInfo pageInfo,
                                                    RetMember member){
        List<RetMember> list = memberService.list(pageInfo, member);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @Operation(summary = "添加成员")
    @PostMapping("/members")
    public CommonResult<String> addMember(@RequestBody RetMember member){
        memberService.addMember(member);
        return CommonResult.success(null);
    }
    @Operation(summary = "删除成员")
    @DeleteMapping("/members/{memberId}")
    public CommonResult<String> addMember(@PathVariable("memberId") Long memberId){
        memberService.deleteMember(memberId);
        return CommonResult.success(null);
    }
}
