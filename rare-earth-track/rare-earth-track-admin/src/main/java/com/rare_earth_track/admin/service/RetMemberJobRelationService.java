package com.rare_earth_track.admin.service;

/**
 * The interface Ret member job relation service.
 *
 * @author hhoa
 * @date 2022 /5/25
 */
public interface RetMemberJobRelationService {
    /**
     * Add member job.
     *
     * @param memberId the id
     */
    void addMemberJobRelation(Long memberId);

    /**
     * Add member job.
     *
     * @param memberId the id
     * @param jobId    the job id
     */
    void addMemberJobRelation(Long memberId, Long jobId);

    /**
     * Delete member job relation by member id.
     *
     * @param memberId the member id
     */
    void deleteMemberJobRelationByMemberId(Long memberId);

    /**
     * Update member job relation.
     *
     * @param memberId the member id
     * @param jobId    the job id
     */
    void updateMemberJobRelation(Long memberId, Long jobId);

    /**
     * Gets job id by member id.
     *
     * @param memberId the member id
     * @return the job id by member id
     */
    Long getJobIdByMemberId(Long memberId);
}
