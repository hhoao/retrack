package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 成员和职位关系
 * @author hhoa 
 * @date 2022-05-27
 */
@Schema(name = "成员和职位关系")
public class RetMemberJobRelation implements Serializable {
    private Long id;

    private Long memberId;

    private Long memberJobId;

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
     * @return member_id 
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 
     * @param memberId 
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
        sb.append(", memberId=").append(memberId);
        sb.append(", memberJobId=").append(memberJobId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}