package com.demo.rare_earth_track.service.impl;


import com.demo.rare_earth_track.bean.User;
import com.demo.rare_earth_track.dao.UserDao;
import com.demo.rare_earth_track.service.UserCacheService;
import com.demo.rare_earth_track.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by macro on 2022/3/10
 *
 * @author hhoa
 **/
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private final UserCacheService userCacheService;

    @Override
    public User getUserByName(String name){
        User user = userCacheService.getUserByName(name);
        if (user == null) {
            user= userDao.getUserByName(name);
            if (user != null){
                userCacheService.setUser(user);
            }
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
