package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetMemberJob;

/**
 * The interface Ret member job service.
 *
 * @author hhoa
 * @date 2022 /7/14
 */
public interface RetMemberJobService {
    /**
     * Gets job.
     *
     * @param jobId the job id
     * @return the job
     */
    RetMemberJob getJob(Long jobId);
}
