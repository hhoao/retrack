package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetMemberJobService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetPermission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/25
 **/
@RequiredArgsConstructor
@RestController
@Tag(name = "职位管理", description = "RetMemberJobController")
public class RetMemberJobController {
    private final RetMemberJobService memberJobService;

    @Operation(summary = "分页获取职位")
    @GetMapping("/jobs")
    public CommonResult<CommonPage<RetMemberJob>> list(PageInfo pageInfo, RetMemberJob memberJob){
        List<RetMemberJob> list = memberJobService.list(pageInfo, memberJob);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @Operation(summary = "分页获取职位权限")
    @GetMapping("/jobs/{jobId}/permissions")
    public CommonResult<CommonPage<RetPermission>> listJobPermissions(PageInfo pageInfo,
                                                                @PathVariable("jobId") Long jobId){
        List<RetPermission> permissions = memberJobService.listJobPermissions(pageInfo, jobId);
        return CommonResult.success(CommonPage.restPage(permissions));
    }

    @Operation(summary = "增加职位权限")
    @PostMapping("/jobs/{jobName}/permissions/{permissionName}")
    public CommonResult<String> addJobPermission(@PathVariable("jobName") String jobName,
                                               @PathVariable("permissionName") String permissionName){
        memberJobService.addJobPermission(jobName, permissionName);
        return CommonResult.success(null);
    }

    @Operation(summary = "删除job资源")
    @DeleteMapping("/jobs/{jobName}/permissions/{permissionName}")
    public CommonResult<String> deleteJobPermission(@PathVariable("jobName") String jobName,
                                                  @PathVariable("permissionName") String permissionName){
        memberJobService.deleteJobPermission(jobName, permissionName);
        return CommonResult.success(null);
    }
}