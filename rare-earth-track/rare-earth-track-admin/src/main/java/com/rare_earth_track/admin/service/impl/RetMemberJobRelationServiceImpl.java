package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetMemberJobRelationService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMemberJobRelationMapper;
import com.rare_earth_track.mgb.model.RetMemberJobRelation;
import com.rare_earth_track.mgb.model.RetMemberJobRelationExample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Ret member job relation service.
 *
 * @author hhoa
 * @date 2022 /5/25
 */
@Service
@RequiredArgsConstructor
public class RetMemberJobRelationServiceImpl implements RetMemberJobRelationService {
    private final RetMemberJobRelationMapper memberJobRelationMapper;
    @Override
    public void addMemberJobRelation(Long memberId) {
        RetMemberJobRelation memberJobRelation = new RetMemberJobRelation();
        memberJobRelation.setMemberId(memberId);
        int insert = memberJobRelationMapper.insert(memberJobRelation);
        if (insert == 0){
            Asserts.fail("插入失败");
        }
    }

    @Override
    public void addMemberJobRelation(Long memberId, Long jobId) {
        RetMemberJobRelation memberJobRelation = new RetMemberJobRelation();
        memberJobRelation.setMemberId(memberId);
        memberJobRelation.setMemberJobId(jobId);
        int insert = memberJobRelationMapper.insert(memberJobRelation);
        if (insert == 0){
            Asserts.fail("插入失败");
        }

    }

    @Override
    public void deleteMemberJobRelationByMemberId(Long memberId) {
        RetMemberJobRelationExample memberJobRelationExample= new RetMemberJobRelationExample();
        memberJobRelationExample.createCriteria().andMemberIdEqualTo(memberId);
        List<RetMemberJobRelation> memberJobRelations = memberJobRelationMapper.selectByExample(memberJobRelationExample);
        if (memberJobRelations == null || memberJobRelations.size() == 0){
            Asserts.fail("没有该关系");
        }
        memberJobRelationMapper.deleteByPrimaryKey(memberJobRelations.get(0).getId());
    }

    @Override
    public void updateMemberJobRelation(Long memberId, Long jobId) {
        RetMemberJobRelationExample memberJobRelationExample= new RetMemberJobRelationExample();
        memberJobRelationExample.createCriteria().andMemberIdEqualTo(memberId);
        List<RetMemberJobRelation> memberJobRelations = memberJobRelationMapper.selectByExample(memberJobRelationExample);
        if (memberJobRelations == null || memberJobRelations.size() == 0){
            Asserts.fail("没有该关系");
        }
        RetMemberJobRelation memberJobRelation = memberJobRelations.get(0);
        memberJobRelation.setMemberJobId(jobId);
        memberJobRelationMapper.updateByPrimaryKey(memberJobRelation);
    }

    @Override
    public Long getJobIdByMemberId(Long memberId) {
        RetMemberJobRelationExample memberJobRelationExample = new RetMemberJobRelationExample();
        memberJobRelationExample.createCriteria().andMemberIdEqualTo(memberId);
        List<RetMemberJobRelation> retMemberJobRelations = memberJobRelationMapper.selectByExample(memberJobRelationExample);
        if (retMemberJobRelations != null && retMemberJobRelations.size() > 0){
            return retMemberJobRelations.get(0).getMemberJobId();
        }
        return null;
    }
}
