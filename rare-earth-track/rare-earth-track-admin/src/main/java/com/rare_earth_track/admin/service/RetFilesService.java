package com.rare_earth_track.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rare_earth_track.mgb.model.RetFiles;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * @ClassName RetFilesService
 * @Description: 文件的服务接口
 * @Author 匡龙
 * @Date 2022/6/22 14:41
 * @Version V1.0
 */
public interface RetFilesService extends IService<RetFiles> {

    //上传文件
    String upload(MultipartFile file);

    //下载文件
    void download(String filesUUID, HttpServletResponse response);

}
