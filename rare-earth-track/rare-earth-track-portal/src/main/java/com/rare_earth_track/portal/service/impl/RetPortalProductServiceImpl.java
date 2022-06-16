package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetProductMapper;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.mgb.model.RetProductExample;
import com.rare_earth_track.portal.service.RetPortalProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RetProductServiceImpl
 * @Description: TODO
 * @Author 匡龙
 * @Date 2022/6/16 15:05
 * @Version V1.0
 */
@Service
@RequiredArgsConstructor
public class RetPortalProductServiceImpl implements RetPortalProductService {

    private final RetProductMapper productMapper;

    @Override
    public RetProduct getProductByBatchId(String batchId) {
        RetProductExample productExample = new RetProductExample();
        productExample.createCriteria().andBatchIdEqualTo(batchId);
        List<RetProduct> retProducts = productMapper.selectByExample(productExample);
        if (retProducts != null && retProducts.size() > 0) {
            return retProducts.get(0);
        }else if (retProducts.size() == 0){
            Asserts.fail("没有该产品");
        }
        return null;
    }
}
