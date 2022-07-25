package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.mgb.model.RetFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * The interface Ret file service.
 *
 * @ClassName RetFileService
 * @Description: 文件的服务接口
 * @Author 匡龙
 * @Date 2022 /6/22 14:41
 * @Version V1.0
 */
public interface RetFileService {

    /**
     * 分页获取文件信息
     *
     * @param pageInfo  the page info
     * @param queryFile
     * @return list file list
     */
    List<RetFile> getFileList(PageInfo pageInfo, RetFile queryFile);

    /**
     * 上传文件
     *
     * @param file the file
     * @return file string
     */
    String upload(MultipartFile file);

    /**
     * 下载文件
     *
     * @param filesUUID the files uuid
     * @param response  the response
     */
    void download(String filesUUID, HttpServletResponse response);

    /**
     * 删除文件信息
     *
     * @param id the id
     */
    void deleteFileById(Long id);
}
