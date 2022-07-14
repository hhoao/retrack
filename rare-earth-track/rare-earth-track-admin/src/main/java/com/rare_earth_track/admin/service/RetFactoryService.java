package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFactoryParam;
import com.rare_earth_track.admin.bean.RetMemberParam;
import com.rare_earth_track.mgb.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The interface Ret factory service.
 *
 * @author hhoa
 * @date 2022 /5/23
 */
public interface RetFactoryService {
    /**
     * 分页获取工厂列表
     *
     * @param pageInfo @return 分页角色 list
     * @param factory
     */
    List<RetFactory> list(PageInfo pageInfo, RetFactory factory);

    /**
     * 增加工厂
     *
     * @param factoryParam the factory
     * @return long long
     */
    Long addFactory(RetFactoryParam factoryParam);

    /**
     * Update factory int.
     *
     * @param factoryName  the factory name
     * @param factoryParam the factory
     */
    @Transactional
    void updateFactory(String factoryName, RetFactoryParam factoryParam);


    /**
     * Delete factory by name int.
     *
     * @param name the name
     * @return 成功数量 int
     */
    @Transactional
    int deleteFactoryByName(String name);

    /**
     * Gets factory by factory name.
     *
     * @param name the name
     * @return the factory by factory name
     */
    RetFactory getFactoryByFactoryName(String name);

    /**
     * Gets factory by factory id.
     *
     * @param id the id
     * @return the factory by factory id
     */
    RetFactory getFactoryByFactoryId(Long id);

    /**
     * Invite user by email.
     *
     * @param factoryName  工厂id
     * @param emailOrPhone the email or phone
     */
    void inviteUserByEmail(String factoryName, String emailOrPhone);

    /**
     * Invite user by phone.
     *
     * @param factoryName  the factory id
     * @param emailOrPhone the email or phone
     */
    void inviteUserByPhone(String factoryName, String emailOrPhone);


    /**
     * Delete factory member by member id.
     *
     * @param factoryName the factory id
     * @param username    the member id
     */
    @Transactional
    void deleteFactoryMemberByUsername(String factoryName, String username);

    /**
     * Add factory member.
     *
     * @param factoryId the factory id
     * @param userId    the user id
     * @return memberId long
     */
    @Transactional
    Long addFactoryMember(Long factoryId, Long userId);

    /**
     * 处理
     *
     * @param factoryName   the factory id
     * @param authorization the token
     */
    void handleInvitation(String factoryName, String authorization);

    /**
     * Update factory member job.
     *
     * @param factoryName the factory name
     * @param username    the member id
     * @param memberParam the job
     */
    @Transactional
    void updateFactoryMember(String factoryName, String username, RetMemberParam memberParam);

    /**
     * List factory members list.
     *
     * @param pageInfo
     * @param factoryName the factory id
     * @return the list
     */
    List<RetMember> listFactoryMembers(PageInfo pageInfo, String factoryName);

    /**
     * Gets factory.
     *
     * @param factory the factory param
     * @return the factory
     */
    List<RetFactory> getFactories(RetFactory factory);

    /**
     * List products list.
     *
     * @param factoryName the factory name
     * @param product
     * @param pageInfo
     * @return the list
     */
    List<RetProduct> listProducts(String factoryName, RetProduct product, PageInfo pageInfo);
}
