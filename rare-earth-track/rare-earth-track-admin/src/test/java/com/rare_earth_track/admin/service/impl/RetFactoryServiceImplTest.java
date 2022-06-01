package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.TransactionTest;
import com.rare_earth_track.admin.service.RetFactoryService;
import com.rare_earth_track.admin.service.RetMemberService;
import com.rare_earth_track.mgb.model.RetFactory;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/31
 **/

@SpringBootTest
@RequiredArgsConstructor
class RetFactoryServiceImplTest extends TransactionTest {
    @Autowired
    RetFactoryService factoryService;
    @Autowired
    RetMemberService memberService;

    @Test
    void addFactoryMember() {
        Long aLong = factoryService.addFactoryMember(1L, 1L);
        Assertions.assertNotNull(memberService.getMember(aLong));
    }

    @Test
    void list() {
        List<RetFactory> list = factoryService.list(1, 5);
        Assertions.assertNotNull(list);
    }

    @Test
    void addFactory() {
        RetFactory factory = new RetFactory();
        Long aLong = factoryService.addFactory(factory);
        Assertions.assertNotNull(factoryService.getFactoryByFactoryId(aLong));
    }

    @Test
    void updateFactory() {
    }

    @Test
    void deleteFactoryByFactoryId() {
    }

    @Test
    void deleteFactoryByName() {
    }

    @Test
    void getFactoryByFactoryName() {
    }

    @Test
    void getFactoryByFactoryId() {
    }

    @Test
    void inviteUserByEmail() {
    }

    @Test
    void inviteUserByPhone() {
    }

    @Test
    void deleteFactoryMemberByUsername() {
    }

    @Test
    void testAddFactoryMember() {
    }

    @Test
    void handleInvitation() {
    }

    @Test
    void updateFactoryMemberJob() {
    }

    @Test
    void listFactoryMembers() {
    }

    @Test
    void getFactoryMapper() {
    }

    @Test
    void getTokenService() {
    }

    @Test
    void getFactoryInvitationCacheService() {
    }

    @Test
    void getMailService() {
    }

    @Test
    void getTokenCacheService() {
    }

    @Test
    void getMemberService() {
    }

    @Test
    void getFactoryUserRelationService() {
    }
}