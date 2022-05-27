package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.service.RetMemberJobPermissionRelationService;
import com.rare_earth_track.admin.service.RetMemberJobService;
import com.rare_earth_track.mgb.mapper.RetMemberJobMapper;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetMemberJobExample;
import com.rare_earth_track.mgb.model.RetPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/25
 **/

@RequiredArgsConstructor
@Service
public class RetMemberJobServiceImpl implements RetMemberJobService {
    private final RetMemberJobMapper memberJobMapper;
    private final RetMemberJobPermissionRelationService memberJobPermissionRelationService;
    @Override
    public List<RetMemberJob> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return memberJobMapper.selectByExample(new RetMemberJobExample());
    }

    @Override
    public List<RetPermission> listJobPermissions(Integer pageNum, Integer pageSize, Long jobId) {
        PageHelper.startPage(pageNum, pageSize);
        return memberJobPermissionRelationService.getJobPermissions(jobId);
    }

    @Override
    public void addJobPermission(Long jobId, Long permissionId) {
        memberJobPermissionRelationService.addJobPermission(jobId, permissionId);
    }

    @Override
    public void deleteJobPermission(Long jobId, Long permissionId) {
        memberJobPermissionRelationService.deleteJobPermission(jobId, permissionId);
    }
}
