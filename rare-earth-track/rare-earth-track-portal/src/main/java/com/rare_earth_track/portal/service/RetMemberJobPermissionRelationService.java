package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetMemberJob;

import java.util.List;

/**
 * The interface Ret member job permission relation service.
 *
 * @author hhoa
 * @date 2022 /5/27
 */
public interface RetMemberJobPermissionRelationService {
    /**
     * Gets jobs.
     *
     * @param id the id
     * @return the jobs
     */
    List<RetMemberJob> getJobs(Long id);
}
