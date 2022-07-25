package com.rare_earth_track.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.common.exception.Asserts;
import com.rare_earth_track.mgb.mapper.RetFactoryMapper;
import com.rare_earth_track.mgb.model.*;
import com.rare_earth_track.portal.bean.MailType;
import com.rare_earth_track.portal.bean.PageInfo;
import com.rare_earth_track.portal.service.*;
import com.rare_earth_track.security.util.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/7/14
 **/

@RequiredArgsConstructor
@Service
public class RetFactoryServiceImpl implements RetFactoryService {
    private final RetFactoryMapper factoryMapper;
    private RetMemberService memberService;
    private final RetProductService productService;
    private final RetFactoryApplicationService factoryApplicationService;
    private final RetMailService mailService;
    private final RetUserCacheService userCacheService;
    private final JwtTokenService tokenService;

    private RetUserService userService;

    @Lazy
    @Autowired
    public void setMemberService(RetMemberService memberService) {
        this.memberService = memberService;
    }

    @Lazy
    @Autowired
    public void setUserService(RetUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<RetFactory> list(PageInfo pageInfo, RetFactory factoryParam) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return getFactories(factoryParam);
    }
    @Override
    public List<RetFactory> getFactories(RetFactory factoryParam) {
        RetFactoryExample factoryExample = getFactoryExample(factoryParam);
        return factoryMapper.selectByExample(factoryExample);
    }
    private RetFactoryExample getFactoryExample(RetFactory factoryParam){
        RetFactoryExample factoryExample = new RetFactoryExample();
        RetFactoryExample.Criteria criteria = factoryExample.createCriteria();
        if (factoryParam.getId() != null){
            criteria.andIdEqualTo(factoryParam.getId());
            return factoryExample;
        }
        if (factoryParam.getEmail() != null){
            criteria.andEmailEqualTo(factoryParam.getEmail());
            return factoryExample;
        }
        if (factoryParam.getAddress() != null){
            criteria.andAddressLike(factoryParam.getAddress());
        }
        if (factoryParam.getName() != null){
            criteria.andNameLike(factoryParam.getName());
            return factoryExample;
        }
        if (factoryParam.getPhone() != null){
            criteria.andPhoneEqualTo(factoryParam.getPhone());
            return factoryExample;
        }
        if (factoryParam.getDescription() != null){
            criteria.andDescriptionLike(factoryParam.getDescription());
        }
        return factoryExample;
    }
    @Override
    public RetFactory getFactoryByFactoryId(Long id) {
        RetFactory retFactory = factoryMapper.selectByPrimaryKey(id);
        if (retFactory == null) {
            Asserts.fail("没有该工厂");
        }
        return retFactory;
    }

    @Override
    public List<RetProduct> listProducts(String factoryName, RetProduct product, PageInfo pageInfo) {
        RetFactory factory = getFactoryByFactoryName(factoryName);
        product.setFactoryId(factory.getId());
        return productService.getProducts(product, pageInfo);
    }
    @Override
    public void inviteUserByEmail(String factoryName, String email) {
        RetFactory factory = getFactoryByFactoryName(factoryName);
        if (factory == null){
            Asserts.fail("没有该工厂");
        }
        mailService.sendFactoryInvitation(email, factory);
    }

    @Override
    public void inviteUserByPhone(String factoryName, String emailOrPhone) {

    }
    @Override
    public RetFactory getFactoryByFactoryName(String name) {
        RetFactoryExample factoryExample = new RetFactoryExample();
        factoryExample.createCriteria().andNameEqualTo(name);
        List<RetFactory> retFactories = factoryMapper.selectByExample(factoryExample);
        if (retFactories == null || retFactories.size() == 0) {
            Asserts.fail("没有该工厂");
        }
        return retFactories.get(0);
    }

    @Override
    public void applySettledFactory(RetFactoryApplication factoryApplication) {
        factoryApplicationService.addApplication(factoryApplication);
    }

    private void addFactoryMember(Long factoryId, Long userId) {
        RetMember member =new RetMember();
        member.setFactoryId(factoryId);
        member.setUserId(userId);
        memberService.addMember(member);
    }
    @Override
    public void handleInvitation(String factoryName, String authorization) {
        //获取邮箱
        String username = tokenService.getSubjectFromAuthorization(authorization);
        boolean hasLogin = userCacheService.hasKey(username);
        if (!hasLogin){
            Asserts.fail("没有登陆");
        }
        RetUserAuth emailAuth = userService.getUserEmailByUsername(username);
        //验证邮箱
        boolean b = mailService.existMessage(emailAuth.getIdentifier(), MailType.FACTORY_INVITATION);
        if (!b){
            Asserts.fail("没有该邮箱");
        }
        RetFactory factoryByFactoryName = getFactoryByFactoryName(factoryName);
        addFactoryMember(factoryByFactoryName.getId(), emailAuth.getUserId());
    }
}