package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetMember;
import com.rare_earth_track.portal.bean.RetFactoryJob;
import com.rare_earth_track.portal.bean.RetMemberParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ret member service.
 *
 * @author hhoa
 * @date 2022 /5/23
 */
public interface RetMemberService {

    /**
     * 分页获取成员列表
     *
     * @param pageNum  the pageNum
     * @param pageSize the pageSize
     * @return 分页成员 list
     */
    List<RetMember> list(Integer pageNum, Integer pageSize);

    /**
     * Add member int.
     *
     * @param member the factory
     * @return memberId
     */
    @Transactional
    Long addMember(RetMember member);

    /**
     * Delete member by member id int.
     *
     * @param id the id
     */
    @Transactional
    void deleteMember(Long id);


    /**
     * Gets member by member id.
     *
     * @param memberId the id
     * @return the member by member id
     */
    RetMember getMember(Long memberId);

    /**
     * Update member job.
     *
     * @param factoryId   the member id
     * @param userId      the job
     * @param memberParam the member param
     */
    @Transactional
    void updateMember(Long factoryId, Long userId, RetMemberParam memberParam);

    /**
     * Gets factory members.
     *
     * @param factoryId the factory id
     * @return the factory members
     */
    List<RetMember> getFactoryMembers(Long factoryId);

    /**
     * Gets factory jobs by user userId.
     *
     * @param userId the userId
     * @return the factory jobs by user userId
     */
    List<RetFactoryJob> getFactoryJobsByUserId(Long userId);

    /**
     * Delete members.
     *
     * @param userId the user id
     */
    void deleteMembersByUserId(Long userId);

    List<RetMember> getMember(RetMember member);

    void deleteMembers(RetMember member);

    RetMember getMember(Long factoryId, Long userId);

    /**
     * Delete member.
     *
     * @param factoryId        the factory id
     * @param userIdByUsername the user id by username
     */
    void deleteMember(Long factoryId, Long userIdByUsername);
}
