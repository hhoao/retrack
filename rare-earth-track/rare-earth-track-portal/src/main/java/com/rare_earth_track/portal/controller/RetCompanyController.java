package com.rare_earth_track.portal.controller;

import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetFactoryApplication;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.portal.bean.PageInfo;
import com.rare_earth_track.portal.service.RetFactoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName RetCompanyController
 * @Description: 公司Controller
 * @Author 匡龙
 * @Date 2022/6/17 19:18
 * @Version V1.0
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "公司管理")
public class RetCompanyController {
    private final RetFactoryService factoryService;

    @Operation(summary = "分页获取工厂")
    @GetMapping("/factories")
    public CommonResult<List<RetFactory>> list(RetFactory factoryParam, PageInfo pageInfo){
        List<RetFactory> list = factoryService.list(pageInfo, factoryParam);
        return CommonResult.success(list);
    }

    @Operation(summary = "通过工厂名称查询工厂信息")
    @GetMapping("/factories/{factoryName}")
    public CommonResult<RetFactory> getFactoryByFactoryName(@PathVariable("factoryName") String factoryName) {
        RetFactory factory = factoryService.getFactoryByFactoryName(factoryName);
        return CommonResult.success(factory);
    }

    @Operation(summary = "申请厂家入驻")
    @PostMapping("/factories")
    public CommonResult<String> applySettledFactory(@RequestBody RetFactoryApplication factoryApplicationParam) {
        factoryService.applySettledFactory(factoryApplicationParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "分页获取某工厂的产品")
    @GetMapping("/factories/{factoryName}/products")
    public CommonResult<List<RetProduct>> listProductByFactory(@PathVariable("factoryName") String factoryName, PageInfo pageInfo, RetProduct productParam) {
        List<RetProduct> products = factoryService.listProducts(factoryName, productParam, pageInfo);
        return CommonResult.success(products);
    }
}
