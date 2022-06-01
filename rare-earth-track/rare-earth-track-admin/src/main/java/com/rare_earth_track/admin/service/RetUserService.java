package com.rare_earth_track.admin.service;


import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    void updateUserPassword(RetUserAuthParam passwordParam);

    /**
     * 获取所有用户
     *
     * @return 所有用户 all users
     */
    List<RetUser> getAllUsers();


    /**
     * 获取部分用户
     *
     * @param pageNum  页面数量
     * @param pageSize 单页大小
     * @return 部分用户 list
     */
    List<RetUser> list(Integer pageNum, Integer pageSize);

    /**
     * 通过用户名获取用户
     *
     * @param name name
     * @return user -用户
     */
    RetUser getUserByName(String name);


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
     * Gets user detail by identifier.
     *
     * @param identifier the identifier
     * @return the user detail by identifier
     */
    RetUserDetails getUserDetailByIdentifier(String identifier);

    /**
     * Gets user by indentifier.
     *
     * @param identifier the identifier
     * @return the user by indentifier
     */
    RetUser getUserByIndentifier(String identifier);

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

    RetUser getUser(Long userId);

    /**
     * Delete user by user id.
     *
     * @param userId the user id
     */
    @Transactional
    void deleteUserByUserId(Long userId);

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
    void updateUserAuth(Long userId, IdentifyType authType, RetAdminUserAuthParam userAuth);

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
}
