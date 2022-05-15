package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.mgb.mapper.RetRoleMapper;
import com.rare_earth_track.mgb.model.RetRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/5/15
 **/
@Service
@RequiredArgsConstructor
public class RetRoleServiceImpl implements RetRoleService {
    private final RetRoleMapper roleMapper;

    @Override
    public RetRole getRoleByRoleId(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
