package com.rare_earth_track.admin.service;


import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetLoginParam;
import com.rare_earth_track.mgb.model.RetAdministrator;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetResource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ret administrator service.
 *
 * @author hhoa
 */
public interface RetAdministratorService {

    /**
     * Login string.
     *
     * @param loginParam the login param
     * @return the string
     */
    String login(RetLoginParam loginParam);

    /**
     * Logout.
     *
     * @param authorization the authorization
     */
    void logout(String authorization);

    /**
     * 获取AdministratorDetails
     *
     * @param administratorName administratorName
     * @return administratorDetails administrator details by administrator name
     */
    UserDetails getAdministratorDetails(String administratorName);


    /**
     * 获取部分用户
     *
     * @param pageInfo      @return 部分用户 list
     * @param administrator
     * @return the list
     */
    List<RetAdministrator> list(PageInfo pageInfo, RetAdministrator administrator);

    /**
     * Refresh token string.
     *
     * @param authorization the authorization
     * @return the string
     */
    String refreshToken(String authorization);

    /**
     * Gets administrator by administratorName.
     *
     * @param administratorName the administratorName
     * @return the administrator by administratorName
     */
    RetAdministrator getAdministratorByAdministratorName(String administratorName);

    /**
     * 更新用户
     *
     * @param administrator 用户参数
     */
    @Transactional
    void updateAdministrator(RetAdministrator administrator);

    /**
     * Gets administrator.
     *
     * @param administratorId the administrator id
     * @return the administrator
     */
    RetAdministrator getAdministrators(Long administratorId);

    /**
     * Delete administrator by administrator id.
     *
     * @param administratorId the administrator id
     */
    void deleteAdministratorByAdministratorId(Long administratorId);

    /**
     * Delete administrators.
     *
     * @param administrator the administrator
     */
    void deleteAdministrators(RetAdministrator administrator);

    /**
     * Gets administrator.
     *
     * @param administrator the administrator
     * @return the administrator
     */
    List<RetAdministrator> getAdministrators(RetAdministrator administrator);

    /**
     * Gets administrator resources.
     *
     * @param administratorId the administrator id
     * @return the administrator resources
     */
    List<RetResource> getAdministratorResources(Long administratorId);

    /**
     * Gets administrator by authorization.
     *
     * @param authorization the authorization
     * @return the administrator by authorization
     */
    RetAdministrator getAdministratorByAuthorization(String authorization);

    /**
     * Gets menus by authorization.
     *
     * @param authorization the authorization
     * @return the menus by authorization
     */
    List<RetMenu> getMenusByAuthorization(String authorization);
}
