package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.mgb.model.RetGbReference;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.portal.TransactionTest;
import com.rare_earth_track.portal.bean.PageInfo;
import com.rare_earth_track.portal.service.RetProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName RetProductServiceImplTest
 * @Description: 产品单元测试类
 * @Author 匡龙
 * @Date 2022/7/6 8:59
 * @Version V1.0
 */
public class RetProductServiceImplTest extends TransactionTest {

    @Autowired
    RetProductService productService;

    @Test
    void list() {
        List<RetProduct> list = productService.list(new RetProduct(), new PageInfo(1, 5));
        Assertions.assertTrue(list.size() <= 5);
    }

    @Test
    void getProductByBatchId() {
        RetProduct productByBatchId = productService.getProductByBatchId("012022063001");
        Assertions.assertNotNull(productByBatchId);
    }

    @Test
    void getProducts() {
        List<RetProduct> products = productService.getProducts(new RetProduct(), new PageInfo(1, 5));
        Assertions.assertTrue(products.size() <= 5);
    }
}
