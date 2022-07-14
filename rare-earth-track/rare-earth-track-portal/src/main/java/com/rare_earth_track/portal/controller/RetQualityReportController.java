package com.rare_earth_track.portal.controller;

import com.rare_earth_track.portal.service.RetFileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName RetQualityReportController
 * @Description: 质检报告管理
 * @Author 匡龙
 * @Date 2022/6/23 11:16
 * @Version V1.0
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "质检报告管理", description = "RetQualityReportController")
public class RetQualityReportController {
    private final RetFileService fileService;

    @Operation(summary = "下载质检报告")
    @GetMapping("/files/{filesUUID}")
    public HttpServletResponse downloadReport(@PathVariable String filesUUID, HttpServletResponse response) {
        fileService.download(filesUUID, response);
        return null;
    }

}
