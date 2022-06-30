package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetResourceParam;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源管理
 * @author hhoa
 * @date 2022/5/16
 **/
@RestController
@AllArgsConstructor
@Tag(description = "RetResourceController", name = "资源管理")
public class RetResourceController {
    private final RetResourceService resourceService;

    @Operation(description = "分页获取资源列表", summary = "分页获取资源列表")
    @GetMapping("/resources")
    public CommonResult<CommonPage<RetResource>> list(PageInfo pageInfo,
                                                      RetResource resource){
        List<RetResource> allResources = resourceService.list(pageInfo, resource);
        return CommonResult.success(CommonPage.restPage(allResources));
    }
    @Operation(description = "添加资源", summary = "添加资源")
    @PostMapping("/resources")
    public CommonResult<String> addResource(@RequestBody RetResourceParam resourceParam){
        resourceService.addResource(resourceParam);
        return CommonResult.success(null);
    }
    @Operation(summary = "修改资源")
    @PatchMapping("/resources/{resourceName}")
    public CommonResult<String> updateResource(@PathVariable("resourceName") String resourceName,
                                               @RequestBody RetResourceParam resourceParam){
        resourceService.updateResource(resourceName, resourceParam);
        return CommonResult.success(null);
    }
    @Operation(summary = "删除资源")
    @DeleteMapping("/resources/{resourceName}")
    public CommonResult<String> delResource(@PathVariable("resourceName") String resourceName){
        resourceService.deleteResource(resourceName);
        return CommonResult.success(null);
    }
}
