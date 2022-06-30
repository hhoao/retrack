package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFactoryJob;
import com.rare_earth_track.admin.bean.RetMemberParam;
import com.rare_earth_track.admin.service.RetMemberService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author hhoa
 * @date 2022/6/3
 **/

class RetMemberServiceImplTest extends TransactionTest {
    @Autowired
    RetMemberService memberService;

    static private List<Object[]> listParams(){
        List<Object[]> params = new ArrayList<>();
        params.add(new Object[]{new PageInfo(1, 2), null, (Consumer<List<RetMember>>) list -> {
            Assertions.assertEquals(list.size(), 2);
        }});
        return params;
    }

    @ParameterizedTest
    @MethodSource("listParams")
    void list(PageInfo pageInfo, RetMember member, Consumer<List<RetMember>> consumer) {
        consumer.accept(memberService.list(pageInfo, member));
    }

    @Test
    void addMember() {
        RetMember member = new RetMember();
        member.setNickname("testNickname");
        member.setJobId(1L);
        member.setFactoryId(1L);
        member.setUserId(1L);
        Long aLong = memberService.addMember(member);
        RetMember member1 = memberService.getMember(aLong);
        Long userId = member1.getUserId();
        Assertions.assertEquals(1L, userId);
    }

    @Test
    void deleteMember() {
        memberService.deleteMember(1L);
        Assertions.assertThrows(ApiException.class, ()-> memberService.getMember(1L));
    }

    @Test
    void getMember() {
        RetMember member = memberService.getMember(1L);
        List<RetMember> member1 = memberService.getMember(member);
        Assertions.assertTrue(member1.size() > 0);
        Assertions.assertNotNull(memberService.getMember(member.getFactoryId(), member.getUserId()));
    }

    @Test
    void updateMember() {
        RetMember member = memberService.getMember(1L);
        RetMemberParam memberParam = new RetMemberParam();
        memberParam.setNickname("lalala");
        memberService.updateMember(member.getFactoryId(), member.getUserId(), memberParam);
        RetMember member1 = new RetMember();
        member1.setNickname("lalala");
        List<RetMember> member2 = memberService.getMember(member1);
        Assertions.assertTrue(member2.size() > 0);
    }

    @Test
    void getFactoryMembers() {
        List<RetMember> factoryMembers = memberService.getFactoryMembers(1L);
        for (RetMember member : factoryMembers){
            Assertions.assertEquals(member.getFactoryId(), 1L);
        }
    }

    @Test
    void getFactoryJobsByUserId() {
        List<RetFactoryJob> factoryJobsByUserId = memberService.getFactoryJobsByUserId(7L);
        Assertions.assertEquals(factoryJobsByUserId.size(), 1);
    }

    @Test
    void deleteMembersByUserId() {
        memberService.deleteMembersByUserId(7L);
        List<RetFactoryJob> factoryJobsByUserId = memberService.getFactoryJobsByUserId(7L);
        Assertions.assertEquals(factoryJobsByUserId.size(), 0);
    }
}