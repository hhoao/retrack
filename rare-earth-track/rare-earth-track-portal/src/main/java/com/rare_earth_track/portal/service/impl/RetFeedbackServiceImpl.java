package com.rare_earth_track.portal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetFeedbackParam;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetFeedbackMapper;
import com.rare_earth_track.mgb.model.RetFeedback;
import com.rare_earth_track.mgb.model.RetFeedbackExample;
import com.rare_earth_track.portal.service.RetFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ClassName RetFeedbackServiceImpl
 * @Description: 反馈Service
 * @Author 匡龙
 * @Date 2022/6/20 17:07
 * @Version V1.0
 */
@Service
@RequiredArgsConstructor
public class RetFeedbackServiceImpl implements RetFeedbackService {

    private final RetFeedbackMapper feedbackMapper;

    @Override
    public List<RetFeedback> list(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetFeedbackExample feedbackExample = new RetFeedbackExample();
        return feedbackMapper.selectByExample(feedbackExample);
    }

    @Override
    public List<RetFeedback> getFeedbacks(RetFeedback feedback) {
        RetFeedbackExample feedbackExample = getFeedbackExample(feedback);
        return feedbackMapper.selectByExample(feedbackExample);
    }

    @Override
    public Long addFeedback(RetFeedbackParam feedbackParam) {
        RetFeedback feedback = new RetFeedback();
        BeanUtil.copyProperties(feedbackParam, feedback);
        int insert = feedbackMapper.insert(feedback);
        if (insert == 0) {
            Asserts.fail("添加反馈失败");
        }
        return feedback.getId();
    }

    @Override
    public void updateFeedback(String title, RetFeedbackParam feedbackParam) {
        RetFeedback feedbackByTitle = getFeedbackByTitle(title);
        RetFeedback newFeedback = new RetFeedback();
        BeanUtil.copyProperties(feedbackParam, newFeedback);
        newFeedback.setId(feedbackByTitle.getId());
        newFeedback.setFeedbackCategoryId(feedbackByTitle.getFeedbackCategoryId());
        int i = feedbackMapper.updateByPrimaryKeySelective(newFeedback);
        if (i == 0) {
            Asserts.fail("更新反馈信息失败");
        }
    }

    @Override
    public RetFeedback getFeedbackByTitle(String title) {
        RetFeedbackExample feedbackExample = new RetFeedbackExample();
        feedbackExample.createCriteria().andTitleEqualTo(title);
        List<RetFeedback> feedback = feedbackMapper.selectByExample(feedbackExample);
        if (feedback != null && feedback.size() > 0) {
            return feedback.get(0);
        }else if (feedback.size() == 0) {
            Asserts.fail("没有该反馈信息");
        }
        return null;
    }

    @Override
    public RetFeedback getFeedbackByCategoryId(Long feedbackCategoryId) {
        RetFeedbackExample feedbackExample = new RetFeedbackExample();
        feedbackExample.createCriteria().andFeedbackCategoryIdEqualTo(feedbackCategoryId);
        List<RetFeedback> feedbacks = feedbackMapper.selectByExample(feedbackExample);
        if (feedbacks != null && feedbacks.size() > 0) {
            return feedbacks.get(0);
        }else if (feedbacks.size() == 0) {
            Asserts.fail("没有该反馈信息");
        }
        return null;
    }

    @Override
    public int deleteFeedbackByTitle(String title) {
        RetFeedback feedbackByTitle = getFeedbackByTitle(title);
        int i = feedbackMapper.deleteByPrimaryKey(feedbackByTitle.getId());
        if (i == 0) {
            Asserts.fail("删除失败");
        }
        return i;
    }

    private RetFeedbackExample getFeedbackExample(RetFeedback feedback) {
        RetFeedbackExample feedbackExample = new RetFeedbackExample();
        RetFeedbackExample.Criteria criteria = feedbackExample.createCriteria();
        if (feedback.getId() != null) {
            criteria.andIdEqualTo(feedback.getId());
            return feedbackExample;
        }
        if (feedback.getFeedbackCategoryId() != null) {
            criteria.andFeedbackCategoryIdEqualTo(feedback.getFeedbackCategoryId());
        }
        if (feedback.getTitle() != null) {
            criteria.andTitleEqualTo(feedback.getTitle());
        }
        if (feedback.getType() != null) {
            criteria.andTypeEqualTo(feedback.getType());
        }
        if (feedback.getContent() != null) {
           //todo 没有 andContentEqualTo() 这个方法
        }
        if (feedback.getStatus() != null) {
            criteria.andStatusEqualTo(feedback.getStatus());
        }
        if (feedback.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(feedback.getCreateTime());
        }
        if (feedback.getObject() != null) {
            criteria.andObjectEqualTo(feedback.getObject());
        }
        return feedbackExample;
    }

    @Override
    public void deleteFeedback(RetFeedback feedback) {
        RetFeedbackExample feedbackExample = getFeedbackExample(feedback);
        int i = feedbackMapper.deleteByExample(feedbackExample);
        if (i == 0) {
            Asserts.fail("删除失败");
        }
    }
}
