package com.rare_earth_track.security.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import com.rare_earth_track.common.exception.Asserts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hhoa
 * @date 2022/5/1
 **/

@Slf4j
public class DefaultJwtTokenServiceImpl extends AbstractJwtTokenService{
    public static final String CLAIM_KEY_CREATED = "create";
    @Override
    public String generateToken(Object subject){
        Map<String, Object> claims = new HashMap<>(2);
        claims.put(CLAIM_KEY_CREATED, new Date());
        claims.put(JWT.SUBJECT, subject);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, getSecret())
                .compact();
    }

    /**
     * 生成过期日期
     * @return 过期日期
     */
    public Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + getExpiration() * 1000);
    }

    /**
     * 生产有效载荷
     * @param token jwtToken
     * @return 有效载荷
     */
    public Claims getClaimsFromToken(String token){
        Claims claims = null;
        try{
            claims =  Jwts.parser()
                    .setSigningKey(getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.info("JWT验证失败");
        }
        return claims;
    }

    /**
     * 从jwtToken中获取subject
     * @param token jwtToken
     * @return subject
     */
    @Override
    public String getSubjectFromToken(String token){
        String subject;
        try{
            Claims claims = getClaimsFromToken(token);
            subject = claims.getSubject();
        } catch(Exception e){
            subject = null;
        }
        return subject;
    }
    @Override
    public String getTokenFromAuthorization(String authorization){
        return authorization.substring(getTokenHead().length());
    }
    @Override
    public String getSubjectFromAuthorization(String authorization) {
        String authToken = getTokenFromAuthorization(authorization);
        String subjectFromToken = getSubjectFromToken(authToken);
        if (subjectFromToken == null){
            Asserts.fail("该用户未登陆");
        }
        return subjectFromToken;
    }

    @Override
    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 判断token是否已经失效
     */
    public boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 当原来的token没过期时是可以刷新的
     *
     * @param oldToken 带tokenHead的token
     */
    @Override
    public String refreshHeadToken(String oldToken) {
        if(StrUtil.isEmpty(oldToken)){
            return null;
        }
        String token = oldToken.substring(getTokenHead().length());
        if(StrUtil.isEmpty(token)){
            return null;
        }
        //token校验不通过
        Claims claims = getClaimsFromToken(token);
        if(claims==null){
            return null;
        }
        //如果token已经过期，不支持刷新
        if(isTokenExpired(token)){
            return null;
        }
        //如果token在refreshTime内刚刷新过，返回原token
        if(tokenRefreshJustBefore(token,getRefreshTime())){
            return token;
        }else{
            return generateToken(claims);
        }
    }

    /**
     * 判断token在指定时间内是否刚刚刷新过
     * @param token 原token
     * @param time 指定时间（秒）
     */
    public boolean tokenRefreshJustBefore(String token, int time) {
        Claims claims = getClaimsFromToken(token);
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date refreshDate = new Date();
        //刷新时间在创建时间的指定时间内
        return refreshDate.after(created) && refreshDate.before(DateUtil.offsetSecond(created, time));
    }
}
