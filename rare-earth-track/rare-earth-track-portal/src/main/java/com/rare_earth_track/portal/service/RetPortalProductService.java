package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetProduct;

/**
 * @ClassName RetPortalProductService
 * @Description: 前台productService接口
 * @Author 匡龙
 * @Date 2022/6/17 10:25
 * @Version V1.0
 */
public interface RetPortalProductService {

    /**
     * 通过产品批次溯源产品
     * @param batchId
     * @return
     */
    RetProduct getProductByBatchId(String batchId);

}
