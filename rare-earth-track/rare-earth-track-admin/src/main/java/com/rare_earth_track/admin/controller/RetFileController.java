package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetFileService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetFile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName RetFileController
 * @Description: 文件管理
 * @Author 匡龙
 * @Date 2022/6/22 15:23
 * @Version V1.0
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "文件管理", description = "RetFileController")
public class RetFileController {

    private final RetFileService filesService;

    @Operation(summary = "分页获取文件信息")
    @GetMapping("/files")
    public CommonResult<CommonPage<RetFile>> list(PageInfo pageInfo, RetFile file) {
        List<RetFile> filesList = filesService.getFileList(pageInfo, file);
        return CommonResult.success(CommonPage.restPage(filesList));
    }

    @Operation(summary = "上传文件")
    @PostMapping("/files/upload")
    @RequestBody(content = {
            @Content(
                    mediaType = "multipart/form-data",
                    schema = @Schema(type = "object"),
                    schemaProperties = {
                            @SchemaProperty(
                                    name = "file",
                                    schema = @Schema(
                                            type = "string",
                                            format = "binary"
                                    )
                            )
                    })
    })
    public CommonResult<String> upload(MultipartFile file) {
        String url = filesService.upload(file);
        return CommonResult.success(url);
    }

    @Operation(summary = "下载文件")
    @GetMapping("/files/{filesUUID}")
    public HttpServletResponse download(@PathVariable String filesUUID, HttpServletResponse response) {
        filesService.download(filesUUID, response);
        return null;
    }

    @Operation(summary = "根据id删除文件信息")
    @DeleteMapping("/files/{fileId}")
    public CommonResult<String> delete(@PathVariable("fileId") Long fileId) {
        filesService.deleteFileById(fileId);
        return CommonResult.success(null);
    }

}
