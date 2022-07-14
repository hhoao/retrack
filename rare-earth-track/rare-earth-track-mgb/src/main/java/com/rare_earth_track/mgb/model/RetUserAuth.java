package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 用户授权信息
 * @author hhoa 
 * @date 2022-07-14
 */
@Schema(description = "用户授权信息")
public class RetUserAuth implements Serializable {
    private Long id;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "类型")
    private String identityType;

    @Schema(description = "标识")
    private String identifier;

    @Schema(description = "凭证")
    private String credential;

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
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 类型
     * @return identity_type 类型
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * 类型
     * @param identityType 类型
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    /**
     * 标识
     * @return identifier 标识
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * 标识
     * @param identifier 标识
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * 凭证
     * @return credential 凭证
     */
    public String getCredential() {
        return credential;
    }

    /**
     * 凭证
     * @param credential 凭证
     */
    public void setCredential(String credential) {
        this.credential = credential;
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
        sb.append(", userId=").append(userId);
        sb.append(", identityType=").append(identityType);
        sb.append(", identifier=").append(identifier);
        sb.append(", credential=").append(credential);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}