package com.rare_earth_track.portal.service;

import com.rare_earth_track.admin.bean.RetFeedbackParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName RetFeedbackService
 * @Description: 反馈Service
 * @Author 匡龙
 * @Date 2022/6/20 17:07
 * @Version V1.0
 */
public interface RetFeedbackService {

    /**
     * 添加反馈
     * @param feedbackParam
     */
    @Transactional
    void addFeedback(RetFeedbackParam feedbackParam);

}
