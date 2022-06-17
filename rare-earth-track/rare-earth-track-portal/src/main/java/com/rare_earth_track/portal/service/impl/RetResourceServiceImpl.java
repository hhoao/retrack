package com.rare_earth_track.portal.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetResourceParam;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetResourceMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetResourceExample;
import com.rare_earth_track.mgb.model.RetRole;
import com.rare_earth_track.portal.service.RetResourceService;
import com.rare_earth_track.portal.service.RetRoleResourceRelationService;
import com.rare_earth_track.portal.service.RetRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/5
 **/
@Service
@RequiredArgsConstructor
public class RetResourceServiceImpl implements RetResourceService {
    private final RetResourceMapper resourceMapper;
    private RetRoleResourceRelationService roleResourceRelationService;
    private RetRoleService roleService;

    @Autowired
    @Lazy
    public void setRoleResourceRelationService(RetRoleResourceRelationService roleResourceRelationService) {
        this.roleResourceRelationService = roleResourceRelationService;
    }

    @Autowired
    @Lazy
    public void setRoleService(RetRoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RetResource getResource(String resourceName) {
        RetResourceExample resourceExample = new RetResourceExample();
        resourceExample.createCriteria().andNameEqualTo(resourceName);
        List<RetResource> resources = resourceMapper.selectByExample(resourceExample);
        if (resources != null && resources.size() > 0){
            return resources.get(0);
        }
        return null;
    }

    @Override
    public List<RetResource> getAllResources() {
        return resourceMapper.selectByExample(new RetResourceExample());
    }

    @Override
    public List<RetResource> list(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return getAllResources();
    }

    @Override
    public RetResource getResource(Long resourceId) {
        RetResource retResource = resourceMapper.selectByPrimaryKey(resourceId);
        if (retResource == null){
            Asserts.fail("没有该资源");
        }
        return retResource;
    }

    @Override
    public void addResource(RetResourceParam resourceParam) {
        RetResource resource = new RetResource();
        BeanUtil.copyProperties(resourceParam, resource);
        int insert = resourceMapper.insert(resource);
        if (insert == 0){
            Asserts.fail("插入资源失败");
        }
    }

    @Override
    public void updateResource(String resourceName, RetResourceParam resourceParam) {
        RetResource resourceByName = getResource(resourceName);
        //获取影响的角色
        List<RetRole> rolesByResourceId = roleResourceRelationService.getRoles(resourceByName.getId());
        BeanUtils.copyProperties(resourceParam, resourceByName);
        int successCount = resourceMapper.updateByPrimaryKeySelective(resourceByName);
        if (successCount == 0){
            Asserts.fail("更新失败");
        }
        //刷新缓存
        for (RetRole role : rolesByResourceId){
            roleService.refreshCache(role);
        }
    }
    @Override
    public void deleteResource(Long resourceId) {
        //获取影响的角色
        List<RetRole> roles = roleResourceRelationService.getRoles(resourceId);

        roleResourceRelationService.deleteRoleResource(resourceId);
        int i = resourceMapper.deleteByPrimaryKey(resourceId);
        if (i == 0){
            Asserts.fail("删除资源失败");
        }
        //刷新缓存
        for (RetRole role : roles){
            roleService.refreshCache(role);
        }
    }

    @Override
    public void deleteResource(String resourceName) {
        //获取影响的角色
        List<RetRole> roles = roleResourceRelationService.getRoles(resourceName);
        RetResource resource = getResource(resourceName);
        roleResourceRelationService.deleteRoleResource(resource.getId());
        int i = resourceMapper.deleteByPrimaryKey(resource.getId());
        if (i == 0){
            Asserts.fail("删除资源失败");
        }
        //刷新缓存
        for (RetRole role : roles){
            roleService.refreshCache(role);
        }
    }
}
