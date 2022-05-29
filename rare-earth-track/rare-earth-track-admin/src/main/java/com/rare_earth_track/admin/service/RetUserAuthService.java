package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.IdentifyType;
import com.rare_earth_track.admin.bean.RetUserUpdatePasswordByAuthCodeParam;
import com.rare_earth_track.mgb.model.RetUserAuth;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ret user auth service.
 *
 * @author hhoa
 * @date 2022 /5/29
 */
public interface RetUserAuthService {

    /**
     * Gets user auth.
     *
     * @param userId the user id
     * @return the user auth
     */
    List<RetUserAuth> getUserAuth(Long userId);

    /**
     * Gets user auth.
     *
     * @param userId       the user id
     * @param identifyType the identify type
     * @return the user auth
     */
    RetUserAuth getUserAuth(Long userId, IdentifyType identifyType);

    /**
     * Gets user auth with identify type.
     *
     * @param identifyType the identify type
     * @param identifier   the identifier
     * @return the user auth with identify type
     */
    RetUserAuth getUserAuth(IdentifyType identifyType, String identifier);


    /**
     * Exists boolean.
     *
     * @param identifyType the identify type
     * @param identifier   the identifier
     * @return the boolean
     */
    boolean exists(IdentifyType identifyType, String identifier);

    /**
     * Bind.
     *
     * @param id       the id
     * @param username the username
     */
    @Transactional
    void bind(Long id, IdentifyType username);

    /**
     * Update credential by auth code.
     *
     * @param passwordParam the password param
     */
    @Transactional
    void updateCredential(RetUserUpdatePasswordByAuthCodeParam passwordParam);

    /**
     * Delete user auth.
     *
     * @param userId the user id
     */
    @Transactional
    void deleteUserAuth(Long userId);

    /**
     * Gets user auth.
     *
     * @param identifier the identifier
     * @param credential the credential
     * @return the user auth
     */
    RetUserAuth getUserAuth(String identifier, String credential);
}
