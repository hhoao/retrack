package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetHelpParam;
import com.rare_earth_track.admin.service.RetHelpService;
import com.rare_earth_track.mgb.model.RetHelp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RetHelpServiceImpl
 * @Description: 用户帮助Service接口实现类
 * @Author 匡龙
 * @Date 2022/6/24 15:01
 * @Version V1.0
 */
@Service
@RequiredArgsConstructor
public class RetHelpServiceImpl implements RetHelpService {


    @Override
    public List<RetHelp> list(PageInfo pageInfo) {
        return null;
    }

    @Override
    public void addHelp(RetHelpParam helpParam) {

    }

    @Override
    public void updateHelp(String helpName, RetHelpParam helpParam) {

    }

    @Override
    public void deleteHelp(RetHelp help) {

    }
}
