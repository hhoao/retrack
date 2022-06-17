package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.bean.MailType;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFactoryParam;
import com.rare_earth_track.admin.bean.RetMemberParam;
import com.rare_earth_track.admin.service.RetFactoryService;
import com.rare_earth_track.admin.service.RetMailService;
import com.rare_earth_track.admin.service.RetMemberService;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/31
 **/

class RetFactoryServiceImplTest extends TransactionTest {
    @Autowired
    RetFactoryService factoryService;
    @Autowired
    RetMemberService memberService;
    @Autowired
    RetMailService mailService;

    private final String testName = "五矿稀土";
    private final Long testId = 1L;

    @Test
    void addFactoryMember() {
        Long aLong = factoryService.addFactoryMember(1L, 1L);
        Assertions.assertNotNull(memberService.getMember(aLong));
    }

    @Test
    void list() {
        List<RetFactory> list = factoryService.list(new PageInfo(1, 5));
        Assertions.assertTrue(list.size() <= 5);
    }

    @Test
    void addFactory() {
        RetFactoryParam factoryParam = new RetFactoryParam();
        Long aLong = factoryService.addFactory(factoryParam);
        Assertions.assertNotNull(factoryService.getFactoryByFactoryId(aLong));
    }

    @Test
    void updateFactory() {
        RetFactoryParam factoryParam = new RetFactoryParam();
        factoryParam.setPhone("1239581239");
        factoryService.updateFactory("五矿稀土", factoryParam);

    }

    @Test
    void deleteFactoryByName() {
        factoryService.deleteFactoryByName("五矿稀土");
        RetFactory factory = factoryService.getFactoryByFactoryName("五矿稀土");
        Assertions.assertNull(factory);
    }

    @Test
    void getFactoryByFactoryName() {
        RetFactory factoryByFactoryName = factoryService.getFactoryByFactoryName(testName);
        Assertions.assertNotNull(factoryByFactoryName);
    }

    @Test
    void getFactoryByFactoryId() {
        RetFactory factoryByFactoryId = factoryService.getFactoryByFactoryId(testId);
        Assertions.assertNotNull(factoryByFactoryId);
    }

    @Test
    void inviteUserByEmail() {
        factoryService.inviteUserByEmail(testName, tRegisterMail);
        boolean b = mailService.existMessage(tRegisterMail, MailType.FACTORY_INVITATION);
        Assertions.assertTrue(b);
    }

    @Test
    void inviteUserByPhone() {
    }

    @Test
    void deleteFactoryMemberByUsername() {
        factoryService.deleteFactoryMemberByUsername(testName, tUsername);
        Assertions.assertThrows(ApiException.class, ()-> memberService.getMember(testId, tUserId));
    }

    @Test
    void handleInvitation() {
    }

    @Test
    void updateFactoryMember() {
        RetMemberParam memberParam = new RetMemberParam();
        memberParam.setNickname("哈哈哈哈");
        factoryService.updateFactoryMember(testName, "user5", memberParam);
        RetMember member = new RetMember();
        member.setNickname("哈哈哈哈");
        member.setFactoryId(testId);
        List<RetMember> member1 = memberService.getMember(member);
        Assertions.assertEquals(member1.size(), 1);
    }

    @Test
    void listFactoryMembers() {
        List<RetMember> members = factoryService.listFactoryMembers(new PageInfo(1, 5), testName);
    }

    @Test
    void getFactory() {
        RetFactory factory1 = new RetFactory();
        factory1.setName("五矿%");
        List<RetFactory> factory2 = factoryService.getFactory(new PageInfo(1, 5), factory1);
        Assertions.assertEquals(factory2.size(), 1);
        Assertions.assertEquals(factory2.get(0).getName(), "五矿稀土");
    }
}