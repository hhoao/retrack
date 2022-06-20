package com.rare_earth_track.portal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.rare_earth_track.admin.bean.RetFeedbackParam;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetFeedbackMapper;
import com.rare_earth_track.mgb.model.RetFeedback;
import com.rare_earth_track.portal.service.RetFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @ClassName RetFeedbackServiceImpl
 * @Description: TODO
 * @Author 匡龙
 * @Date 2022/6/20 17:07
 * @Version V1.0
 */
@Service
@RequiredArgsConstructor
public class RetFeedbackServiceImpl implements RetFeedbackService {

    private final RetFeedbackMapper feedbackMapper;

    @Override
    public void addFeedback(RetFeedbackParam feedbackParam) {
        RetFeedback feedback = new RetFeedback();
        BeanUtil.copyProperties(feedbackParam, feedback);
        int insert = feedbackMapper.insert(feedback);
        if (insert == 0) {
            Asserts.fail("添加反馈失败");
        }
    }
}
