package com.rare_earth_track.admin.controller;


import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetProduct;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hhoa
 */
@RestController
@RequiredArgsConstructor
public class RetProductController {
    private final RetProductService productService;
    @GetMapping("/products")
    public CommonResult<List<RetProduct>> list(@Parameter(description = "页码") @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @Parameter(description = "页面大小") @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<RetProduct> products = productService.list(pageNum, pageSize);
        return CommonResult.success(products);
    }

}
