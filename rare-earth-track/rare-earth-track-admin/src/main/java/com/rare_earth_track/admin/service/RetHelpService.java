package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetHelpParam;
import com.rare_earth_track.mgb.model.RetHelp;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName RetHelpService
 * @Description: 用户帮助Service接口
 * @Author 匡龙
 * @Date 2022/6/24 15:01
 * @Version V1.0
 */
public interface RetHelpService {

    /**
     * 分页获取用户帮助信息
     * @param pageInfo
     * @return list
     */
    List<RetHelp> list(PageInfo pageInfo);

    /**
     * 添加用户帮助信息
     * @param helpParam
     */
    @Transactional
    void addHelp(RetHelpParam helpParam);

    /**
     * 修改用户帮助信息
     * @param helpName
     * @param helpParam
     */
    @Transactional
    void updateHelp(String helpName, RetHelpParam helpParam);

    /**
     * 删除用户帮助信息
     * @param help
     */
    void deleteHelp(RetHelp help);

}