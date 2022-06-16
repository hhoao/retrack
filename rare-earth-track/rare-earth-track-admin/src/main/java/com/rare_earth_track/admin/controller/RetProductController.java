package com.rare_earth_track.admin.controller;


import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetProduct;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hhoa
 */
@RestController
@RequiredArgsConstructor
public class RetProductController {
    private final RetProductService productService;

    @Operation(summary = "分页获取产品")
    @GetMapping("/products")
    public CommonResult<List<RetProduct>> list(PageInfo pageInfo){
        List<RetProduct> products = productService.list(pageInfo);
        return CommonResult.success(products);
    }
}
