package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetProductMapper;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.mgb.model.RetProductExample;
import lombok.RequiredArgsConstructor;
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
    public List<RetProduct> getProducts(RetProduct product) {
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
