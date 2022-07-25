package com.rare_earth_track.portal.service;


import com.rare_earth_track.common.exception.ApiException;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.portal.bean.*;
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
     * Gets user details.
     *
     * @param username the username
     * @return the user details
     */
    RetUserDetails getUserDetails(String username);

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
     * Gets user by username.
     *
     * @param username the username
     * @return the user by username
     */
    RetUser getUserByUsername(String username);

    /**
     * 发送邮箱验证码
     *
     * @param mail 接收方
     */
    void sendUserRegisterMail(String mail);

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
     * Gets user auths.
     *
     * @param userId the user id
     * @return the user auths
     */
    Map<String, String> getUserAuths(Long userId);

    /**
     * Bind email.
     *
     * @param email    the email
     * @param authCode the auth code
     * @param s        the s
     */
    void bindEmail(String email, String authCode, String s);

    /**
     * Bind phone.
     *
     * @param phone    the phone
     * @param authCode the auth code
     * @param s        the s
     */
    void bindPhone(String phone, String authCode, String s);

    /**
     * Send bind email code.
     *
     * @param email the email
     * @param s     the s
     */
    void sendBindEmailCode(String email, String s);

    /**
     * Gets verified user auths.
     *
     * @param authorization the authorization
     * @return the verified user auths
     */
    Map<String, String> getVerifiedUserAuths(String authorization);

    /**
     * Gets user by authorization.
     *
     * @param authorization the authorization
     * @return the user by authorization
     */
    RetUser getUserByAuthorization(String authorization);
}
