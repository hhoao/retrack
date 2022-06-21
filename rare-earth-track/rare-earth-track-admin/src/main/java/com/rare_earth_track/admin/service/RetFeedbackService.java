package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFeedbackParam;
import com.rare_earth_track.mgb.model.RetFeedback;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @ClassName RetFeedbackService
 * @Description: 反馈Service
 * @Author 匡龙
 * @Date 2022/6/20 20:17
 * @Version V1.0
 */
public interface RetFeedbackService {

    /**
     * 分页查询反馈信息
     * @param pageInfo
     * @return list
     */
    List<RetFeedback> list(PageInfo pageInfo);

    /**
     * 获取反馈信息
     * @param feedback
     * @return feedbacks
     */
    List<RetFeedback> getFeedbacks(RetFeedback feedback);

    /**
     * 添加反馈信息
     * @param feedbackParam
     */
    @Transactional
    void addFeedback(RetFeedbackParam feedbackParam);

    /**
     * 修改反馈信息
     * @param title
     * @param feedbackParam
     */
    void updateFeedback(String title, RetFeedbackParam feedbackParam);

    /**
     * 通过标题查找反馈信息
     * @param title
     * @return feedback
     */
    RetFeedback getFeedbackByTitle(String title);

    /**
     * 根据反馈分类id查询反馈信息
     * @param feedbackCategoryId
     * @return feedback
     */
    RetFeedback getFeedbackByCategoryId(Long feedbackCategoryId);

    /**
     * 根据标题删除反馈
     * @param title
     */
    @Transactional
    int deleteFeedbackByTitle(String title);

    /**
     * 删除反馈信息
     * @param feedback
     */
    void deleteFeedback(RetFeedback feedback);

}
