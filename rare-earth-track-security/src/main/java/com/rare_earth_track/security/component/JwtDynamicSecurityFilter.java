package com.rare_earth_track.security.component;

import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 动态权限过滤器，用于实现基于路径的动态权限过滤
 *
 * @author macro
 * @date 2020/2/7
 */
public class JwtDynamicSecurityFilter extends AbstractSecurityInterceptor implements Filter {
    private final DynamicSecurityMetadataSource dynamicSecurityMetadataSource;
    private final List<String> ignoredUrls;
    public JwtDynamicSecurityFilter(AccessDecisionManager dynamicAcc,
                                    DynamicSecurityMetadataSource dynamicSecurityMetadataSource,
                                    List<String> ignoredUrls){
        setAccessDecisionManager(dynamicAcc);
        this.dynamicSecurityMetadataSource = dynamicSecurityMetadataSource;
        this.ignoredUrls = ignoredUrls;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, filterChain);
        //OPTIONS请求直接放行
        if(request.getMethod().equals(HttpMethod.OPTIONS.toString())){
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
            return;
        }
        //白名单请求直接放行
        PathMatcher pathMatcher = new AntPathMatcher();
        for (String path : ignoredUrls) {
            if(pathMatcher.match(path,request.getRequestURI())){
//                fi.getRequest().setAttribute("__spring_security_filterSecurityInterceptor_filterApplied", true);
                fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
                return;
            }
        }
        //此处会调用AccessDecisionManager中的decide方法进行鉴权操作
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return dynamicSecurityMetadataSource;
    }

}
