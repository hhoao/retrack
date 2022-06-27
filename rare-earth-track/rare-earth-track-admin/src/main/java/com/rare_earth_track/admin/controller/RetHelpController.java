package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetHelpParam;
import com.rare_earth_track.admin.service.RetHelpService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetHelp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName RetHelpController
 * @Description: HelpController
 * @Author 匡龙
 * @Date 2022/6/24 14:47
 * @Version V1.0
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "帮助管理", description = "RetHelpController")
public class RetHelpController {
    private final RetHelpService helpService;

    @Operation(summary = "增加帮助信息")
    @PostMapping("/helps")
    public CommonResult<String> addHelp(@RequestBody RetHelpParam helpParam) {
        helpService.addHelp(helpParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "删除帮助信息")
    @DeleteMapping("/helps/{helpName}")
    public CommonResult<String> deleteHelp(@PathVariable(value = "helpName") String helpName) {
        helpService.deleteHelpByName(helpName);
        return CommonResult.success(null);
    }

    @Operation(summary = "更新产品")
    @PatchMapping("/helps/{helpName}")
    public CommonResult<String> updateHelp(@PathVariable("helpName") String helpName,
                                           @RequestBody RetHelpParam helpParam) {
        helpService.updateHelp(helpName, helpParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "根据条件查询帮助信息")
    @GetMapping("/helps")
    public CommonResult<CommonPage<RetHelp>> getHelp(PageInfo pageInfo, RetHelp help) {
        List<RetHelp> helps = helpService.getHelps(help, pageInfo);
        return CommonResult.success(CommonPage.restPage(helps));
    }

}
