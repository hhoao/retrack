package com.rare_earth_track.admin.service;


import com.rare_earth_track.admin.bean.RetFactoryJob;
import com.rare_earth_track.admin.bean.RetUserParam;
import com.rare_earth_track.admin.bean.RetUserRegisterParam;
import com.rare_earth_track.admin.bean.RetUserUpdatePasswordParam;
import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetUser;
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
     * 验证邮箱是否存在
     *
     * @param mail 邮箱
     * @return 是否存在 boolean
     */
    Boolean existsMail(String mail);

    /**
     * 获取UserDetails
     *
     * @param username username
     * @return userDetails user details by user name
     */
    UserDetails getUserDetailsByUserName(String username);

    /**
     * 通过用户获取UserDetails
     *
     * @param retUser user
     * @return userDetails user details by user
     */
    UserDetails getUserDetailsByUser(RetUser retUser);

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return token string
     */
    String login(String username, String password);

    /**
     * 退出
     *
     * @param token token
     */
    void logout(String token);

    /**
     * 用户注册
     *
     * @param registerParam 注册参数
     * @return user ret user
     */
    @Transactional(rollbackFor = Exception.class, noRollbackFor = ApiException.class)
    RetUser register(RetUserRegisterParam registerParam);

    /**
     * 刷新token
     *
     * @param token 旧token
     * @return token 新token
     */
    String refreshToken(String token);

    /**
     * 使用邮箱更改密码
     *
     * @param passwordParam 密码
     */
    @Transactional(rollbackFor = Exception.class, noRollbackFor = ApiException.class)
    void updatePasswordWithMail(RetUserUpdatePasswordParam passwordParam);

    /**
     * 使用手机号码更新密码
     *
     * @param passwordParam 密码
     */
    @Transactional(rollbackFor = Exception.class, noRollbackFor = ApiException.class)
    void updatePasswordWithPhone(RetUserUpdatePasswordParam passwordParam);

    /**
     * 生产短信验证码
     *
     * @param phone 电话号码
     * @return 验证码 string
     */
    String generatePhoneAuthCode(String phone);

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
     * @param userId    the user id
     * @param userParam 用户参数
     * @return 用户 ret user
     */
    @Transactional(rollbackFor = Exception.class, noRollbackFor = ApiException.class)
    RetUser updateUser(Long userId, RetUserParam userParam);

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
    void deleteUserByUserId(Long userId);

    /**
     * Update user role.
     *
     * @param userId the user id
     * @param roleId the role id
     */
    void alterUserRole(Long userId, Long roleId);
}
