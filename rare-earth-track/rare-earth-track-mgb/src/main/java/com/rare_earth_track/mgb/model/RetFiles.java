package com.rare_earth_track.mgb.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName RetFiles
 * @Description: 文件实体类
 * @Author 匡龙
 * @Date 2022/6/22 14:36
 * @Version V1.0
 */
@Data
@TableName("ret_files")
public class RetFiles implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;//编号

    private String filesName;//文件名称

    private String type;//文件类型

    private Double size;//文件大小

    private String url;//下载链接

    private String md5;//文件MD5

    private Boolean enable;//链接是否可用（1：是 0：否）

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;//更新时间

    @TableLogic()
    private Integer isDelete;//是否删除（1：是 0：否）

}
