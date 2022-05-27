package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetMember;

import java.util.List;

/**
 * The interface Ret factory member relation service.
 *
 * @author hhoa
 * @date 2022 /5/25
 */
public interface RetFactoryMemberRelationService {
    /**
     * 添加工厂成员关系
     *
     * @param factoryId 工厂id
     * @param userId    用户id
     */
    void addFactoryMemberRelation(Long factoryId, Long userId);

    /**
     * Delete factory member relation by member id.
     *
     * @param memberId the member id
     */
    void deleteFactoryMemberRelationByMemberId(Long memberId);

    /**
     * Gets factory members.
     *
     * @param factoryId the factory id
     * @return the factory members
     */
    List<RetMember> getFactoryMembers(Long factoryId);

    /**
     * Gets factory id by member id.
     *
     * @param memberId the member id
     * @return the factory id by member id
     */
    Long getFactoryIdByMemberId(Long memberId);
}
