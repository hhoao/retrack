package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.service.RetMemberService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetMember;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public CommonResult<List<RetMember>> list(@Parameter(description = "页码") @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                              @Parameter(description = "页面大小") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<RetMember> list = factoryService.list(pageNum, pageSize);
        return CommonResult.success(list);
    }
}
