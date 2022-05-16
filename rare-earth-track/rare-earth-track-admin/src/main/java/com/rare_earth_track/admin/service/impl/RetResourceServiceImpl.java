package com.rare_earth_track.admin.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.RetResourceParam;
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
    private RetResourceRoleRelationService resourceRoleRelationService;
    private RetUserRoleRelationService userRoleRelationService;

    @Override
    public List<RetResource> getAllResources() {
        return resourceMapper.selectByExample(new RetResourceExample());
    }

    @Override
    public List<RetResource> list(Integer from, Integer size) {
        PageHelper.startPage(from, size);
        return getAllResources();
    }

    @Override
    public RetResource getResourceByResourceId(Long resourceId) {
        return resourceMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    public List<RetResource> getResourcesByUserId(Long id) {
        RetRole role = userRoleRelationService.getRoleByUserId(id);
        if (role != null){
            return resourceRoleRelationService.getResourcesByRoleId(role.getId());
        }
        return null;
    }

    @Override
    public int addResource(RetResourceParam resourceParam) {
        RetResource resource = new RetResource();
        BeanUtil.copyProperties(resource, resourceParam);
        return resourceMapper.insert(resource);
    }
}
