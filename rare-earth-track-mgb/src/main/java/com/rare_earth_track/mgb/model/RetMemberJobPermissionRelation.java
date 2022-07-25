package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 职位权限关系
 * @author hhoa 
 * @date 2022-07-15
 */
@Schema(description = "职位权限关系")
public class RetMemberJobPermissionRelation implements Serializable {
    private Long id;

    private Long memberJobId;

    private Long permissionId;

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
     * @return permission_id 
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * 
     * @param permissionId 
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
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
        sb.append(", permissionId=").append(permissionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}