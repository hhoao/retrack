package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 职位资源关系
 * @author hhoa 
 * @date 2022-05-16
 */
@Schema(name = "职位资源关系")
public class RetMemberJobResourceRelation implements Serializable {
    private Long id;

    private Long memberJobId;

    private Long resourceId;

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return member_job_id 
     */
    public Long getMemberJobId() {
        return memberJobId;
    }

    /**
     * 
     * @param memberJobId 
     */
    public void setMemberJobId(Long memberJobId) {
        this.memberJobId = memberJobId;
    }

    /**
     * 
     * @return resource_id 
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * 
     * @param resourceId 
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * toString
     * @return java.lang.String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberJobId=").append(memberJobId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}