package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetPermission;

import java.util.List;

/**
 * The interface Ret member job permission relation service.
 *
 * @author hhoa
 * @date 2022 /5/27
 */
public interface RetMemberJobPermissionRelationService {
    /**
     * Delete member permission relation by permission id.
     *
     * @param permissionId the permission id
     */
    void deleteMemberPermissionRelationByPermissionId(Long permissionId);

    /**
     * Gets job permissions.
     *
     * @param jobId the job id
     * @return the job permissions
     */
    List<RetPermission> getJobPermissions(Long jobId);

    /**
     * Add job permission.
     *
     * @param jobId        the job id
     * @param permissionId the resource id
     */
    void addJobPermission(Long jobId, Long permissionId);

    /**
     * Delete job permission.
     *
     * @param jobId        the job id
     * @param permissionId the permission id
     */
    void deleteJobPermission(Long jobId, Long permissionId);
}
