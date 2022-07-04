package com.rare_earth_track.portal.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.mgb.model.RetGbReference;
import com.rare_earth_track.portal.service.RetProductService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @ClassName RetTrackController
 * @Description: 产品溯源管理Controller
 * @Author 匡龙
 * @Date 2022/6/16 9:44
 * @Version V1.0
 */
@RestController
@Tag(name = "产品溯源管理")
@RequiredArgsConstructor
public class RetTrackController {

    private final RetProductService productService;

    @Operation(summary = "通过产品溯源码查询产品")
    @GetMapping("/products/{batchId}")
    public CommonResult<RetProduct> getProductByTrackCode(@PathVariable("batchId") String batchId) {
        RetProduct productByBatchId = productService.getProductByBatchId(batchId);
        return CommonResult.success(productByBatchId);
    }

    @Operation(summary = "根据条件查询产品信息")
    @GetMapping("/products")
    public CommonResult<List<RetProduct>> getProduct(RetProduct product, PageInfo pageInfo) {
        List<RetProduct> products = productService.getProducts(product, pageInfo);
        return CommonResult.success(products);
    }

    @Operation(summary = "分页获取国标参考信息")
    @GetMapping("/gbReference")
    public CommonResult<CommonPage<RetGbReference>> list(PageInfo pageInfo) {
        List<RetGbReference> gbReferences = productService.listGbReference(pageInfo);
        return CommonResult.success(CommonPage.restPage(gbReferences));
    }

    @Operation(summary = "根据牌号查询国标参考信息")
    @GetMapping("/gbReference/{standardNumber}")
    public CommonResult<RetGbReference> getGbReference(@PathVariable("standardNumber") String standardNumber) {
        RetGbReference gbReferenceByStandardNumber = productService.getGbReferenceByStandardNumber(standardNumber);
        return CommonResult.success(gbReferenceByStandardNumber);
    }
}
