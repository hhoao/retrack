package com.rare_earth_track.admin.controller;

/**
 * @author hhoa
 * @date 2022/7/14
 **/

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetGbReferenceService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetGbReference;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "RetGbReferenceController", description = "国标管理")
public class RetGbReferenceController {
    private  final RetGbReferenceService gbReferenceService;
    @Operation(summary = "分页获取国标参考信息")
    @GetMapping("/gbReference")
    public CommonResult<CommonPage<RetGbReference>> list(PageInfo pageInfo) {
        List<RetGbReference> gbReferences = gbReferenceService.listGbReference(pageInfo);
        return CommonResult.success(CommonPage.restPage(gbReferences));
    }

    @Operation(summary = "根据牌号查询国标参考信息")
    @GetMapping("/gbReference/{standardNumber}")
    public CommonResult<RetGbReference> getGbReference(@PathVariable("standardNumber") String standardNumber) {
        RetGbReference gbReferenceByStandardNumber = gbReferenceService.getGbReferenceByStandardNumber(standardNumber);
        return CommonResult.success(gbReferenceByStandardNumber);
    }
}
