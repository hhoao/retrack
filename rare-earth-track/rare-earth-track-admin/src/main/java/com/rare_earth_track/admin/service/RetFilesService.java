package com.rare_earth_track.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetFiles;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @ClassName RetFilesService
 * @Description: 文件的服务接口
 * @Author 匡龙
 * @Date 2022/6/22 14:41
 * @Version V1.0
 */
public interface RetFilesService extends IService<RetFiles> {

    /**
     * 分页获取文件信息
     * @param pageInfo
     * @return list
     */
    CommonResult<List<RetFiles>> getFileList(PageInfo pageInfo);

    /**
     * 上传文件
     * @param file
     * @return file
     */
    String upload(MultipartFile file);

    /**
     * 下载文件
     * @param filesUUID
     * @param response
     */
    void download(String filesUUID, HttpServletResponse response);

    /**
     * 删除文件信息
     * @param id
     */
    void deleteFileById(Long id);
}
