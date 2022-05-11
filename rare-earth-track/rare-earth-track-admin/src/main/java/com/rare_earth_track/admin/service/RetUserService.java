package com.rare_earth_track.admin.service;


import com.rare_earth_track.mgb.model.RetUser;

import java.util.List;

/**
 * Created by macro on 2022/3/10
 *
 * @author hhoa
 **/
public interface RetUserService {
    /**
     * 获取所有用户
     * @return 所有用户
     */
    List<RetUser> getAllUsers();

    /**
     * 通过用户名获取用户
     * @param  name name
     * @return user-用户
     */
    RetUser getUserByName(String name);

}
