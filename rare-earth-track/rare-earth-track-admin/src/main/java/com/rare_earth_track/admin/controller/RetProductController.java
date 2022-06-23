package com.rare_earth_track.admin.controller;


import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetProductParam;
import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hhoa
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "产品管理")
public class RetProductController {
    private final RetProductService productService;


    @Operation(summary = "增加产品")
    @PostMapping("/products")
    public CommonResult<String> addProduct(@RequestBody RetProductParam productParam) {
        productService.addProduct(productParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "删除产品")
    @DeleteMapping("/products/{productName}")
    public CommonResult<String> deleteProduct(@PathVariable(value = "productName") String productName) {
        productService.deleteProductByName(productName);
        return CommonResult.success(null);
    }

    @Operation(summary = "更新产品")
    @PatchMapping("/products/{productName}")
    public CommonResult<String> updateProduct(@PathVariable("productName") String productName,
                                              @RequestBody RetProductParam productParam) {
        productService.updateProduct(productName, productParam);
        return CommonResult.success(null);
    }


    @Operation(summary = "通过产品名称查询产品")
    @GetMapping("/products/{productName}")
    public CommonResult<RetProduct> getProductByProductName(@PathVariable("productName") String productName) {
        RetProduct product = productService.getProductByProductName(productName);
        return CommonResult.success(product);
    }

    @Operation(summary = "根据条件查询产品信息")
    @GetMapping("/products")
    public CommonResult<List<RetProduct>> getProduct(PageInfo pageInfo, RetProduct product) {
        List<RetProduct> products = productService.getProducts(product, pageInfo);
        return CommonResult.success(products);
    }

}
