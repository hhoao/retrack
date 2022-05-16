package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.RetResourceParam;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/16
 **/
@RestController
@AllArgsConstructor
@Tag(description = "RetResourceController", name = "资源管理")
public class RetResourceController {
    public final RetResourceService resourceService;

    @Operation(description = "获取所有资源", summary = "获取所有资源")
    @GetMapping("/resources")
    public CommonResult<List<RetResource>> list(){
        List<RetResource> allResources = resourceService.getAllResources();
        return CommonResult.success(allResources);
    }
    @Operation(description = "添加资源", summary = "添加资源")
    @PostMapping("/resource")
    public CommonResult<String> addResource(@RequestBody RetResourceParam resourceParam){
        int count = resourceService.addResource(resourceParam);
        if (count == 0){
            return CommonResult.failed("插入失败");
        }
        return CommonResult.success(null);
    }
}
