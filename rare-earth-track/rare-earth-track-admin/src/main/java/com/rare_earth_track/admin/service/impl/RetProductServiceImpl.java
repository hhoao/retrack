package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetProductParam;
import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetProductMapper;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.mgb.model.RetProductExample;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    @Override
    public List<RetProduct> list(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetProductExample productExample = new RetProductExample();
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
        BeanUtils.copyProperties(productParam, newProduct);
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
        if (product.getDispatchTime() != null){
            criteria.andDispatchTimeEqualTo(product.getDispatchTime());
        }
        if (product.getSpecification() != null){
            criteria.andSpecificationEqualTo(product.getSpecification());
        }
        if (product.getPackingType() != null){
            criteria.andPackingTypeEqualTo(product.getPackingType());
        }
        if (product.getPurity() != null){
            criteria.andPurityEqualTo(product.getPurity());
        }
        if (product.getProductionEquipment() != null){
            criteria.andProductionEquipmentEqualTo(product.getProductionEquipment());
        }
        if (product.getMaterialRatio() != null){
            criteria.andMaterialRatioEqualTo(product.getMaterialRatio());
        }
        if (product.getExtractionUnit() != null){
            criteria.andExtractionUnitEqualTo(product.getExtractionUnit());
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
