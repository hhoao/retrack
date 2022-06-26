package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetHelpParam;
import com.rare_earth_track.admin.service.RetHelpService;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetHelpMapper;
import com.rare_earth_track.mgb.model.RetHelp;
import com.rare_earth_track.mgb.model.RetHelpExample;
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

    private final RetHelpMapper helpMapper;

    @Override
    public List<RetHelp> list(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetHelpExample helpExample = new RetHelpExample();
        return helpMapper.selectByExample(helpExample);
    }

    @Override
    public void addHelp(RetHelpParam helpParam) {
        RetHelp help = new RetHelp();
        BeanUtil.copyProperties(helpParam, help);
        int insert = helpMapper.insert(help);
        if (insert == 0) {
            Asserts.fail("新增帮助信息失败");
        }
    }

    @Override
    public void updateHelp(String helpName, RetHelpParam helpParam) {
        RetHelp helpByHelpName = getHelpByHelpName(helpName);
        RetHelp newHelp = new RetHelp();
        BeanUtil.copyProperties(helpParam, newHelp);
        newHelp.setHelpCategoryId(helpByHelpName.getHelpCategoryId());
        newHelp.setId(helpByHelpName.getId());
        int i = helpMapper.updateByPrimaryKeySelective(newHelp);
        if (i == 0) {
            Asserts.fail("更新帮助信息失败");
        }
    }

    @Override
    public void deleteHelp(RetHelp help) {

    }

    @Override
    public RetHelp getHelpByHelpName(String helpName) {
        RetHelpExample helpExample = new RetHelpExample();
        helpExample.createCriteria().andNameEqualTo(helpName);
        List<RetHelp> retHelps = helpMapper.selectByExample(helpExample);
        if (retHelps != null && retHelps.size() > 0) {
            return retHelps.get(0);
        }else if(retHelps.size() == 0) {
            Asserts.fail("没有该帮助信息");
        }
        return null;
    }
}
