package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetResource;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
public interface RetResourceRoleRelationService {
    /**
     * 通过角色id获取资源
     * @param roleId 角色id
     * @return 资源
     */
    List<RetResource> getResourcesByRoleId(Long roleId);
}
