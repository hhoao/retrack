package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetMemberJobService;
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
@Tag(name = "职位管理", description = "RetMemberJobController")
public class RetMemberJobController {
    private final RetMemberJobService memberJobService;

    @Operation(summary = "分页获取职位")
    @GetMapping("/jobs")
    public CommonResult<List<RetMemberJob>> list(PageInfo pageInfo, RetMemberJob memberJob){
        List<RetMemberJob> list = memberJobService.list(pageInfo, memberJob);
        return CommonResult.success(list);
    }

    @Operation(summary = "分页获取职位资源")
    @GetMapping("/jobs/{jobId}/resources")
    public CommonResult<List<RetPermission>> listJobPermissions(PageInfo pageInfo,
                                                                @PathVariable("jobId") Long jobId){
        List<RetPermission> resources = memberJobService.listJobPermissions(pageInfo, jobId);
        return CommonResult.success(resources);
    }

    @Operation(summary = "增加职位权限")
    @PostMapping("/jobs/{jobName}/permissions/{permissionName}")
    public CommonResult<String> addJobResource(@PathVariable("jobName") String jobName,
                                               @PathVariable("permissionName") String resourceName){
        memberJobService.addJobPermission(jobName, resourceName);
        return CommonResult.success(null);
    }

    @Operation(summary = "删除job资源")
    @DeleteMapping("/jobs/{jobName}/permissions/{permissionName}")
    public CommonResult<String> deleteJobResource(@PathVariable("jobName") String jobName,
                                                  @PathVariable("permissionName") String resourceName){
        memberJobService.deleteJobPermission(jobName, resourceName);
        return CommonResult.success(null);
    }
}