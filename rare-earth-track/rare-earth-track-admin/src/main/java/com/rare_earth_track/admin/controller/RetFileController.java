package com.rare_earth_track.admin.controller;


import com.rare_earth_track.admin.service.RetUploadFileService;
import com.rare_earth_track.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName RetFileController
 * @Description: 文件管理
 * @Author 匡龙
 * @Date 2022/6/21 19:35
 * @Version V1.0
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "文件管理", description = "RetFileController")
public class RetFileController {

    @Autowired
    private final RetUploadFileService uploadFileService;

    @Operation(summary = "文件上传")
    @PostMapping("/upload/file")
    public CommonResult<String> uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
        return CommonResult.success(uploadFileService.uploadFile(file));
    }

}
