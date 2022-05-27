package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetPermission;

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
     * @param pageNum the pageNum
     * @param pageSize the pageSize
     * @return 分页成员 list
     */
    List<RetMemberJob> list(Integer pageNum, Integer pageSize);

    /**
     * List job resources list.
     *
     * @param pageNum  the pageNum
     * @param pageSize  the pageSize
     * @param jobId the job id
     * @return the list
     */
    List<RetPermission> listJobPermissions(Integer pageNum, Integer pageSize, Long jobId);


    /**
     * Add job resource.
     *
     * @param jobId      the job id
     * @param resourceId the resource id
     */
    void addJobPermission(Long jobId, Long resourceId);

    /**
     * Delete job resource.
     *
     * @param jobId      the job id
     * @param resourceId the resource id
     */
    void deleteJobPermission(Long jobId, Long resourceId);
}
