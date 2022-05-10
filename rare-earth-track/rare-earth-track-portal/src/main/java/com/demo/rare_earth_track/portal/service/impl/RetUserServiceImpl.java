package com.demo.rare_earth_track.portal.service.impl;


import com.demo.rare_earth_track.portal.bean.RetUser;
import com.demo.rare_earth_track.portal.dao.RetUserDao;
import com.demo.rare_earth_track.portal.service.RetUserCacheService;
import com.demo.rare_earth_track.portal.service.RetUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by macro on 2022/3/10
 *
 * @author hhoa
 **/
@Service
@AllArgsConstructor
public class RetUserServiceImpl implements RetUserService {
    private RetUserDao retUserDao;
    private final RetUserCacheService retUserCacheService;

    @Override
    public RetUser getUserByName(String name){
        RetUser retUser = retUserCacheService.getUserByName(name);
        if (retUser == null) {
            retUser = retUserDao.getUserByName(name);
            if (retUser != null){
                retUserCacheService.setUser(retUser);
            }
            else{
                throw new UsernameNotFoundException("用户名或者密码错误");
            }

        }
        return retUser;
    }

    @Override
    public List<RetUser> getAllUsers() {
        return retUserDao.getAllUsers();
    }

    @Override
    public void addUser(RetUser retUser) {
        retUserDao.addUser(retUser);
    }
}
