package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.MailType;
import com.rare_earth_track.admin.service.*;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetFactoryMapper;
import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetFactoryExample;
import com.rare_earth_track.mgb.model.RetMember;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.security.util.JwtTokenService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/24
 **/
@Service
@RequiredArgsConstructor
@Data
public class RetFactoryServiceImpl implements RetFactoryService {
    private final RetFactoryMapper factoryMapper;
    private final JwtTokenService tokenService;
    private final RetFactoryInvitationCacheService factoryInvitationCacheService;
    private final RetMailService mailService;
    private final RetUserService userService;
    private final RetFactoryMemberRelationService factoryMemberRelationService;
    private final RetMemberService memberService;
    private final RetUserMemberRelationService userMemberRelationService;

    @Override
    public List<RetFactory> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return factoryMapper.selectByExample(new RetFactoryExample());
    }

    @Override
    public void addFactory(RetFactory factory) {
        int insert = factoryMapper.insert(factory);
        if (insert == 0){
            Asserts.fail("插入失败");
        }
    }

    @Override
    public void updateFactory(RetFactory factory) {
        Long id = factory.getId();
        if (id == null){
            Asserts.fail("没有id");
        }
        factoryMapper.updateByPrimaryKey(factory);
    }

    @Override
    public void deleteFactoryByFactoryId(Long id) {
        int i = factoryMapper.deleteByPrimaryKey(id);
        if (i == 0){
            Asserts.fail("删除失败");
        }
    }

    @Override
    public int deleteFactoryByName(String name) {
        RetFactory factoryByFactoryName = getFactoryByFactoryName(name);
        int i = factoryMapper.deleteByPrimaryKey(factoryByFactoryName.getId());
        if (i == 0){
            Asserts.fail("删除失败");
        }
        return i;
    }

    @Override
    public RetFactory getFactoryByFactoryName(String name) {
        RetFactoryExample factoryExample = new RetFactoryExample();
        factoryExample.createCriteria().andNameEqualTo(name);
        List<RetFactory> retFactories = factoryMapper.selectByExample(factoryExample);
        if (retFactories != null && retFactories.size() > 0){
            return retFactories.get(0);
        }
        return null;
    }

    @Override
    public RetFactory getFactoryByFactoryId(Long id) {
        RetFactory retFactory = factoryMapper.selectByPrimaryKey(id);
        if (retFactory == null){
            Asserts.fail("没有该工厂");
        }
        return retFactory;
    }

    @Override
    public void inviteUserByEmail(Long factoryId, String emailOrPhone) {

    }

    @Override
    public void inviteUserByPhone(Long factoryId, String emailOrPhone) {

    }

    @Override
    public void deleteFactoryMemberByMemberId(Long memberId) {
        userMemberRelationService.deleteUserMemberRelationByMemberId(memberId);
        factoryMemberRelationService.deleteFactoryMemberRelationByMemberId(memberId);
        memberService.deleteMemberByMemberId(memberId);
    }
    @Override
    public void addFactoryMember(Long factoryId, Long userId) {
        RetMember member = new RetMember();
        memberService.addMember(member);
        userMemberRelationService.addUserMemberRelation(userId, member.getId());
        factoryMemberRelationService.addFactoryMemberRelation(factoryId, member.getId());
    }
    @Override
    public void handleInvitation(Long factoryId, String token) {
        //获取邮箱
        String username = tokenService.getSubjectFromToken(token);
        RetUser user= userService.getUserByName(username);
        if (user == null){
            Asserts.fail("没有登陆");
        }
        String email = user.getEmail();
        //验证邮箱
        boolean b = mailService.existMessage(email, MailType.FACTORY_INVITATION);
        if (!b){
            Asserts.fail("没有该邮箱");
        }
        addFactoryMember(factoryId, user.getId());
    }

    @Override
    public void updateFactoryMemberJob(Long memberId, Long job) {
        memberService.updateMemberJob(memberId, job);
    }

    @Override
    public List<RetMember> listFactoryMembers(Integer from, Integer size, Long factoryId) {
        PageHelper.startPage(from, size);
        return factoryMemberRelationService.getFactoryMembers(factoryId);
    }
}
