package com.rare_earth_track.admin.service.impl;


import com.rare_earth_track.admin.dao.RetRoleResourceRelationDao;
import com.rare_earth_track.admin.service.RetResourceCacheService;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.mgb.mapper.RetResourceMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetResourceExample;
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
    private RetResourceMapper retResourceMapper;
    private RetResourceCacheService retResourceCacheService;
    private RetRoleResourceRelationDao retRoleResourceRelationDao;

    @Override
    public List<RetResource> getAllResources() {
        return retResourceMapper.selectByExample(new RetResourceExample());
    }

    @Override
    public List<RetResource> getResourcesByUserId(Long id) {
        List<RetResource> retResources = retResourceCacheService.getResourcesByUserId(id);
        if (retResources == null) {
            retResources = retRoleResourceRelationDao.getResourcesByUserId(id);
            if (retResources.size() > 0){
                retResourceCacheService.setResourcesByUserId(retResources, id);
            }
        }
        return retResources;
    }

}
