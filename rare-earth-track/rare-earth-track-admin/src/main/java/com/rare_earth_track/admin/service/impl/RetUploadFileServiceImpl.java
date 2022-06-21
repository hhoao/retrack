package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.properties.UploadProperties;
import com.rare_earth_track.admin.service.RetUploadFileService;
import com.rare_earth_track.admin.util.UploadUtils;
import com.rare_earth_track.common.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


/**
 * @ClassName RetUploadFileServiceImpl
 * @Description: TODO
 * @Author 匡龙
 * @Date 2022/6/21 20:17
 * @Version V1.0
 */
@Service
public class RetUploadFileServiceImpl implements RetUploadFileService {

    @Autowired
    private UploadProperties uploadProperties;

    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        System.out.println(uploadProperties.getAllowTypes());
        System.out.println(file.getContentType());
        if(!uploadProperties.getAllowTypes().contains(file.getContentType())){
            throw new ApiException("文件上传类型错误！");
        }
        String fileName = UploadUtils.generateFileName(file.getOriginalFilename());
        file.transferTo(new File(uploadProperties.getPath()+fileName));
        return fileName;

    }
}
