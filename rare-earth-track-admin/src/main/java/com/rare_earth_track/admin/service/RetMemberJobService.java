package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetPermission;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ret member job service.
 *
 * @author hhoa
 * @date 2022 /5/25
 */
public interface RetMemberJobService {

    /**
     * 分页获取成员列表
     *
     * @param pageInfo  @return 分页成员 list
     * @param memberJob
     */
    List<RetMemberJob> list(PageInfo pageInfo, RetMemberJob memberJob);

    /**
     * List job resources list.
     *
     * @param pageInfo
     * @param jobId    the job id
     * @return the list
     */
    List<RetPermission> listJobPermissions(PageInfo pageInfo, Long jobId);


    /**
     * Add job resource.
     *
     * @param jobId      the job id
     * @param permissionId the resource id
     */
    @Transactional
    void addJobPermission(Long jobId, Long permissionId);

    /**
     * Delete job resource.
     *
     * @param jobId      the job id
     * @param permissionId the resource id
     */
    @Transactional
    void deleteJobPermission(Long jobId, Long permissionId);

    /**
     * Add job permission.
     *
     * @param jobName        the job name
     * @param permissionName the resource name
     */
    void addJobPermission(String jobName, String permissionName);

    /**
     * Gets job.
     *
     * @param jobName the job name
     * @return the job
     */
    RetMemberJob getJob(String jobName);

    /**
     * Delete job permission.
     *
     * @param jobName      the job name
     * @param permissionName the resource name
     */
    void deleteJobPermission(String jobName, String permissionName);

    /**
     * Gets job.
     *
     * @param memberJobId the member job id
     * @return the job
     */
    RetMemberJob getJob(Long memberJobId);

}
