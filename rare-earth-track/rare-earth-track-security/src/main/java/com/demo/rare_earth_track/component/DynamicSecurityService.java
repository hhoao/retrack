package com.demo.rare_earth_track.component;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Map;

/**
 * 动态权限相关业务类
 *
 * @author hhoa
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     * @return 数据
     */
    Map<AntPathRequestMatcher, ConfigAttribute> loadDataSource();
}
