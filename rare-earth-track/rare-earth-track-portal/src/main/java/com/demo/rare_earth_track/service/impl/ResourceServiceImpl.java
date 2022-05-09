package com.demo.rare_earth_track.service.impl;

import com.demo.rare_earth_track.bean.Resource;
import com.demo.rare_earth_track.dao.ResourceDao;
import com.demo.rare_earth_track.service.ResourceCacheService;
import com.demo.rare_earth_track.service.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/5
 **/
@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService {
    private ResourceDao resourceDao;
    private ResourceCacheService resourceCacheService;

    @Override
    public List<Resource> getAllResources() {
        return resourceDao.getAllResources();
    }

    @Override
    public List<Resource> getResourcesByUserId(Integer id) {
        List<Resource> resources = resourceCacheService.getResourcesByUserId(id);
        if (resources == null) {
            resources = resourceDao.getResourcesByUserId(id);
            if (resources.size() > 0){
                resourceCacheService.setResourcesByUserId(resources, id);
            }
        }
        return resources;
    }

}
