package com.rare_earth_track.mgb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件
 * @author 匡龙 
 * @date 2022-07-07
 */
@Schema(description = "文件")
public class RetFiles implements Serializable {
    @Schema(description = "文件id")
    private Integer id;

    @Schema(description = "文件名称")
    private String filesName;

    @Schema(description = "文件类型")
    private String type;

    @Schema(description = "文件大小（KB）")
    private Double size;

    @Schema(description = "下载链接")
    private String url;

    @Schema(description = "文件md5")
    private String md5;

    @Schema(description = "链接是否可用（1：是 0：否）")
    private Byte enable;

    @Schema(description = "是否删除（1：是 0：否）")
    private Byte isDelete;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 文件id
     * @return id 文件id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 文件id
     * @param id 文件id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 文件名称
     * @return files_name 文件名称
     */
    public String getFilesName() {
        return filesName;
    }

    /**
     * 文件名称
     * @param filesName 文件名称
     */
    public void setFilesName(String filesName) {
        this.filesName = filesName;
    }

    /**
     * 文件类型
     * @return type 文件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 文件类型
     * @param type 文件类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 文件大小（KB）
     * @return size 文件大小（KB）
     */
    public Double getSize() {
        return size;
    }

    /**
     * 文件大小（KB）
     * @param size 文件大小（KB）
     */
    public void setSize(Double size) {
        this.size = size;
    }

    /**
     * 下载链接
     * @return url 下载链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 下载链接
     * @param url 下载链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 文件md5
     * @return md5 文件md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * 文件md5
     * @param md5 文件md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * 链接是否可用（1：是 0：否）
     * @return enable 链接是否可用（1：是 0：否）
     */
    public Byte getEnable() {
        return enable;
    }

    /**
     * 链接是否可用（1：是 0：否）
     * @param enable 链接是否可用（1：是 0：否）
     */
    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    /**
     * 是否删除（1：是 0：否）
     * @return is_delete 是否删除（1：是 0：否）
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除（1：是 0：否）
     * @param isDelete 是否删除（1：是 0：否）
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        sb.append(", filesName=").append(filesName);
        sb.append(", type=").append(type);
        sb.append(", size=").append(size);
        sb.append(", url=").append(url);
        sb.append(", md5=").append(md5);
        sb.append(", enable=").append(enable);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}