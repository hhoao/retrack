package com.rare_earth_track.search.controller;

import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.search.bean.EsMaterial;
import com.rare_earth_track.search.bean.EsPage;
import com.rare_earth_track.search.service.EsMaterialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhoa
 * @date 2022/8/4
 **/
@Tags({@Tag(name = "材料管理", description = "RetMaterialController")})
@RestController
@RequiredArgsConstructor
public class EsMaterialController {
    private final EsMaterialService esMaterialService;
    @GetMapping("/materials")
    public CommonResult<CommonPage<EsMaterial>> search(String queryInfo, EsPage page){
        Page<EsMaterial> search = esMaterialService.search(queryInfo, page);
        return CommonResult.success(CommonPage.restPage(search));
    }
}
