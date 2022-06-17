package com.rare_earth_track.portal.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.portal.service.RetProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RetTrackController
 * @Description: 首页内容管理Controller
 * @Author 匡龙
 * @Date 2022/6/16 9:44
 * @Version V1.0
 */
@RestController
@Tags({@Tag(name = "产品溯源管理", description = "RetTrackController")})
@RequiredArgsConstructor
@RequestMapping("/products")
public class RetTrackController {

    private final RetProductService productService;

    @Operation(summary = "分页获取所有产品")
    @GetMapping()
    public CommonResult<List<RetProduct>> list(PageInfo pageInfo){
        List<RetProduct> products = productService.list(pageInfo);
        return CommonResult.success(products);
    }

    @Operation(summary = "通过产品溯源码查询产品")
    @GetMapping("/{batchId}")
    public CommonResult<RetProduct> getProductByTrackCode(@PathVariable("batchId") String batchId) {
        RetProduct productByBatchId = productService.getProductByBatchId(batchId);
        return CommonResult.success(productByBatchId);
    }

    @Operation(summary = "通过产品名称查询产品")
    @GetMapping("/{productName}")
    public CommonResult<RetProduct> getProductByProductName(@PathVariable("productName") String productName) {
        RetProduct product = productService.getProductByProductName(productName);
        return CommonResult.success(product);
    }
}
