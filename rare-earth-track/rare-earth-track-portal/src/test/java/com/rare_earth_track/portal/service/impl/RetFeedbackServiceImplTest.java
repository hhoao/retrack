package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFeedbackParam;
import com.rare_earth_track.mgb.model.RetFeedback;
import com.rare_earth_track.portal.TransactionTest;
import com.rare_earth_track.portal.service.RetFeedbackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName RetFeedbackServiceImplTest
 * @Description: TODO
 * @Author 匡龙
 * @Date 2022/7/4 8:56
 * @Version V1.0
 */
public class RetFeedbackServiceImplTest extends TransactionTest {

    @Autowired
    RetFeedbackService feedbackService;

    private final String title = "反馈测试";
    private final Long testId = 1L;

    @Test
    void list() {
        List<RetFeedback> list = feedbackService.list(new PageInfo(1, 5));
        Assertions.assertTrue(list.size() <= 5);
    }

    @Test
    void addFeedback() {
        RetFeedbackParam feedbackParam = new RetFeedbackParam();
        feedbackParam.setFeedbackCategoryId(1);
        feedbackParam.setTitle(title);
        feedbackParam.setType("类型");
        feedbackParam.setContent("内容");
        feedbackService.addFeedback(feedbackParam);
    }

    @Test
    void getFeedbacks() {
        RetFeedback feedback = new RetFeedback();
        List<RetFeedback> feedbacks = feedbackService.getFeedbacks(feedback);
        Assertions.assertNotNull(feedbacks);
    }

    @Test
    void updateFeedback() {
        RetFeedbackParam feedbackParam = new RetFeedbackParam();
        feedbackService.updateFeedback(title, feedbackParam);
    }

    @Test
    void getFeedbackByTitle() {
        RetFeedback feedbackByTitle = feedbackService.getFeedbackByTitle(title);
        Assertions.assertNotNull(feedbackByTitle);
    }

    @Test
    void getFeedbackByCategoryId() {
        RetFeedback feedbackByCategoryId = feedbackService.getFeedbackByCategoryId(testId);
        Assertions.assertNotNull(feedbackByCategoryId);
    }

    @Test
    void deleteFeedbackByTitle() {
        int i = feedbackService.deleteFeedbackByTitle(title);
        Assertions.assertNotNull(i);
    }

    @Test
    void deleteFeedback() {
        RetFeedback feedback = new RetFeedback();
        feedbackService.deleteFeedback(feedback);
    }

}
