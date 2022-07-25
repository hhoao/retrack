package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetMemberJobPermissionRelationService;
import com.rare_earth_track.admin.service.RetMemberJobService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetMemberJobMapper;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetMemberJobExample;
import com.rare_earth_track.mgb.model.RetPermission;
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

    private RetMemberJobExample getMemberJobExample(RetMemberJob memberJob){
        RetMemberJobExample memberJobExample = new RetMemberJobExample();
        if (memberJob != null){
            RetMemberJobExample.Criteria criteria = memberJobExample.createCriteria();
            if (memberJob.getId() != null){
                criteria.andIdEqualTo(memberJob.getId());
            }
            if (memberJob.getName() != null){
                criteria.andNameEqualTo(memberJob.getName());
            }
            if (memberJob.getDescription() != null){
                criteria.andDescriptionLike(memberJob.getDescription());
            }
        }
        return memberJobExample;
    }
    @Override
    public List<RetMemberJob> list(PageInfo pageInfo, RetMemberJob memberJob) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return jobMapper.selectByExample(getMemberJobExample(memberJob));
    }

    @Override
    public List<RetPermission> listJobPermissions(PageInfo pageInfo, Long jobId) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
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
