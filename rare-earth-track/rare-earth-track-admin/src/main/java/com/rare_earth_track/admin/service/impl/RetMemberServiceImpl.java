package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.service.RetMemberJobRelationService;
import com.rare_earth_track.admin.service.RetMemberService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMemberMapper;
import com.rare_earth_track.mgb.model.RetMember;
import com.rare_earth_track.mgb.model.RetMemberExample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/24
 **/

@RequiredArgsConstructor
@Service
public class RetMemberServiceImpl implements RetMemberService {
    private final RetMemberMapper memberMapper;
    private final RetMemberJobRelationService memberJobRelationService;
    @Override
    public List<RetMember> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return memberMapper.selectByExample(new RetMemberExample());
    }

    @Override
    public void addMember(RetMember member) {
        int insert = memberMapper.insert(member);
        if (insert == 0){
            Asserts.fail("插入失败");
        }
        memberJobRelationService.addMemberJobRelation(member.getId());
    }


    @Override
    public void deleteMemberByMemberId(Long memberId) {
        int i = memberMapper.deleteByPrimaryKey(memberId);
        if (i == 0){
            Asserts.fail("删除失败");
        }
        memberJobRelationService.deleteMemberJobRelationByMemberId(memberId);
    }
    @Override
    public RetMember getMemberByMemberId(Long id) {
        RetMember retMember = memberMapper.selectByPrimaryKey(id);
        if (retMember == null){
            Asserts.fail("没有该成员");
        }
        return retMember;
    }

    @Override
    public void updateMemberJob(Long memberId, Long jobId) {
        memberJobRelationService.updateMemberJobRelation(memberId, jobId);
    }
}
