package com.rare_earth_track.admin.service.impl;

import com.rare_earth_track.admin.service.RetUserCacheService;
import com.rare_earth_track.admin.service.RetUserService;
import com.rare_earth_track.mgb.mapper.RetUserMapper;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserExample;
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
    private RetUserMapper retUserMapper;
    private final RetUserCacheService retUserCacheService;

    @Override
    public List<RetUser> getAllUsers() {
        return retUserMapper.selectByExample(new RetUserExample());
    }

    @Override
    public RetUser getUserByName(String name){
        RetUser retUser = retUserCacheService.getUserByName(name);
        if (retUser == null) {
            RetUserExample retUserExample = new RetUserExample();
            retUserExample.createCriteria().andNameEqualTo(name);
            List<RetUser> retUsers = retUserMapper.selectByExample(retUserExample);
            if (retUsers != null && retUsers.size() > 0){
                retUser = retUsers.get(0);
                retUserCacheService.setUser(retUser);
            }
            else{
                throw new UsernameNotFoundException("用户名或者密码错误");
            }

        }
        return retUser;
    }

}
