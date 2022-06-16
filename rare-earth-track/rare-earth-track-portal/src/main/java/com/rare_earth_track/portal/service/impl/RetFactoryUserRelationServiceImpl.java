package com.rare_earth_track.portal.service.impl;

import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.portal.service.RetFactoryUserRelationService;
import com.rare_earth_track.portal.service.RetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/5/29
 **/

@Service
@RequiredArgsConstructor
public class RetFactoryUserRelationServiceImpl implements RetFactoryUserRelationService {
    private final RetUserService userService;
    @Override
    public RetUserAuth getUserEmailByUsername(String username) {
        return userService.getUserEmailByUsername(username);
    }

    @Override
    public Long getUserIdByUsername(String username) {
        RetUser userByName = userService.getUserByUsername(username);
        return userByName.getId();
    }
}
