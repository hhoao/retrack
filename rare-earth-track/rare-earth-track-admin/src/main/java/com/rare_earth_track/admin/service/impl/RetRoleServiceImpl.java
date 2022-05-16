package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.mgb.mapper.RetRoleMapper;
import com.rare_earth_track.mgb.model.RetRole;
import com.rare_earth_track.mgb.model.RetRoleExample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int addRole(RetRoleParam roleParam) {
        RetRole role = new RetRole();
        BeanUtil.copyProperties(roleParam, role);
        return roleMapper.insert(role);
    }

    @Override
    public List<RetRole> getAllRoles() {
        return roleMapper.selectByExample(new RetRoleExample());
    }
}
