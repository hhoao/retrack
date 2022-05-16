package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.RetResourceParam;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    public final RetResourceService resourceService;

    @Operation(description = "分页获取资源列表", summary = "分页获取资源列表")
    @GetMapping("/resources")
    public CommonResult<CommonPage<RetResource>> list(@Parameter(description = "页面起始") @RequestParam(value = "from", defaultValue = "1") Integer from,
                                                @Parameter(description = "页面大小") @RequestParam(value = "size", defaultValue = "5") Integer size){
        List<RetResource> allResources = resourceService.list(from, size);
        return CommonResult.success(CommonPage.restPage(allResources));
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
