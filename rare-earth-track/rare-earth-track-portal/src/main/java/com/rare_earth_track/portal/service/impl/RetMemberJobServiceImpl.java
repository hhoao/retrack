package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMemberJobMapper;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.portal.service.RetMemberJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/7/14
 **/

@Service
@RequiredArgsConstructor
public class RetMemberJobServiceImpl implements RetMemberJobService {
    private final RetMemberJobMapper jobMapper;
    @Override
    public RetMemberJob getJob(Long jobId) {
        RetMemberJob memberJob = jobMapper.selectByPrimaryKey(jobId);
        if (memberJob == null){
            Asserts.fail("没有该成员");
        }
        return memberJob;
    }
}
