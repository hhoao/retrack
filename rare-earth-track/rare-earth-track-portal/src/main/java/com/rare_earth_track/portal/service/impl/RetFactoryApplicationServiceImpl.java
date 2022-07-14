package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetFactoryApplicationMapper;
import com.rare_earth_track.mgb.model.RetFactoryApplication;
import com.rare_earth_track.portal.service.RetFactoryApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/7/14
 **/

@RequiredArgsConstructor
@Service
public class RetFactoryApplicationServiceImpl implements RetFactoryApplicationService {
    private final RetFactoryApplicationMapper applicationMapper;

    @Override
    public void addApplication(RetFactoryApplication factoryApplication) {
        int i = applicationMapper.insertSelective(factoryApplication);
        if (i == 0){
            Asserts.fail("申请失败");
        }
    }
}
