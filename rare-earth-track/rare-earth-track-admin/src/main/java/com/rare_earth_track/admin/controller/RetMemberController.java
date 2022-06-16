package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetMemberService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetMember;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/24
 **/
@RequiredArgsConstructor
@Tag(name = "成员管理", description = "RetMemberController")
public class RetMemberController {
    private final RetMemberService factoryService;

    @Operation(summary = "分页获取成员")
    @GetMapping("/factories")
    public CommonResult<List<RetMember>> list(PageInfo pageInfo){
        List<RetMember> list = factoryService.list(pageInfo);
        return CommonResult.success(list);
    }
}
