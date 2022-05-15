package com.rare_earth_track.admin.service.impl;


import com.rare_earth_track.admin.service.*;
import com.rare_earth_track.mgb.mapper.RetResourceMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetResourceExample;
import com.rare_earth_track.mgb.model.RetRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/5
 **/
@Service
@AllArgsConstructor
public class RetResourceServiceImpl implements RetResourceService {
    private RetResourceMapper resourceMapper;
    private RetResourceRoleRelationService retResourceRoleRelationService;
    private RetUserRoleRelationService retUserRoleRelationService;

    @Override
    public List<RetResource> getAllResources() {
        return resourceMapper.selectByExample(new RetResourceExample());
    }

    @Override
    public RetResource getResourceByResourceId(Long resourceId) {
        return resourceMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    public List<RetResource> getResourcesByUserId(Long id) {
        RetRole role = retUserRoleRelationService.getRoleByUserId(id);
        if (role != null){
            return retResourceRoleRelationService.getResourcesByRoleId(role.getId());
        }
        return null;
    }
}
