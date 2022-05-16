package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.RetResourceRoleRelationParam;
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

    /**
     * 添加关系
     * @param roleResourceRelationParam 关系参数
     * @return 插入成功数量
     */
    int addResourceRoleRelation(RetResourceRoleRelationParam roleResourceRelationParam);
}
