package com.rare_earth_track.security.util;

/**
 * The interface Jwt token service.
 *
 * @author hhoa
 * @date 2022 /5/14
 */
public interface JwtTokenService {
    /**
     * 生成jwtToken
     *
     * @param subject 主要信息
     * @return token string
     */
    String generateToken(Object subject);

    /**
     * 从token中加载subject
     *
     * @param token token
     * @return subject subject from token
     */
    String getSubjectFromToken(String token);

    /**
     * Gets subject from authorization.
     *
     * @param authorization the authorization
     * @return the subject from authorization
     */
    String getSubjectFromAuthorization(String authorization);

    /**
     * 验证token是否还有效
     *
     * @param token 客户端传入的token
     * @return 是否有效 boolean
     */
    boolean validateToken(String token);

    /**
     * 当原来的token没过期时是可以刷新的
     *
     * @param oldToken 带tokenHead的token
     * @return token string
     */
    String refreshHeadToken(String oldToken);

    /**
     * Sets expiration.
     *
     * @param expiration the expiration
     */
    void setExpiration(Long expiration);

    /**
     * Sets refresh time.
     *
     * @param refreshTime the refresh time
     */
    void setRefreshTime(Integer refreshTime);

    /**
     * Sets secret.
     *
     * @param secret the secret
     */
    void setSecret(String secret);

    /**
     * Sets token head.
     *
     * @param tokenHead the token head
     */
    void setTokenHead(String tokenHead);

    /**
     * Gets expiration.
     *
     * @return the expiration
     */
    Long getExpiration();

    /**
     * Gets refresh time.
     *
     * @return the refresh time
     */
    Integer getRefreshTime();

    /**
     * Gets secret.
     *
     * @return the secret
     */
    String getSecret();

    /**
     * Gets token head.
     *
     * @return the token head
     */
    String getTokenHead();

    /**
     * Gets token from authorization.
     *
     * @param authorization the authorization
     * @return the token from authorization
     */
    String getTokenFromAuthorization(String authorization);
}
