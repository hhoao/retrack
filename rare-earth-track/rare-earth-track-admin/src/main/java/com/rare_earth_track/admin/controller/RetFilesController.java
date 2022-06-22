package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.service.RetFilesService;
import com.rare_earth_track.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName RetFilesController
 * @Description: 文件管理
 * @Author 匡龙
 * @Date 2022/6/22 15:23
 * @Version V1.0
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "文件管理", description = "RetFilesController")
public class RetFilesController {

    private final RetFilesService filesService;

    @Operation(summary = "上传文件")
    @PostMapping("/files/upload")
    public CommonResult<String> upload(MultipartFile file) {
        String url = filesService.upload(file);
        return CommonResult.success(url);
    }

    @Operation(summary = "下载文件")
    @GetMapping("/files/{filesUUID}")
    public CommonResult<String> download(@PathVariable String filesUUID, HttpServletResponse response) {
        filesService.download(filesUUID, response);
        return CommonResult.success(null);
    }

}
