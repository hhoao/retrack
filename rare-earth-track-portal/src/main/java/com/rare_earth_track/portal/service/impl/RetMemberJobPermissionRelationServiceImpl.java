package com.rare_earth_track.portal.service.impl;


import com.rare_earth_track.mgb.mapper.RetMemberJobPermissionRelationMapper;
import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetMemberJobPermissionRelation;
import com.rare_earth_track.mgb.model.RetMemberJobPermissionRelationExample;
import com.rare_earth_track.portal.service.RetMemberJobPermissionRelationService;
import com.rare_earth_track.portal.service.RetMemberJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/27
 **/

@Service
@RequiredArgsConstructor
public class RetMemberJobPermissionRelationServiceImpl implements RetMemberJobPermissionRelationService {
    private final RetMemberJobPermissionRelationMapper memberJobPermissionRelationMapper;
    private  RetMemberJobService jobService;

    @Lazy
    @Autowired
    public void setJobService(RetMemberJobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public List<RetMemberJob> getJobs(Long permissionId) {
        RetMemberJobPermissionRelationExample memberJobPermissionRelationExample = new RetMemberJobPermissionRelationExample();
        memberJobPermissionRelationExample.createCriteria().andPermissionIdEqualTo(permissionId);
        List<RetMemberJobPermissionRelation> retMemberJobPermissionRelations = memberJobPermissionRelationMapper.selectByExample(memberJobPermissionRelationExample);
        List<RetMemberJob> memberJobs = new ArrayList<>();
        for (RetMemberJobPermissionRelation memberJobPermissionRelation : retMemberJobPermissionRelations){
            Long memberJobId = memberJobPermissionRelation.getMemberJobId();
            RetMemberJob memberJob = jobService.getJob(memberJobId);
            memberJobs.add(memberJob);
        }
        return memberJobs;
    }

}
