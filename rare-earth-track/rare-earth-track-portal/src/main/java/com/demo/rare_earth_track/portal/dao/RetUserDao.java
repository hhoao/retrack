package com.demo.rare_earth_track.portal.dao;

import com.demo.rare_earth_track.portal.bean.RetUser;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by macro on 2022/3/10
 *
 * @author hhoa
 **/
public interface RetUserDao {
    /**
     *获取所有用户
     * @return 所有用户
     */
    List<RetUser> getAllUsers();

    /**
     * 增加用户
     * @param retUser 用户
     */
    void addUser(@Param("user") RetUser retUser);
    /**
     * 通过用户名获取用户
     * @return user-用户
     * @param name-姓名
     */
    RetUser getUserByName(@Param("name") String name);
}
