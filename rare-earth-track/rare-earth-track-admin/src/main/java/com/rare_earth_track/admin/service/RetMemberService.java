package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.RetFactoryJob;
import com.rare_earth_track.mgb.model.RetMember;
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
     */
    @Transactional
    void addMember(RetMember member);

    /**
     * Delete member by member id int.
     *
     * @param id the id
     */
    @Transactional
    void deleteMemberByMemberId(Long id);


    /**
     * Gets member by member id.
     *
     * @param id the id
     * @return the member by member id
     */
    RetMember getMemberByMemberId(Long id);

    /**
     * Update member job.
     *
     * @param memberId the member id
     * @param job      the job
     */
    @Transactional
    void updateMemberJob(Long memberId, Long job);

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
}
