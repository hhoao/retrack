package com.demo.rare_earth_track.dao;

import com.demo.rare_earth_track.bean.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by macro on 2022/3/10
 *
 * @author hhoa
 **/
public interface UserDao {
    /**
     *获取所有用户
     * @return 所有用户
     */
    List<User> getAllUsers();

    /**
     * 增加用户
     * @param user 用户
     */
    void addUser(@Param("user") User user);
    /**
     * 通过用户名获取用户
     * @return user-用户
     * @param name-姓名
     */
    User getUserByName(@Param("name") String name);
}
