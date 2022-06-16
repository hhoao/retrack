package com.rare_earth_track.portal.service.impl;

import com.github.pagehelper.PageHelper;

import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMemberJobMapper;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetMemberJobExample;
import com.rare_earth_track.mgb.model.RetPermission;
import com.rare_earth_track.portal.service.RetMemberJobPermissionRelationService;
import com.rare_earth_track.portal.service.RetMemberJobService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/25
 **/

@Service
public class RetMemberJobServiceImpl implements RetMemberJobService {
    private final RetMemberJobMapper jobMapper;
    private final RetMemberJobPermissionRelationService memberJobPermissionRelationService;

    @Lazy
    public RetMemberJobServiceImpl(RetMemberJobMapper jobMapper, RetMemberJobPermissionRelationService memberJobPermissionRelationService) {
        this.jobMapper = jobMapper;
        this.memberJobPermissionRelationService = memberJobPermissionRelationService;
    }

    @Override
    public List<RetMemberJob> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return jobMapper.selectByExample(new RetMemberJobExample());
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


    @Override
    public void addJobPermission(String jobName, String permissionName) {
        memberJobPermissionRelationService.addJobPermission(jobName, permissionName);
    }

    @Override
    public RetMemberJob getJob(String jobName){
        RetMemberJobExample jobExample = new RetMemberJobExample();
        jobExample.createCriteria().andNameEqualTo(jobName);
        List<RetMemberJob> retMemberJobs = jobMapper.selectByExample(jobExample);
        if (retMemberJobs.size() == 0){
            Asserts.fail("没有该职位");
        }
        return retMemberJobs.get(0);
    }
    @Override
    public void deleteJobPermission(String jobName, String permissionName) {
        memberJobPermissionRelationService.deleteJobPermission(jobName, permissionName);
    }

    @Override
    public RetMemberJob getJob(Long memberJobId) {
        RetMemberJob memberJob = jobMapper.selectByPrimaryKey(memberJobId);
        if (memberJob == null){
            Asserts.fail("没有该成员");
        }
        return memberJob;
    }
}
