package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.IdentifyType;
import com.rare_earth_track.admin.bean.RetUserAuthParam;
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
     * @param id           the id
     * @param identifier   the identifier
     * @param identifyType the identifyType
     */
    @Transactional
    void bind(Long id, String identifier, IdentifyType identifyType);

    /**
     * Update credential.
     *
     * @param userId     the user id
     * @param credential the credential
     */
    void updateCredential(Long userId, String credential);

    /**
     * Delete user auth.
     *
     * @param userId the user id
     */
    @Transactional
    void deleteAllUserAuth(Long userId);


    /**
     * Update user auth.
     *
     * @param userId        the user id
     * @param identifyType  the identify type
     * @param userAuthParam the user auth param
     */
    void updateUserAuth(Long userId, IdentifyType identifyType, RetUserAuthParam userAuthParam);


    /**
     * Gets user id by user name.
     *
     * @param username the username
     * @return the user id by user name
     */
    Long getUserIdByUserName(String username);

    /**
     * Delete user auth.
     *
     * @param userId   the user id
     * @param authType the auth type
     */
    void deleteUserAuth(Long userId, IdentifyType authType);

    /**
     * Gets user auth.
     *
     * @param identifier the identifier
     * @return the user auth
     */
    RetUserAuth getUserAuth(String identifier);

    /**
     * Exists boolean.
     *
     * @param userId the user id
     * @param email  the email
     * @return the boolean
     */
    boolean exists(Long userId, IdentifyType email);
}
