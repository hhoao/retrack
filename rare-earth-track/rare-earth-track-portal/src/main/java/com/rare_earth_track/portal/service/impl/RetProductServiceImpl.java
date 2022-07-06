package com.rare_earth_track.portal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetProductParam;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetGbReferenceMapper;
import com.rare_earth_track.mgb.mapper.RetProductMapper;
import com.rare_earth_track.mgb.model.*;
import com.rare_earth_track.portal.service.RetFactoryService;
import com.rare_earth_track.portal.service.RetProductService;
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
    public List<RetProduct> list(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetProductExample productExample = new RetProductExample();
        return productMapper.selectByExample(productExample);
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
        RetProduct productByProductName = getProductByProductName(name);
        int i = productMapper.deleteByPrimaryKey(productByProductName.getId());
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
        if (product.getPic() != null) {
            criteria.andPicEqualTo(product.getPic());
        }
        if (product.getQualityCertificate() != null) {
            criteria.andQualityCertificateEqualTo(product.getQualityCertificate());
        }
        if (product.getStandardNumber() != null) {
            criteria.andStandardNumberEqualTo(product.getStandardNumber());
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

    @Override
    public RetGbReference getGbReferenceByStandardNumber(String standardNumber) {
        RetGbReferenceExample gbReferenceExample = new RetGbReferenceExample();
        gbReferenceExample.createCriteria().andStandardNumberEqualTo(standardNumber);
        List<RetGbReference> gbReferences = gbReferenceMapper.selectByExample(gbReferenceExample);
        if (gbReferences != null && gbReferences.size() > 0) {
            return gbReferences.get(0);
        }
        if (gbReferences.size() == 0) {
            Asserts.fail("没有该国标参考信息");
        }
        return null;
    }


    private RetGbReferenceExample getGbReferenceExample(RetGbReference gbReference) {
        RetGbReferenceExample gbReferenceExample = new RetGbReferenceExample();
        RetGbReferenceExample.Criteria criteria = gbReferenceExample.createCriteria();
        if (gbReference.getId() != null) {
            criteria.andIdEqualTo(gbReference.getId());
            return gbReferenceExample;
        }
        if (gbReference.getName() != null) {
            criteria.andNameEqualTo(gbReference.getName());
        }
        if (gbReference.getStandardNumber() != null) {
            criteria.andStandardNumberEqualTo(gbReference.getStandardNumber());
        }
        if (gbReference.getNd() != null) {
            criteria.andNdEqualTo(gbReference.getNd());
        }
        if (gbReference.getCo() != null) {
            criteria.andCoEqualTo(gbReference.getCo());
        }
        if (gbReference.getB() != null) {
            criteria.andBEqualTo(gbReference.getB());
        }
        if (gbReference.getDyTbPr() != null) {
            criteria.andDyTbPrEqualTo(gbReference.getDyTbPr());
        }
        if (gbReference.getOther() != null) {
            criteria.andOtherEqualTo(gbReference.getOther());
        }
        if (gbReference.getRe() != null) {
            criteria.andReEqualTo(gbReference.getRe());
        }
        if (gbReference.getNdRe() != null) {
            criteria.andNdReEqualTo(gbReference.getNdRe());
        }
        if (gbReference.getDyRe() != null) {
            criteria.andDyReEqualTo(gbReference.getDyRe());
        }
        if (gbReference.getReo() != null) {
            criteria.andReoEqualTo(gbReference.getReo());
        }
        if (gbReference.getNd2o3Reo() != null) {
            criteria.andNd2o3ReoEqualTo(gbReference.getNd2o3Reo());
        }
        if (gbReference.getNd2o3() != null) {
            criteria.andNd2o3EqualTo(gbReference.getNd2o3());
        }
        if (gbReference.getDy2o3Reo() != null) {
            criteria.andDy2o3ReoEqualTo(gbReference.getDy2o3Reo());
        }
        if (gbReference.getReImpurities() != null) {
            criteria.andReImpuritiesEqualTo(gbReference.getReImpurities());
        }
        if (gbReference.getNonReImpurities() != null) {
            criteria.andNonReImpuritiesEqualTo(gbReference.getNonReImpurities());
        }
        return gbReferenceExample;
    }


    @Override
    public List<RetGbReference> listGbReference(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetGbReferenceExample gbReferenceExample = new RetGbReferenceExample();
        return gbReferenceMapper.selectByExample(gbReferenceExample);
    }
}
