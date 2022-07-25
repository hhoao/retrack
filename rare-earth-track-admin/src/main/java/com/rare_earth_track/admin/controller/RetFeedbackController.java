package com.rare_earth_track.admin.controller;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFeedbackParam;
import com.rare_earth_track.admin.service.RetFeedbackService;
import com.rare_earth_track.common.api.CommonPage;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.mgb.model.RetFeedback;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName RetFeedbackController
 * @Description: 后台反馈信息管理
 * @Author 匡龙
 * @Date 2022/6/20 14:44
 * @Version V1.0
 */
@AllArgsConstructor
@Tag(name = "后台反馈信息管理")
@RestController
public class RetFeedbackController {

    private final RetFeedbackService feedbackService;

    @Operation(summary = "根据条件查询反馈信息")
    @GetMapping("/feedbacks")
    public CommonResult<CommonPage<RetFeedback>> getFeedback(RetFeedback feedback, PageInfo pageInfo) {
        List<RetFeedback> feedbacks = feedbackService.getFeedbacks(feedback, pageInfo);
        return CommonResult.success(CommonPage.restPage(feedbacks));
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
