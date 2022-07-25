package com.rare_earth_track.admin.service;


import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * The interface Ret user service.
 *
 * @author hhoa
 */
public interface RetUserService {

    /**
     * Gets user by identifier.
     *
     * @param identifier the identifier
     * @return the user by identifier
     */
    RetUser getUserByIdentifier(String identifier);

    /**
     * Gets user by username.
     *
     * @param username the username
     * @return the user by username
     */
    RetUser getUserByUsername(String username);

    /**
     * 更新用户
     *
     * @param user 用户参数
     */
    @Transactional
    void updateUser(RetUser user);

    /**
     * Gets factory jobs by user name.
     *
     * @param username the username
     * @return the factory jobs by user name
     */
    List<RetFactoryJob> getFactoryJobsByUserName(String username);

    /**
     * Gets user.
     *
     * @param userId the user id
     * @return the user
     */
    RetUser getUser(Long userId);

    /**
     * Delete user by user id.
     *
     * @param userId the user id
     */
    @Transactional
    void deleteUserByUserId(Long userId);

    /**
     * Delete users.
     *
     * @param user the user
     */
    @Transactional
    void deleteUsers(RetUser user);

    /**
     * Gets user.
     *
     * @param user the user
     * @return the user
     */
    List<RetUser> getUsers(RetUser user);

    /**
     * Update user auth.
     *
     * @param userId   the user id
     * @param authType the auth type
     * @param userAuth the user auth
     */
    @Transactional
    void updateUserAuth(Long userId, IdentifyType authType, RetUserAuthParam userAuth);


    /**
     * List list.
     *
     * @param userParam the user param
     * @param pageInfo  the page info
     * @return the list
     */
    List<RetUserParam> list(RetUserParam userParam, PageInfo pageInfo);

    /**
     * Gets user auths.
     *
     * @param userId the user id
     * @return the user auths
     */
    Map<String, String> getUserAuths(Long userId);

    /**
     * Delete user auth.
     *
     * @param userId       the user id
     * @param identifyType the auth id
     */
    @Transactional
    void deleteUserAuth(Long userId, IdentifyType identifyType);

    /**
     * Gets ret user auth.
     *
     * @param userId the user id
     * @param type   the type
     * @return the ret user auth
     */
    RetUserAuth getUserAuth(Long userId, IdentifyType type);
}
