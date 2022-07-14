package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetFactoryApplicationService;
import com.rare_earth_track.mgb.mapper.RetFactoryApplicationMapper;
import com.rare_earth_track.mgb.model.RetFactoryApplication;
import com.rare_earth_track.mgb.model.RetFactoryApplicationExample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/7/14
 **/

@RequiredArgsConstructor
@Service
public class RetFactoryApplicationServiceImpl implements RetFactoryApplicationService {
    private final RetFactoryApplicationMapper factoryApplicationMapper;
    @Override
    public List<RetFactoryApplication> listFactoryApplications(PageInfo pageInfo, RetFactoryApplication factoryApplication) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return getFactoryApplications(factoryApplication);
    }
    private RetFactoryApplicationExample getFactoryApplicationExample(RetFactoryApplication applyFactory) {
        RetFactoryApplicationExample applyFactoryExample = new RetFactoryApplicationExample();
        if (applyFactory != null) {
            RetFactoryApplicationExample.Criteria criteria = applyFactoryExample.createCriteria();
            if (applyFactory.getId() != null) {
                criteria.andIdEqualTo(applyFactory.getId());
            }

            if (StringUtils.hasLength(applyFactory.getAddress())) {
                criteria.andAddressEqualTo(applyFactory.getAddress());
            }
            if (StringUtils.hasLength(applyFactory.getName())) {
                criteria.andNameEqualTo(applyFactory.getName());
            }
            if (StringUtils.hasLength(applyFactory.getEmail())) {
                criteria.andEmailEqualTo(applyFactory.getEmail());
            }
            if (StringUtils.hasLength(applyFactory.getPhone())) {
                criteria.andPhoneEqualTo(applyFactory.getPhone());
            }
            if (StringUtils.hasLength(applyFactory.getDescription())) {
                criteria.andDescriptionLike(applyFactory.getDescription());
            }
        }
        return applyFactoryExample;
    }

    @Override
    public List<RetFactoryApplication> getFactoryApplications(RetFactoryApplication factoryApplication) {
        RetFactoryApplicationExample factoryApplicationExample = getFactoryApplicationExample(factoryApplication);
        return factoryApplicationMapper.selectByExample(factoryApplicationExample);
    }
}
