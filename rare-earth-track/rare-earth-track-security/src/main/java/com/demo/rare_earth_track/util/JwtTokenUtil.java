package com.demo.rare_earth_track.util;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hhoa
 * @date 2022/5/1
 **/
@Data
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME= "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    /**
     *
     * 过期时间 按秒计时 默认为60*60*24*7
     */
    private Long expiration = 604800L;
    /**
     * 刷新时间 按seconds计时
     */
    private Integer refreshTime = 30*60;

    /**
     * 根据用户信息来生成有效载荷
     * @param userDetails 用户信息
     * @return jwtToken
     */
    public String generateToken(UserDetails userDetails, String secret){
        Map<String, Object> payload = new HashMap<>(2);
        payload.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        payload.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(payload, secret);
    }
    /**
     * 生产jwtToken
     * @param claims 有效载荷
     * @return jwtToken
     */
    public String generateToken(Map<String, Object> claims, String secret){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成过期日期
     * @return 过期日期
     */
    public Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 生产有效载荷
     * @param token jwtToken
     * @return 有效载荷
     */
    public Claims getClaimsFromToken(String token, String secret){
        Claims claims = null;
        try{
            claims =  Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            LOGGER.info("JWT验证失败");
        }
        return claims;
    }

    /**
     * 从jwtToken中获取username
     * @param token jwtToken
     * @return username
     */
    public String getUserNameFromToken(String token, String secret){
        String username;
        try{
            Claims claims = getClaimsFromToken(token, secret);
            username = claims.getSubject();
        } catch(Exception e){
            username = null;
        }
        return username;
    }
    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     */
    public boolean validateToken(String token, UserDetails userDetails, String secret) {
        String username = getUserNameFromToken(token, secret);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token, secret);
    }

    /**
     * 判断token是否已经失效
     */
    private boolean isTokenExpired(String token, String secret) {
        Date expiredDate = getExpiredDateFromToken(token, secret);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token, String secret) {
        Claims claims = getClaimsFromToken(token, secret);
        return claims.getExpiration();
    }

    /**
     * 当原来的token没过期时是可以刷新的
     *
     * @param oldToken 带tokenHead的token
     */
    public String refreshHeadToken(String oldToken, String tokenHead, String secret) {
        if(StrUtil.isEmpty(oldToken)){
            return null;
        }
        String token = oldToken.substring(tokenHead.length());
        if(StrUtil.isEmpty(token)){
            return null;
        }
        //token校验不通过
        Claims claims = getClaimsFromToken(token, secret);
        if(claims==null){
            return null;
        }
        //如果token已经过期，不支持刷新
        if(isTokenExpired(token, secret)){
            return null;
        }
        //如果token在refreshTime内刚刷新过，返回原token
        if(tokenRefreshJustBefore(token,refreshTime, secret)){
            return token;
        }else{
            claims.put(CLAIM_KEY_CREATED, new Date());
            return generateToken(claims, secret);
        }
    }

    /**
     * 判断token在指定时间内是否刚刚刷新过
     * @param token 原token
     * @param time 指定时间（秒）
     */
    private boolean tokenRefreshJustBefore(String token, int time, String secret) {
        Claims claims = getClaimsFromToken(token, secret);
        Date created = claims.get(CLAIM_KEY_CREATED, Date.class);
        Date refreshDate = new Date();
        //刷新时间在创建时间的指定时间内
        return refreshDate.after(created) && refreshDate.before(DateUtil.offsetSecond(created, time));
    }
}
