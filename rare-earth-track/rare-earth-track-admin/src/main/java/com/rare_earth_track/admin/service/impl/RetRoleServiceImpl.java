package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.RetRoleParam;
import com.rare_earth_track.admin.service.RetRoleResourceRelationService;
import com.rare_earth_track.admin.service.RetRoleService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetRoleMapper;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetRole;
import com.rare_earth_track.mgb.model.RetRoleExample;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    private final RetRoleResourceRelationService roleResourceRelationService;

    @Override
    public void updateRole(RetRoleParam roleParam) {
        RetRole role = new RetRole();
        BeanUtils.copyProperties(roleParam, role);
        int i = roleMapper.updateByPrimaryKey(role);
        if (i == 0){
            Asserts.fail("修改角色失败");
        }
    }
    @Override
    public List<RetResource> getRoleResources(Long roleId){
        return roleResourceRelationService.getRoleResources(roleId);
    }
    @Override
    public RetRole getRoleByRoleId(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public void addRole(RetRoleParam roleParam) {
        RetRole role = new RetRole();
        BeanUtil.copyProperties(roleParam, role);
        int insert = roleMapper.insert(role);
        if (insert == 0){
            Asserts.fail("插入角色失败");
        }
    }

    @Override
    public List<RetRole> getAllRoles() {
        return roleMapper.selectByExample(new RetRoleExample());
    }

    @Override
    public List<RetRole> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return getAllRoles();
    }

    @Override
    public void deleteRole(Long id) {
        roleResourceRelationService.deleteRole(id);
        int i = roleMapper.deleteByPrimaryKey(id);
        if (i == 0){
            Asserts.fail("删除角色失败");
        }
    }
}
