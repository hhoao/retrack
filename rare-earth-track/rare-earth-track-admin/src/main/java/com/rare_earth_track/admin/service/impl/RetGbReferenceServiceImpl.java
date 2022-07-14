package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetGbReferenceService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetGbReferenceMapper;
import com.rare_earth_track.mgb.model.RetGbReference;
import com.rare_earth_track.mgb.model.RetGbReferenceExample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/7/14
 **/

@RequiredArgsConstructor
@Service
public class RetGbReferenceServiceImpl implements RetGbReferenceService {
    private final RetGbReferenceMapper gbReferenceMapper;

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
    @Override
    public List<RetGbReference> listGbReference(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetGbReferenceExample gbReferenceExample = new RetGbReferenceExample();
        return gbReferenceMapper.selectByExample(gbReferenceExample);
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

}
