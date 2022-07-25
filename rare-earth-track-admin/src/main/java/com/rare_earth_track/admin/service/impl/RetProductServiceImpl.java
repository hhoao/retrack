package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetProductParam;
import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetGbReferenceMapper;
import com.rare_earth_track.mgb.mapper.RetProductMapper;
import com.rare_earth_track.mgb.model.*;
import com.rare_earth_track.admin.service.RetFactoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/30
 **/

@Service
@RequiredArgsConstructor
public class RetProductServiceImpl implements RetProductService {
    private final RetProductMapper productMapper;
    private final RetGbReferenceMapper gbReferenceMapper;
    private RetFactoryService factoryService;

    @Autowired
    @Lazy
    public void setFactoryService(RetFactoryService factoryService) {
        this.factoryService = factoryService;
    }
    @Override
    public List<RetProduct> list(RetProduct productParam, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return getProducts(productParam, pageInfo);
    }

    @Override
    public List<RetProduct> listProductByFactory(String factoryName, PageInfo pageInfo) {
        RetProductExample productExample = new RetProductExample();
        RetFactory factoryByFactoryName = factoryService.getFactoryByFactoryName(factoryName);
        productExample.createCriteria().andFactoryIdEqualTo(factoryByFactoryName.getId());
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return productMapper.selectByExample(productExample);
    }

    @Override
    public void addProduct(RetProductParam productParam) {
        RetProduct product = new RetProduct();
        BeanUtil.copyProperties(productParam, product);
        int insert = productMapper.insert(product);
        if (insert == 0) {
            Asserts.fail("新增产品失败");
        }
    }

    @Override
    public void updateProduct(String productName, RetProductParam productParam) {
        RetProduct productByProductName = getProductByProductName(productName);
        RetProduct newProduct = new RetProduct();
        BeanUtil.copyProperties(productParam, newProduct);
        newProduct.setFactoryId(productByProductName.getFactoryId());
        newProduct.setId(productByProductName.getId());
        int i = productMapper.updateByPrimaryKeySelective(newProduct);
        if (i == 0) {
            Asserts.fail("更新产品失败");
        }
    }

    @Override
    public int deleteProductByName(String name) {
        RetProductExample productExample = new RetProductExample();
        productExample.createCriteria().andNameEqualTo(name);
        int i = productMapper.deleteByExample(productExample);
        if (i == 0){
            Asserts.fail("删除失败");
        }
        return i;
    }

    @Override
    public RetProduct getProductByProductName(String productName) {
        RetProductExample productExample = new RetProductExample();
        productExample.createCriteria().andNameEqualTo(productName);
        List<RetProduct> retProducts = productMapper.selectByExample(productExample);
        if (retProducts != null && retProducts.size() > 0) {
            return retProducts.get(0);
        }else if (retProducts.size() == 0){
            Asserts.fail("没有该产品");
        }
        return null;
    }

    @Override
    public RetProduct getProductByProductId(Long id) {
        RetProduct retProduct = productMapper.selectByPrimaryKey(id);
        if (retProduct == null) {
            Asserts.fail("没有该产品");
        }
        return retProduct;
    }

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

    private RetProductExample  getProductExample(RetProduct product){
        RetProductExample productExample = new RetProductExample();
        RetProductExample.Criteria criteria = productExample.createCriteria();
        if (product.getId() != null){
            criteria.andIdEqualTo(product.getId());
            return productExample;
        }
        if (product.getFactoryId() != null){
            criteria.andFactoryIdEqualTo(product.getFactoryId());
        }
        if (product.getName() != null){
            criteria.andNameEqualTo(product.getName());
        }
        if (product.getBatchId() != null){
            criteria.andBatchIdEqualTo(product.getBatchId());
        }
        if (product.getFactory() != null) {
            criteria.andFactoryEqualTo(product.getFactory());
        }
        if (product.getDispatchTime() != null) {
            criteria.andDispatchTimeEqualTo(product.getDispatchTime());
        }
        if (product.getSpecification() != null) {
            criteria.andSpecificationEqualTo(product.getSpecification());
        }
        if (product.getPackingType() != null) {
            criteria.andPackingTypeEqualTo(product.getPackingType());
        }
        if (product.getNetWeight() != null) {
            criteria.andNetWeightEqualTo(product.getNetWeight());
        }
        if (product.getTransportLog() != null) {
            criteria.andTransportLogEqualTo(product.getTransportLog());
        }
        if (product.getQualityCertificate() != null) {
            criteria.andQualityCertificateEqualTo(product.getQualityCertificate());
        }
        if (product.getStandardNumber() != null) {
            criteria.andStandardNumberEqualTo(product.getStandardNumber());
        }
        if (product.getProductionPhase() != null) {
            criteria.andProductionPhaseEqualTo(product.getProductionPhase());
        }
        if (product.getMiningTechnology() != null) {
            criteria.andMiningTechnologyEqualTo(product.getMiningTechnology());
        }
        if (product.getMine() != null) {
            criteria.andMineEqualTo(product.getMine());
        }
        if (product.getSeparate() != null) {
            criteria.andSeparateEqualTo(product.getSeparate());
        }
        if (product.getOxygenLevels() != null) {
            criteria.andOxygenLevelsEqualTo(product.getOxygenLevels());
        }
        if (product.getPressure() != null) {
            criteria.andPressureEqualTo(product.getPressure());
        }
        if (product.getMagneticField() != null) {
            criteria.andMagneticFieldEqualTo(product.getMagneticField());
        }
        if (product.getNd() != null) {
            criteria.andNdEqualTo(product.getNd());
        }
        if (product.getCo() != null) {
            criteria.andCoEqualTo(product.getCo());
        }
        if (product.getB() != null) {
            criteria.andBEqualTo(product.getB());
        }
        if (product.getDyTbPr() != null) {
            criteria.andDyTbPrEqualTo(product.getDyTbPr());
        }
        if (product.getOther() != null) {
            criteria.andOtherEqualTo(product.getOther());
        }
        if (product.getRe() != null) {
            criteria.andReEqualTo(product.getRe());
        }
        if (product.getNdRe() != null) {
            criteria.andNdReEqualTo(product.getNdRe());
        }
        if (product.getDyRe() != null) {
            criteria.andDyReEqualTo(product.getDyRe());
        }
        if (product.getReo() != null) {
            criteria.andReoEqualTo(product.getReo());
        }
        if (product.getNd2o3Reo() != null) {
            criteria.andNd2o3ReoEqualTo(product.getNd2o3Reo());
        }
        if (product.getNd2o3() != null) {
            criteria.andNd2o3EqualTo(product.getNd2o3());
        }
        if (product.getDy2o3Reo() != null) {
            criteria.andDy2o3ReoEqualTo(product.getDy2o3Reo());
        }
        if (product.getReImpurities() != null) {
            criteria.andReImpuritiesEqualTo(product.getReImpurities());
        }
        if (product.getNonReImpurities() != null) {
            criteria.andNonReImpuritiesEqualTo(product.getNonReImpurities());
        }
        return productExample;
    }



    @Override
    public List<RetProduct> getProducts(RetProduct product, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetProductExample productExample = getProductExample(product);
        return productMapper.selectByExample(productExample);
    }

    @Override
    public void deleteProducts(RetProduct product) {
        RetProductExample productExample = getProductExample(product);
        int i = productMapper.deleteByExample(productExample);
        if (i == 0){
            Asserts.fail("删除失败");
        }
    }


}
