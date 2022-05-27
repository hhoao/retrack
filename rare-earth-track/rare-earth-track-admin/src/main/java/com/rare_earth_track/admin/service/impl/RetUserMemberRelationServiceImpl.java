package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.bean.RetFactoryJob;
import com.rare_earth_track.admin.service.RetFactoryMemberRelationService;
import com.rare_earth_track.admin.service.RetMemberJobRelationService;
import com.rare_earth_track.admin.service.RetUserMemberRelationService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetUserMemberRelationMapper;
import com.rare_earth_track.mgb.model.RetUserMemberRelation;
import com.rare_earth_track.mgb.model.RetUserMemberRelationExample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/25
 **/
@Service
@RequiredArgsConstructor
public class RetUserMemberRelationServiceImpl implements RetUserMemberRelationService {
    private final RetUserMemberRelationMapper userMemberRelationMapper;
    private final RetMemberJobRelationService memberJobRelationService;
    private final RetFactoryMemberRelationService factoryMemberRelationService;
    @Override
    public void addUserMemberRelation(Long userId, Long memberId) {
        RetUserMemberRelation userMemberRelation = new RetUserMemberRelation();
        userMemberRelation.setUserId(userId);
        userMemberRelation.setMemberId(memberId);
        userMemberRelationMapper.insert(userMemberRelation);
    }

    @Override
    public void deleteUserMemberRelationByMemberId(Long memberId) {
        RetUserMemberRelationExample userMemberRelationExample = new RetUserMemberRelationExample();
        userMemberRelationExample.createCriteria().andMemberIdEqualTo(memberId);
        List<RetUserMemberRelation> retUserMemberRelations = userMemberRelationMapper.selectByExample(userMemberRelationExample);
        if (retUserMemberRelations == null || retUserMemberRelations.size() == 0){
            Asserts.fail("没有该关系");
        }
        userMemberRelationMapper.deleteByPrimaryKey(retUserMemberRelations.get(0).getId());
    }

    @Override
    public List<RetFactoryJob> getFactoryJobsByUserId(Long userId) {
        RetUserMemberRelationExample userMemberRelationExample = new RetUserMemberRelationExample();
        userMemberRelationExample.createCriteria().andUserIdEqualTo(userId);
        List<RetUserMemberRelation> retUserMemberRelations = userMemberRelationMapper.selectByExample(userMemberRelationExample);
        List<RetFactoryJob> factoryJobs = new ArrayList<>();
        for (RetUserMemberRelation userMemberRelation : retUserMemberRelations){
            Long memberId = userMemberRelation.getMemberId();
            Long factoryId = factoryMemberRelationService.getFactoryIdByMemberId(memberId);
            Long jobId = memberJobRelationService.getJobIdByMemberId(memberId);
            factoryJobs.add(new RetFactoryJob(factoryId, jobId));
        }
        return factoryJobs;
    }
}
