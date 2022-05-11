package com.rare_earth_track.security.config;


import com.rare_earth_track.security.component.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Objects;

/**
 * 对SpringSecurity配置类的扩展，支持自定义白名单资源路径和查询用户逻辑
 * @author hhoa
 */
@Configuration
@EnableConfigurationProperties(JwtSecurityProperties.class)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtSecurityProperties jwtSecurityProperties;
    private UserDetailsService userDetailsService;
    private DynamicSecurityService dynamicSecurityService;
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    private PasswordEncoder passwordEncoder;

    public JwtSecurityConfig(JwtSecurityProperties jwtSecurityProperties) {
        this.jwtSecurityProperties = jwtSecurityProperties;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        // 不需要保护的资源路径允许访问
        if (jwtSecurityProperties.getIgnored().getUrls() != null) {
            for (String url : jwtSecurityProperties.getIgnored().getUrls()) {
                registry.antMatchers(url).permitAll();
            }
        }
        // 允许跨域的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll();
        // 其他任何请求都需要身份认证
        registry.and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                // 关闭跨站请求防护及不使用session
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                .accessDeniedHandler(getAccessDeniedHandler())
                .authenticationEntryPoint(getAuthenticationEntryPoint())
                // 自定义权限拦截器JWT过滤器
                .and()
                .addFilterBefore(getJwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        //有动态权限配置时添加动态权限校验过滤器
        if (dynamicSecurityService != null){
            registry.and().addFilterBefore(getDynamicSecurityFilter(), FilterSecurityInterceptor.class);
        }
    }

    public JwtAuthenticationTokenFilter getJwtAuthenticationTokenFilter(){
        if (this.jwtAuthenticationTokenFilter == null) {
            UserDetailsService userDetailsService = userDetailsService();
            this.jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter(userDetailsService, jwtSecurityProperties);
        }
        return jwtAuthenticationTokenFilter;
    }
    @Autowired(required = false)
    public void dynamicSecurityService(DynamicSecurityService dynamicSecurityService){
        this.dynamicSecurityService = dynamicSecurityService;
    }

    public DynamicSecurityFilter getDynamicSecurityFilter(){
        return new DynamicSecurityFilter(new DynamicAccessDecisionManager(),
                new DynamicSecurityMetadataSource(dynamicSecurityService),
                jwtSecurityProperties.getIgnored().getUrls());
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(getPasswordEncode());
    }

    @Autowired(required = false)
    public void passwordEncoder(PasswordEncoder passwordEncoder){
       this.passwordEncoder = passwordEncoder;
    }

    @Autowired(required = false)
    public void userDetailsService(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }
    private PasswordEncoder getPasswordEncode(){
        return Objects.requireNonNullElseGet(this.passwordEncoder, BCryptPasswordEncoder::new);
    }
    @Override
    protected UserDetailsService userDetailsService() {
        if (userDetailsService != null){
            return userDetailsService;
        }
        return super.userDetailsService();
    }
    public AuthenticationEntryPoint getAuthenticationEntryPoint(){
        return new RestAuthenticationEntryPoint();
    }
    public AccessDeniedHandler getAccessDeniedHandler(){
        return new RestfulAccessDeniedHandler();
    }
}
