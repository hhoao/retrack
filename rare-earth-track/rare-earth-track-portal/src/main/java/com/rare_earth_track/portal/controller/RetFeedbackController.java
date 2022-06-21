package com.rare_earth_track.portal.controller;

import com.rare_earth_track.admin.bean.RetFeedbackParam;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.portal.service.RetFeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName RetFeedbackController
 * @Description: 前台反馈信息管理
 * @Author 匡龙
 * @Date 2022/6/20 14:44
 * @Version V1.0
 */
@AllArgsConstructor
@Tag(name = "前台反馈信息管理")
@RestController
public class RetFeedbackController {

    private final RetFeedbackService feedbackService;

    @Operation(summary = "添加反馈信息")
    @PostMapping("/feedbacks")
    public CommonResult<String> addFeedback(@RequestBody RetFeedbackParam feedbackParam) {
        feedbackService.addFeedback(feedbackParam);
        return CommonResult.success(null);
    }

    @Operation(summary = "删除反馈信息")
    @DeleteMapping("/feedbacks/{title}")
    public CommonResult<String> deleteFeedback(@PathVariable(value = "title") String title) {
        feedbackService.deleteFeedbackByTitle(title);
        return CommonResult.success(null);
    }

    @Operation(summary = "更新反馈信息")
    @PatchMapping("/feedbacks/{title}")
    public CommonResult<String> updateFeedback(@PathVariable("title") String title,
                                               @RequestBody RetFeedbackParam feedbackParam) {
        feedbackService.updateFeedback(title, feedbackParam);
        return CommonResult.success(null);
    }

}
