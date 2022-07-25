package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.mgb.mapper.RetPermissionMapper;
import com.rare_earth_track.mgb.model.RetPermission;
import com.rare_earth_track.mgb.model.RetPermissionExample;
import com.rare_earth_track.portal.service.RetPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/26
 **/

@Service
@RequiredArgsConstructor
public class RetPermissionServiceImpl implements RetPermissionService {
    private final RetPermissionMapper permissionMapper;
    @Override
    public List<RetPermission> getAllPermissions() {
        return permissionMapper.selectByExample(new RetPermissionExample());
    }
}
