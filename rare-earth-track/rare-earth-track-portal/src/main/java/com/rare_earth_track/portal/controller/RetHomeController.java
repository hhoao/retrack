package com.rare_earth_track.portal.controller;

import com.rare_earth_track.portal.service.RetPortalProductService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RetHomeController
 * @Description: 首页内容管理Controller
 * @Author 匡龙
 * @Date 2022/6/16 9:44
 * @Version V1.0
 */
@RestController
@Tags({@Tag(name = "首页内容管理", description = "RetHomeController")})
@RequiredArgsConstructor
@RequestMapping("/home")
public class RetHomeController {

    private final RetPortalProductService productService;

    @Operation(summary = "通过产品溯源码查询产品")
    @GetMapping("/{batchId}")
    public CommonResult<RetProduct> getProductByTrackCode(@PathVariable("batchId") String batchId) {
        RetProduct productByBatchId = productService.getProductByBatchId(batchId);
        return CommonResult.success(productByBatchId);
    }
}
