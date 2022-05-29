package com.rare_earth_track.admin.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.RetResourceParam;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.admin.service.RetRoleResourceRelationService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetResourceMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetResourceExample;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    private RetRoleResourceRelationService roleResourceRelationService;

    @Override
    public RetResource getResourceByName(String name) {
        RetResourceExample resourceExample = new RetResourceExample();
        resourceExample.createCriteria().andNameEqualTo(name);
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
    public List<RetResource> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return getAllResources();
    }

    @Override
    public RetResource getResourceByResourceId(Long resourceId) {
        return resourceMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    public void addResource(RetResourceParam resourceParam) {
        RetResource resource = new RetResource();
        BeanUtil.copyProperties(resourceParam, resource);
        int insert = resourceMapper.insert(resource);
        if (insert == 0){
            Asserts.fail("插入资源失败");
        }
        RetResource resourceByName = getResourceByName(resourceParam.getName());
        roleResourceRelationService.refreshCacheByResourceId(resourceByName.getId());
    }

    @Override
    public void updateResource(RetResourceParam resourceParam) {
        RetResource resourceByName = getResourceByName(resourceParam.getName());
        if (resourceByName == null){
            Asserts.fail("没有该资源");
        }
        BeanUtils.copyProperties(resourceParam, resourceByName);
        int successCount = resourceMapper.updateByPrimaryKey(resourceByName);
        if (successCount == 0){
            Asserts.fail("更新失败");
        }
        //刷新缓存
        roleResourceRelationService.refreshCacheByResourceId(resourceByName.getId());
    }
    @Override
    public void deleteResource(Long resourceId) {
        RetResource resource = resourceMapper.selectByPrimaryKey(resourceId);
        if (resource == null){
            Asserts.fail("没有该资源");
        }
        roleResourceRelationService.deleteResourceRoleRelation(resourceId);
        int i = resourceMapper.deleteByPrimaryKey(resourceId);
        if (i == 0){
            Asserts.fail("删除资源失败");
        }
    }
}
