package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMemberMapper;
import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetMember;
import com.rare_earth_track.mgb.model.RetMemberExample;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.portal.bean.RetFactoryJob;
import com.rare_earth_track.portal.service.RetFactoryService;
import com.rare_earth_track.portal.service.RetMemberJobService;
import com.rare_earth_track.portal.service.RetMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/7/14
 **/

@RequiredArgsConstructor
@Service
public class RetMemberServiceImpl implements RetMemberService {
    private final RetMemberMapper memberMapper;
    private final RetFactoryService factoryService;
    private final RetMemberJobService memberJobService;

    @Override
    public List<RetFactoryJob> getFactoryJobsByUserId(Long userId) {
        RetMemberExample memberExample = new RetMemberExample();
        memberExample.createCriteria().
                andUserIdEqualTo(userId);
        List<RetMember> members = memberMapper.selectByExample(memberExample);
        List<RetFactoryJob> factoryJobs = new ArrayList<>();
        for (RetMember member : members){
            RetFactory factoryByFactoryId = factoryService.getFactoryByFactoryId(member.getFactoryId());
            RetMemberJob job = memberJobService.getJob(member.getJobId());
            RetFactoryJob factoryJob = new RetFactoryJob(factoryByFactoryId.getName(), job.getName());
            factoryJobs.add(factoryJob);
        }
        return factoryJobs;
    }

    @Override
    public Long addMember(RetMember member) {
        int insert = memberMapper.insertSelective(member);
        if (insert == 0){
            Asserts.fail("插入失败");
        }
        return member.getId();
    }
}
