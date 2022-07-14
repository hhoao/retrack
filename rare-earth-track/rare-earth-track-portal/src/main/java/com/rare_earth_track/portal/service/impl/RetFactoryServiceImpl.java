package com.rare_earth_track.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetFactoryMapper;
import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetFactoryApplication;
import com.rare_earth_track.mgb.model.RetFactoryExample;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.portal.bean.PageInfo;
import com.rare_earth_track.portal.service.RetFactoryApplicationService;
import com.rare_earth_track.portal.service.RetFactoryService;
import com.rare_earth_track.portal.service.RetProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/7/14
 **/

@RequiredArgsConstructor
@Service
public class RetFactoryServiceImpl implements RetFactoryService {
    private final RetFactoryMapper factoryMapper;
    private final RetProductService productService;
    private final RetFactoryApplicationService factoryApplicationService;

    @Override
    public List<RetFactory> list(PageInfo pageInfo, RetFactory factoryParam) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return getFactories(factoryParam);
    }
    @Override
    public List<RetFactory> getFactories(RetFactory factoryParam) {
        RetFactoryExample factoryExample = getFactoryExample(factoryParam);
        return factoryMapper.selectByExample(factoryExample);
    }
    private RetFactoryExample getFactoryExample(RetFactory factoryParam){
        RetFactoryExample factoryExample = new RetFactoryExample();
        RetFactoryExample.Criteria criteria = factoryExample.createCriteria();
        if (factoryParam.getId() != null){
            criteria.andIdEqualTo(factoryParam.getId());
            return factoryExample;
        }
        if (factoryParam.getEmail() != null){
            criteria.andEmailEqualTo(factoryParam.getEmail());
            return factoryExample;
        }
        if (factoryParam.getAddress() != null){
            criteria.andAddressLike(factoryParam.getAddress());
        }
        if (factoryParam.getName() != null){
            criteria.andNameLike(factoryParam.getName());
            return factoryExample;
        }
        if (factoryParam.getPhone() != null){
            criteria.andPhoneEqualTo(factoryParam.getPhone());
            return factoryExample;
        }
        if (factoryParam.getDescription() != null){
            criteria.andDescriptionLike(factoryParam.getDescription());
        }
        return factoryExample;
    }
    @Override
    public RetFactory getFactoryByFactoryId(Long id) {
        RetFactory retFactory = factoryMapper.selectByPrimaryKey(id);
        if (retFactory == null) {
            Asserts.fail("没有该工厂");
        }
        return retFactory;
    }

    @Override
    public List<RetProduct> listProducts(String factoryName, RetProduct product, PageInfo pageInfo) {
        RetFactory factory = getFactoryByFactoryName(factoryName);
        product.setFactoryId(factory.getId());
        return productService.getProducts(product, pageInfo);
    }

    @Override
    public RetFactory getFactoryByFactoryName(String name) {
        RetFactoryExample factoryExample = new RetFactoryExample();
        factoryExample.createCriteria().andNameEqualTo(name);
        List<RetFactory> retFactories = factoryMapper.selectByExample(factoryExample);
        if (retFactories != null && retFactories.size() > 0) {
            return retFactories.get(0);
        }
        if (retFactories.size() == 0) {
            Asserts.fail("没有该工厂");
        }
        return null;

    }

    @Override
    public void applySettledFactory(RetFactoryApplication factoryApplication) {
        factoryApplicationService.addApplication(factoryApplication);
    }
}