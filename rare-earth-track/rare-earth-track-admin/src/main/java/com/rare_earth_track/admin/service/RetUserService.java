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
     * 通过用户获取UserDetails
     *
     * @param retUser user
     * @return userDetails user details by user
     */
    UserDetails getUserDetails(RetUser retUser);

    /**
     * 登录
     *
     * @param identifier 认证标识
     * @param credential 认证凭据
     * @return token string
     */
    String login(String identifier, String credential);

    /**
     * 退出
     *
     * @param token token
     */
    void logout(String token);

    /**
     * 用户注册(使用用户名注册)
     *
     * @param registerParam 注册参数
     * @return user ret user
     */
    @Transactional(rollbackFor = Exception.class, noRollbackFor = ApiException.class)
    RetUser register(RetUserRegisterParam registerParam);

    /**
     * Register ret user.
     *
     * @param registerParam the register param
     * @param identifyType  the identify type
     * @return the ret user
     */
    @Transactional
    RetUser register(RetUserRegisterParam registerParam, IdentifyType identifyType);

    /**
     * 刷新token
     *
     * @param token 旧token
     * @return token 新token
     */
    String refreshToken(String token);

    /**
     * 使用验证码更改密码
     *
     * @param passwordParam 更新密码需要的参数
     */
    @Transactional(rollbackFor = Exception.class, noRollbackFor = ApiException.class)
    void updatePasswordByAuthCode(RetUserUpdatePasswordByAuthCodeParam passwordParam);

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
     * 通过用户名获取用户
     *
     * @param username 用户名
     * @return 用户 user cache by user name
     */
    RetUser getUserCacheByUserName(String username);

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
    void sendMailAuthCode(String mail);

    /**
     * Gets factory jobs by user name.
     *
     * @param username the username
     * @return the factory jobs by user name
     */
    List<RetFactoryJob> getFactoryJobsByUserName(String username);

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
}
