package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetMember;

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
     * @param pageNum the pageNum
     * @param pageSize the pageSize
     * @return 分页角色 list
     */
    List<RetFactory> list(Integer pageNum, Integer pageSize);

    /**
     * 增加工厂
     *
     * @param factory the factory
     */
    void addFactory(RetFactory factory);

    /**
     * Update factory int.
     *
     * @param factory the factory
     */
    void updateFactory(RetFactory factory);

    /**
     * Delete factory by factory id int.
     *
     * @param id the id
     */
    void deleteFactoryByFactoryId(Long id);

    /**
     * Delete factory by name int.
     *
     * @param name the name
     * @return 成功数量 int
     */
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
     * @param factoryId    工厂id
     * @param emailOrPhone the email or phone
     */
    void inviteUserByEmail(Long factoryId, String emailOrPhone);

    /**
     * Invite user by phone.
     *
     * @param factoryId    the factory id
     * @param emailOrPhone the email or phone
     */
    void inviteUserByPhone(Long factoryId, String emailOrPhone);


    /**
     * Delete factory member by member id.
     *
     * @param memberId the member id
     */
    void deleteFactoryMemberByMemberId(Long memberId);

    /**
     * Add factory member.
     *
     * @param factoryId the factory id
     * @param userId    the user id
     */
    void addFactoryMember(Long factoryId, Long userId);

    /**
     * 处理
     *
     * @param factoryId the factory id
     * @param token     the token
     */
    void handleInvitation(Long factoryId, String token);

    /**
     * Update factory member job.
     *
     * @param memberId the member id
     * @param job      the job
     */
    void updateFactoryMemberJob(Long memberId, Long job);

    /**
     * List factory members list.
     *
     * @param from      the from
     * @param size      the size
     * @param factoryId the factory id
     * @return the list
     */
    List<RetMember> listFactoryMembers(Integer from, Integer size, Long factoryId);
}
