package com.rare_earth_track.admin.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName RetUploadFileService
 * @Description: 上传文件接口
 * @Author 匡龙
 * @Date 2022/6/21 20:16
 * @Version V1.0
 */
public interface RetUploadFileService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file) throws Exception;
}
