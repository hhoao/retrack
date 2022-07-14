package com.rare_earth_track.portal.controller;

import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.mgb.model.RetGbReference;
import com.rare_earth_track.portal.bean.PageInfo;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.portal.service.RetGbReferenceService;
import com.rare_earth_track.portal.service.RetProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Ret track controller.
 *
 * @ClassName RetTrackController
 * @Description: 产品溯源管理Controller
 * @Author 匡龙
 * @Date 2022 /6/16 9:44
 * @Version V1.0
 */
@RestController
@Tag(name = "产品溯源管理")
@RequiredArgsConstructor
public class RetTrackController {

    private final RetGbReferenceService gbReferenceService;
    private final RetProductService productService;

    /**
     * Gets product by track code.
     *
     * @param batchId the batch id
     * @return the product by track code
     */
    @Operation(summary = "通过产品溯源码查询产品")
    @GetMapping("/products/{batchId}")
    public CommonResult<RetProduct> getProductByTrackCode(@PathVariable("batchId") String batchId) {
        RetProduct productByBatchId = productService.getProductByBatchId(batchId);
        return CommonResult.success(productByBatchId);
    }

    /**
     * Gets product.
     *
     * @param product  the product
     * @param pageInfo the page info
     * @return the product
     */
    @Operation(summary = "根据条件查询产品信息")
    @GetMapping("/products")
    public CommonResult<CommonPage<RetProduct>> getProduct(RetProduct product, PageInfo pageInfo) {
        List<RetProduct> products = productService.list(product, pageInfo);
        return CommonResult.success(CommonPage.restPage(products));
    }

    /**
     * List common result.
     *
     * @param pageInfo the page info
     * @return the common result
     */
    @Operation(summary = "分页获取国标参考信息")
    @GetMapping("/gbReference")
    public CommonResult<CommonPage<RetGbReference>> list(PageInfo pageInfo, RetGbReference gbReference) {
        List<RetGbReference> gbReferences = gbReferenceService.listGbReference(pageInfo, gbReference);
        return CommonResult.success(CommonPage.restPage(gbReferences));
    }

    /**
     * Gets gb reference.
     *
     * @param standardNumber the standard number
     * @return the gb reference
     */
    @Operation(summary = "根据牌号查询国标参考信息")
    @GetMapping("/gbReferences/{standardNumber}")
    public CommonResult<RetGbReference> getGbReference(@PathVariable("standardNumber") String standardNumber) {
        RetGbReference gbReferenceByStandardNumber = gbReferenceService.getGbReferenceByStandardNumber(standardNumber);
        return CommonResult.success(gbReferenceByStandardNumber);
    }
}
