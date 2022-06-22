package com.rare_earth_track.mgb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rare_earth_track.mgb.model.RetFiles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @ClassName RetFilesMapper
 * @Description: 文件的Mapper接口
 * @Author 匡龙
 * @Date 2022/6/22 14:38
 * @Version V1.0
 */
@Mapper
public interface RetFilesMapper extends BaseMapper<RetFiles> {
    /**
     * 获取文件列表
     *
     * @return {@link List}<{@link RetFiles}>
     */
    List<RetFiles> selectFileList();

    /**
     * 判断文件是否已存在
     *
     * @param filesName 文件名称
     * @return boolean
     */
    boolean fileIsExist(@Param("filesName") String filesName);
}
