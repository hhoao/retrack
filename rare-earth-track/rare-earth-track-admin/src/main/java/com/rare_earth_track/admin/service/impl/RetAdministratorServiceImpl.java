package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.*;
import com.rare_earth_track.admin.service.*;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetAdministratorMapper;
import com.rare_earth_track.mgb.model.RetAdministrator;
import com.rare_earth_track.mgb.model.RetAdministratorExample;
import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.security.util.JwtTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * The type Ret administrator service.
 *
 * @author hhoa
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RetAdministratorServiceImpl implements RetAdministratorService {
    private final RetAdministratorMapper administratorMapper;
    private final PasswordEncoder passwordEncoder;
    private final RetAdministratorCacheService administratorCacheService;

    private final JwtTokenService jwtTokenService;
    private final RetRoleService roleService;

    @Override
    public String login(RetLoginParam loginParam) {
        String token = null;
        try {
            RetAdministrator administrator = getAdministratorByAdministratorName(loginParam.getIdentifier());
            if (!passwordEncoder.matches(loginParam.getPassword(), administrator.getPassword())) {
                Asserts.fail("密码错误");
            }
            if (!administrator.getStatus().equals(1)) {
                throw new DisabledException("用户已被冻结");
            }
            RetAdministratorDetails administratorDetails = getAdministratorDetails(administrator.getUsername());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(administratorDetails, null, administratorDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            administratorCacheService.setKey(administrator.getUsername(), administratorDetails);
            token = jwtTokenService.generateToken(administrator.getUsername());
            log.info(administratorDetails.getUsername() + "登录成功");
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }

        return token;
    }

    @Override
    public void logout(String authorization) {
        String administratorName = jwtTokenService.getSubjectFromAuthorization(authorization);
        clearAdministratorStatus(administratorName);
    }

    private void clearAdministratorStatus(String administratorName) {
        administratorCacheService.delKey(administratorName);
    }

    private RetAdministratorDetails getAdministratorDetailsNoCache(String administratorName) {
        RetAdministratorExample administratorExample = new RetAdministratorExample();
        RetAdministratorExample.Criteria criteria = administratorExample.createCriteria();
        criteria.andUsernameEqualTo(administratorName);
        List<RetAdministrator> retAdministrators = administratorMapper.selectByExample(administratorExample);
        if (retAdministrators.size() == 0){
            Asserts.fail("没有该用户名");
        }
        RetAdministrator administratorByAdministratorName = retAdministrators.get(0);
        RetAdministrator administrator = administratorMapper.selectByPrimaryKey(administratorByAdministratorName.getId());
        List<RetResource> administratorResources = getAdministratorResources(administrator.getId());
        return new RetAdministratorDetails(administrator, administratorResources);
    }

    private void refreshAdministratorDetailsCache(String administratorName) {
        RetAdministratorDetails administratorDetailsNoCache = getAdministratorDetailsNoCache(administratorName);
        administratorCacheService.setKey(administratorName, administratorDetailsNoCache);
    }

    @Override
    public RetAdministratorDetails getAdministratorDetails(String administratorName) {
        //使用了缓存
        RetAdministratorDetails administratorDetails = administratorCacheService.getKey(administratorName);
        if (administratorDetails != null) {
            return administratorDetails;
        }
        administratorDetails = getAdministratorDetailsNoCache(administratorName);
        refreshAdministratorDetailsCache(administratorName);
        return administratorDetails;
    }


    @Override
    public String refreshToken(String authorization) {
        String administratorName = jwtTokenService.getSubjectFromAuthorization(authorization);
        boolean b = administratorCacheService.hasKey(administratorName);
        if (!b) {
            Asserts.fail("用户未登陆");
        }
        String tokenFromAuthorization = jwtTokenService.getTokenFromAuthorization(authorization);
        String retToken = jwtTokenService.refreshHeadToken(tokenFromAuthorization);
        if (retToken == null) {
            Asserts.fail("token已经过期");
        }
        return retToken;
    }

    @Override
    public RetAdministrator getAdministratorByAdministratorName(String administratorName) {
        RetAdministratorDetails administratorDetails = getAdministratorDetails(administratorName);
        return administratorDetails.getRetAdministrator();
    }


    @Override
    public void updateAdministrator(RetAdministrator newAdministrator) {
        int i = administratorMapper.updateByPrimaryKeySelective(newAdministrator);
        if (i == 0) {
            Asserts.fail("用户更新失败");
        }
        RetAdministrator administrator = getAdministrators(newAdministrator.getId());
        //刷新用户token，使用户需要重新登陆
        if (newAdministrator.getStatus() != null || newAdministrator.getRoleId() != null) {
            clearAdministratorStatus(administrator.getUsername());
        }
        refreshAdministratorDetailsCache(administrator.getUsername());
    }

    @Override
    public RetAdministrator getAdministrators(Long administratorId) {
        RetAdministrator administrator = administratorMapper.selectByPrimaryKey(administratorId);
        if (administrator == null) {
            Asserts.fail("没有该用户");
        }
        return administrator;
    }


    @Override
    public void deleteAdministratorByAdministratorId(Long administratorId) {
        RetAdministrator administrator = getAdministrators(administratorId);
        clearAdministratorStatus(administrator.getUsername());
        int i = administratorMapper.deleteByPrimaryKey(administratorId);
        if (i == 0) {
            Asserts.fail("删除失败");
        }

    }

    @Override
    public void deleteAdministrators(RetAdministrator administrator) {
        List<RetAdministrator> administrators = getAdministrators(administrator);
        for (RetAdministrator delAdministrator : administrators) {
            administratorMapper.deleteByPrimaryKey(delAdministrator.getId());
        }
    }

    /**
     * 获取administratorExample
     *
     * @param administrator administrator
     * @return RetAdministratorExample
     */
    private RetAdministratorExample getAdministratorExample(RetAdministrator administrator) {
        RetAdministratorExample administratorExample = new RetAdministratorExample();
        if (administrator != null) {
            RetAdministratorExample.Criteria criteria = administratorExample.createCriteria();
            if (StringUtils.hasLength(administrator.getAddress()))
                criteria.andAddressEqualTo(administrator.getAddress());
            if (administrator.getAge() != null)
                criteria.andAgeEqualTo(administrator.getAge());
            if (administrator.getBirthday() != null)
                criteria.andBirthdayEqualTo(administrator.getBirthday());
            if (administrator.getId() != null)
                criteria.andIdEqualTo(administrator.getId());
            if (StringUtils.hasLength(administrator.getJob()))
                criteria.andJobEqualTo(administrator.getJob());
            if (StringUtils.hasLength(administrator.getUsername()))
                criteria.andUsernameEqualTo(administrator.getUsername());
            if (administrator.getStatus() != null)
                criteria.andStatusEqualTo(administrator.getStatus());
            if (administrator.getSex() != null)
                criteria.andSexEqualTo(administrator.getSex());
            if (administrator.getRoleId() != null)
                criteria.andRoleIdEqualTo(administrator.getRoleId());
        }
        return administratorExample;
    }

    @Override
    public List<RetAdministrator> getAdministrators(RetAdministrator administrator) {
        RetAdministratorExample administratorExample = getAdministratorExample(administrator);
        return administratorMapper.selectByExample(administratorExample);
    }

    @Override
    public List<RetAdministrator> list(PageInfo pageInfo, RetAdministrator administrator) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return getAdministrators(administrator);
    }

    @Override
    public List<RetResource> getAdministratorResources(Long administratorId) {
        RetAdministrator administrator = administratorMapper.selectByPrimaryKey(administratorId);
        return roleService.getRoleResources(administrator.getRoleId());
    }

    @Override
    public RetAdministrator getAdministratorByAuthorization(String authorization) {
        String administratorName = jwtTokenService.getSubjectFromAuthorization(authorization);
        return this.getAdministratorByAdministratorName(administratorName);
    }

    @Override
    public List<RetMenu> getMenusByAuthorization(String authorization) {
        String administratorName = jwtTokenService.getSubjectFromAuthorization(authorization);
        RetAdministrator administratorByName = this.getAdministratorByAdministratorName(administratorName);
        return roleService.getMenus(administratorByName.getRoleId());
    }
}
