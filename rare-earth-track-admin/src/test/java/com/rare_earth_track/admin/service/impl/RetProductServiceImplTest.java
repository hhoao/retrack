package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetProductParam;
import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName RetProductServiceImplTest
 * @Description: TODO
 * @Author 匡龙
 * @Date 2022/6/7 10:40
 * @Version V1.0
 */
public class RetProductServiceImplTest extends TransactionTest {
    @Autowired
    RetProductService productService;

    @Test
    void addProduct() {
        RetProductParam productParam = new RetProductParam();
        productParam.setName("test");
        productParam.setBatchId("A-123");
//        Assertions.assertNotNull(productService.getProductByProductId(along));
    }

    @Test
    void updateProduct() {
        RetProductParam productParam = new RetProductParam();
        productParam.setName("钨矿石");
        productService.updateProduct("烧结钕铁硼", productParam);
    }

    @Test
    void deleteProductByName() {
        productService.deleteProductByName("烧结钕铁硼");
        Assertions.assertThrows(ApiException.class, ()->productService.getProductByProductName("烧结钕铁硼"));
    }

    @Test
    void list() {
        PageInfo pageInfo = new PageInfo(1, 5);
        List<RetProduct> list = productService.list(new RetProduct(), pageInfo);
        System.out.println(list.size());
    }
}
