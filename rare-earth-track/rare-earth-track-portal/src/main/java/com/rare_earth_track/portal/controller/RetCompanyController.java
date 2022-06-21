package com.rare_earth_track.portal.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFactoryParam;
import com.rare_earth_track.portal.service.RetProductService;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.portal.service.RetFactoryService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetFactory;
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
    private final RetProductService productService;

    @Operation(summary = "分页获取工厂")
    @GetMapping("/factories")
    public CommonResult<List<RetFactory>> list(PageInfo pageInfo){
        List<RetFactory> list = factoryService.list(pageInfo);
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
    public CommonResult<String> applySettledFactory(@RequestBody RetFactoryParam factoryParam) {
        factoryService.applySettledFactory(factoryParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "分页获取某工厂的产品")
    @GetMapping("/factories/{factoryName}/products")
    public CommonResult<List<RetProduct>> listProductByFactory(@PathVariable("factoryName") String factoryName, PageInfo pageInfo) {
        List<RetProduct> products = productService.listProductByFactory(factoryName, pageInfo);
        return CommonResult.success(products);
    }

}
