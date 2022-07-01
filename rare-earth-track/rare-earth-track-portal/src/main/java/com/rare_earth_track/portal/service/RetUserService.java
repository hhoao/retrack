package com.rare_earth_track.portal.service;


import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import org.springframework.security.core.userdetails.UserDetails;
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
     * 获取UserDetails
     *
     * @param username username
     * @return userDetails user details by user name
     */
    UserDetails getUserDetails(String username);

    /**
     * Has login boolean.
     *
     * @param username the username
     * @return the boolean
     */
    boolean hasLogin(String username);

    /**
     * 登录
     *
     * @param loginParam the login param
     * @return token string
     */
    String login(RetLoginParam loginParam);

    /**
     * 退出
     *
     * @param authorization authorization
     */
    void logout(String authorization);

    /**
     * Register ret user.
     *
     * @param registerParam the register param
     * @return userId long
     */
    @Transactional
    Long register(RetUserRegisterParam registerParam);

    /**
     * 刷新token
     *
     * @param authorization 旧token
     * @return authorization 新token
     */
    String refreshToken(String authorization);

    /**
     * 使用验证码更改密码
     *
     * @param passwordParam 更新密码需要的参数
     */
    @Transactional(rollbackFor = Exception.class, noRollbackFor = ApiException.class)
    void updateUserPassword(RetUpdateUserPasswordParam passwordParam);

    /**
     * 获取所有用户
     *
     * @return 所有用户 all users
     */
    List<RetUser> getAllUsers();


    /**
     * 获取部分用户
     *
     * @param pageInfo @return 部分用户 list
     * @return the list
     */
    List<RetUser> list(PageInfo pageInfo);

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
     * 发送邮箱验证码
     *
     * @param mail 接收方
     */
    void sendUserRegisterMail(String mail);

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
    void deleteUsers(RetUser user);

    /**
     * Gets user.
     *
     * @param user the user
     * @return the user
     */
    List<RetUser> getUser(RetUser user);

    /**
     * Gets user resources.
     *
     * @param userId the user id
     * @return the user resources
     */
    List<RetResource> getUserResources(Long userId);

    /**
     * Update user role.
     *
     * @param userId the user id
     * @param roleId the role id
     */
    void updateUserRole(Long userId, Long roleId);

    /**
     * Gets user email by username.
     *
     * @param username the username
     * @return the user email by username
     */
    RetUserAuth getUserEmailByUsername(String username);

    /**
     * Update user.
     *
     * @param user          the user
     * @param authorization the authorization
     */
    void updateUser(RetUser user, String authorization);

    /**
     * Update user auth.
     *
     * @param userId   the user id
     * @param authType the auth type
     * @param userAuth the user auth
     */
    void updateUserAuth(Long userId, IdentifyType authType, RetUserAuthParam userAuth);

    /**
     * Unbind user auth.
     *
     * @param authType      the auth type
     * @param authorization the authorization
     */
    void unbindUserAuth(IdentifyType authType, String authorization);

    /**
     * Update newUsername.
     *
     * @param newUsername   the newUsername
     * @param authorization the authorization
     */
    void updateUsername(String newUsername, String authorization);

    /**
     * Gets user by authorization.
     *
     * @param authorization the authorization
     * @return the user by authorization
     */
    RetUser getUserByAuthorization(String authorization);

    /**
     * Gets menus by authorization.
     *
     * @param authorization the authorization
     * @return the menus by authorization
     */
    List<RetMenu> getMenusByAuthorization(String authorization);

    /**
     * Query users list.
     *
     * @param userParam the user
     * @param pageInfo  the page info
     * @return the list
     */
    List<RetUser> queryUsers(RetUserParam userParam, PageInfo pageInfo);

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
}
