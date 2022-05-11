package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetUserCacheService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.mgb.dao.RetUserDao;
import com.rare_earth_track.mgb.model.RetUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
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
