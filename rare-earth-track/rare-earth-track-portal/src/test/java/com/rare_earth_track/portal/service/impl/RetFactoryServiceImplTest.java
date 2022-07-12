package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.common.exception.ApiException;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFactoryParam;
import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.portal.TransactionTest;
import com.rare_earth_track.portal.service.RetFactoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName RetFactoryServiceImplTest
 * @Description: 工厂单元测试类
 * @Author 匡龙
 * @Date 2022/7/4 8:39
 * @Version V1.0
 */
public class RetFactoryServiceImplTest extends TransactionTest {

    @Autowired
    RetFactoryService factoryService;

    private final String testName = "五矿稀土";

    @Test
    void list() {
        List<RetFactory> list = factoryService.list(new PageInfo(1, 5));
        Assertions.assertTrue(list.size() <= 5);
    }

    @Test
    void applySettledFactory() {
        RetFactoryParam factoryParam = new RetFactoryParam();
        Long aLong = factoryService.applySettledFactory(factoryParam);
        Assertions.assertNotNull(factoryService.getFactoryByFactoryId(aLong));
    }

    @Test
    void getFactoryByFactoryName() {
        RetFactory factoryByFactoryName = factoryService.getFactoryByFactoryName(testName);
        Assertions.assertNotNull(factoryByFactoryName);
    }

    @Test
    void updateFactory() {
        RetFactoryParam factoryParam = new RetFactoryParam();
        factoryParam.setPhone("1239581239");
        factoryService.updateFactory("五矿稀土", factoryParam);
    }

    @Test
    void deleteFactoryByName() {
        factoryService.deleteFactoryByName("五矿稀土");
        Assertions.assertThrows(ApiException.class, ()->factoryService.getFactoryByFactoryName("五矿稀土"));
    }

}
