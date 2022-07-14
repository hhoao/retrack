package com.rare_earth_track.portal.service;

import com.rare_earth_track.portal.bean.RetFactoryJob;

import java.util.List;

/**
 * The interface Ret member service.
 *
 * @author hhoa
 * @date 2022 /7/14
 */
public interface RetMemberService {
    /**
     * Gets factory jobs by user id.
     *
     * @param userId the user id
     * @return the factory jobs by user id
     */
    List<RetFactoryJob> getFactoryJobsByUserId(Long userId);
}
