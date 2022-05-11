package com.rare_earth_track.admin.service.impl;


import com.rare_earth_track.admin.service.RetResourceCacheService;
import com.rare_earth_track.admin.service.RetResourceService;
import com.rare_earth_track.mgb.dao.RetResourceDao;
import com.rare_earth_track.mgb.model.RetResource;
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
    private RetResourceDao retResourceDao;
    private RetResourceCacheService retResourceCacheService;

    @Override
    public List<RetResource> getAllResources() {
        return retResourceDao.getAllResources();
    }

    @Override
    public List<RetResource> getResourcesByUserId(Integer id) {
        List<RetResource> retResources = retResourceCacheService.getResourcesByUserId(id);
        if (retResources == null) {
            retResources = retResourceDao.getResourcesByUserId(id);
            if (retResources.size() > 0){
                retResourceCacheService.setResourcesByUserId(retResources, id);
            }
        }
        return retResources;
    }

}
