package com.rare_earth_track.security.util;

/**
 * @author hhoa
 * @date 2022/5/14
 **/
public interface JwtTokenService {
    /**
     * 生成jwtToken
     * @param subject 主要信息
     * @return token
     */
    String generateToken(Object subject);

    /**
     * 从token中加载subject
     * @param token token
     * @return subject
     */
    String getSubjectFromToken(String token);

    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @return 是否有效
     */
    boolean validateToken(String token);

    /**
     * 当原来的token没过期时是可以刷新的
     * @param oldToken 带tokenHead的token
     * @return token
     */
    String refreshHeadToken(String oldToken);
    void setExpiration(Long expiration);
    void setRefreshTime(Integer refreshTime);
    void setSecret(String secret);
    void setTokenHead(String tokenHead);
    Long getExpiration();
    Integer getRefreshTime();
    String getSecret();
    String getTokenHead();
}
