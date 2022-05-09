package com.demo.rare_earth_track.service;


import com.demo.rare_earth_track.bean.User;

import java.util.List;

/**
 * Created by macro on 2022/3/10
 *
 * @author hhoa
 **/
public interface UserService {
    /**
     * 获取所有用户
     * @return 所有用户
     */
    List<User> getAllUsers();

    /**
     * 增加用户
     * @param user 用户
     */
    void addUser(User user);

    /**
     * 通过用户名获取用户
     * @param  name name
     * @return user-用户
     */
    User getUserByName(String name);

}
