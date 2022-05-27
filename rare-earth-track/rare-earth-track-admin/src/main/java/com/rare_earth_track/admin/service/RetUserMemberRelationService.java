package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.RetFactoryJob;

import java.util.List;

/**
 * The interface Ret user member relation service.
 *
 * @author hhoa
 * @date 2022 /5/25
 */
public interface RetUserMemberRelationService {
    /**
     * 增加用户成员关系
     *
     * @param userId   用户id
     * @param memberId 成员id
     */
    void addUserMemberRelation(Long userId, Long memberId);

    /**
     * Delete user member relation by member id.
     *
     * @param memberId the member id
     */
    void deleteUserMemberRelationByMemberId(Long memberId);

    /**
     * Gets factory jobs by user id.
     *
     * @param id the id
     * @return the factory jobs by user id
     */
    List<RetFactoryJob> getFactoryJobsByUserId(Long id);
}
