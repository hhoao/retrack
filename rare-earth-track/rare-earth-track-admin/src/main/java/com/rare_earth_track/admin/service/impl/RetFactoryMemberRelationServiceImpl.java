package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetFactoryMemberRelationService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetFactoryMemberRelationMapper;
import com.rare_earth_track.mgb.mapper.RetMemberMapper;
import com.rare_earth_track.mgb.model.RetFactoryMemberRelation;
import com.rare_earth_track.mgb.model.RetFactoryMemberRelationExample;
import com.rare_earth_track.mgb.model.RetMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Ret factory member relation service.
 *
 * @author hhoa
 * @date 2022 /5/25
 */
@Service
@RequiredArgsConstructor
public class RetFactoryMemberRelationServiceImpl implements RetFactoryMemberRelationService {
    private final RetFactoryMemberRelationMapper factoryMemberRelationMapper;
    private final RetMemberMapper memberMapper;
    @Override
    public void addFactoryMemberRelation(Long factoryId, Long memberId) {
        RetFactoryMemberRelation factoryMemberRelation = new RetFactoryMemberRelation();
        factoryMemberRelation.setFactoryId(factoryId);
        factoryMemberRelation.setMemberId(memberId);
        factoryMemberRelationMapper.insert(factoryMemberRelation);
    }

    @Override
    public void deleteFactoryMemberRelationByMemberId(Long memberId) {
        RetFactoryMemberRelationExample factoryMemberRelationExample= new RetFactoryMemberRelationExample();
        factoryMemberRelationExample.createCriteria().andMemberIdEqualTo(memberId);
        List<RetFactoryMemberRelation> retFactoryMemberRelations = factoryMemberRelationMapper.selectByExample(factoryMemberRelationExample);
        if (retFactoryMemberRelations == null || retFactoryMemberRelations.size() == 0){
            Asserts.fail("没有该关系");
        }
        factoryMemberRelationMapper.deleteByPrimaryKey(retFactoryMemberRelations.get(0).getId());
    }

    @Override
    public List<RetMember> getFactoryMembers(Long factoryId) {
        RetFactoryMemberRelationExample factoryMemberRelationExample = new RetFactoryMemberRelationExample();
        factoryMemberRelationExample.createCriteria().andFactoryIdEqualTo(factoryId);
        List<RetFactoryMemberRelation> retFactoryMemberRelations = factoryMemberRelationMapper.selectByExample(factoryMemberRelationExample);
        List<RetMember> members = new ArrayList<>();
        for (RetFactoryMemberRelation factoryMemberRelation : retFactoryMemberRelations){
            RetMember member = memberMapper.selectByPrimaryKey(factoryMemberRelation.getMemberId());
            members.add(member);
        }
        return members;
    }

    @Override
    public Long getFactoryIdByMemberId(Long memberId) {
        RetFactoryMemberRelationExample factoryMemberRelationExample =  new RetFactoryMemberRelationExample();
        factoryMemberRelationExample.createCriteria().andMemberIdEqualTo(memberId);
        List<RetFactoryMemberRelation> retFactoryMemberRelations = factoryMemberRelationMapper.selectByExample(factoryMemberRelationExample);
        if (retFactoryMemberRelations != null && retFactoryMemberRelations.size() > 0){
            return retFactoryMemberRelations.get(0).getFactoryId();
        }
        return null;
    }
}
