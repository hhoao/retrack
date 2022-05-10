package com.demo.rare_earth_track.portal.service.impl;

import com.demo.rare_earth_track.portal.bean.RetResource;
import com.demo.rare_earth_track.portal.dao.RetResourceDao;
import com.demo.rare_earth_track.portal.service.RetResourceCacheService;
import com.demo.rare_earth_track.portal.service.RetResourceService;
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
