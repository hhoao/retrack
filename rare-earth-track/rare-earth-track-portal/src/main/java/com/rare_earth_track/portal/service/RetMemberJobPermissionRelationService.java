package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetMemberJob;
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
    void deleteMemberPermission(Long permissionId);

    RetPermission getJobPermission(Long jobId, Long permissionId);

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

    /**
     * Add job permission.
     *
     * @param jobName        the job name
     * @param permissionName the permission name
     */
    void addJobPermission(String jobName, String permissionName);

    /**
     * Gets jobs.
     *
     * @param id the id
     * @return the jobs
     */
    List<RetMemberJob> getJobs(Long id);

    /**
     * Delete job permission.
     *
     * @param jobName        the job name
     * @param permissionName the permission name
     */
    void deleteJobPermission(String jobName, String permissionName);
}
