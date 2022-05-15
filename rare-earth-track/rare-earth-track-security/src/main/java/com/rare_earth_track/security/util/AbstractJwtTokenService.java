package com.rare_earth_track.security.util;

import lombok.Data;

/**
 * @author hhoa
 * @date 2022/5/14
 **/

@Data
public abstract class AbstractJwtTokenService implements JwtTokenService{
    private String secret;
    private Long expiration;
    private Integer refreshTime;
    private String tokenHead;
}
