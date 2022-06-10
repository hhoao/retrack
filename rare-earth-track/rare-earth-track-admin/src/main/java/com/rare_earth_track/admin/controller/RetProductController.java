package com.rare_earth_track.admin.controller;


import com.rare_earth_track.admin.bean.RetProductParam;
import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hhoa
 */
@RestController
@RequiredArgsConstructor
@Tags({@Tag(name="产品管理", description = "RetProductController")})
public class RetProductController {
    private final RetProductService productService;

    @Operation(summary = "分页获取所有产品")
    @GetMapping("/products")
    public CommonResult<List<RetProduct>> list(@Parameter(description = "页码") @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @Parameter(description = "页面大小") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<RetProduct> products = productService.list(pageNum, pageSize);
        return CommonResult.success(products);
    }

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

}
