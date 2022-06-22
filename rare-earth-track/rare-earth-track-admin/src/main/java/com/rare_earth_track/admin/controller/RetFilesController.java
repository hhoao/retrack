package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetFilesService;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetFiles;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Operation(summary = "分页获取文件信息")
    @GetMapping("/files")
    public CommonResult<CommonResult<List<RetFiles>>> list(PageInfo pageInfo) {
       CommonResult<List<RetFiles>> filesList = filesService.getFileList(pageInfo);
        return CommonResult.success(filesList);
    }

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

    @Operation(summary = "根据id删除文件信息")
    @DeleteMapping("/files/{fileId}")
    public CommonResult<String> delete(@PathVariable("fileId") Long fileId ) {
        filesService.deleteFileById(fileId);
        return CommonResult.success(null);
    }

}
