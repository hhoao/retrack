package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetUserAuth;

/**
 * The interface Ret factory user relation service.
 *
 * @author hhoa
 * @date 2022 /5/29
 */
public interface RetFactoryUserRelationService {
    /**
     * Gets user email by username.
     *
     * @param username the username
     * @return the user email by username
     */
    RetUserAuth getUserEmailByUsername(String username);

    /**
     * Gets user id by username.
     *
     * @param username the username
     * @return user id by username
     */
    Long getUserIdByUsername(String username);
}
