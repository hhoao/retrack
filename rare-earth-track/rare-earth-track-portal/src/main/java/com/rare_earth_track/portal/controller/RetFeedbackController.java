package com.rare_earth_track.portal.controller;

import com.rare_earth_track.admin.bean.RetFeedbackParam;
import com.rare_earth_track.common.api.CommonResult;
import com.rare_earth_track.portal.service.RetFeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RetFeedbackController
 * @Description: 反馈管理
 * @Author 匡龙
 * @Date 2022/6/20 14:44
 * @Version V1.0
 */
@AllArgsConstructor
@Tag(name = "反馈管理")
@RestController
public class RetFeedbackController {

    private final RetFeedbackService feedbackService;

    @Operation(summary = "添加反馈")
    @PostMapping("/feedbacks")
    public CommonResult<String> addFeedback(@RequestBody RetFeedbackParam feedbackParam) {
        feedbackService.addFeedback(feedbackParam);
        return CommonResult.success(null);
    }

}
