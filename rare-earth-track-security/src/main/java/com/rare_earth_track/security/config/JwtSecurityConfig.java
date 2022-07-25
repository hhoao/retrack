package com.rare_earth_track.security.config;


import cn.hutool.extra.spring.SpringUtil;
import com.rare_earth_track.security.component.*;
import com.rare_earth_track.security.util.DefaultJwtTokenServiceImpl;
import com.rare_earth_track.security.util.JwtTokenService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
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

import java.util.List;
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
    private AuthenticationTokenFilter authenticationTokenFilter;
    private PasswordEncoder passwordEncoder;
    private JwtTokenService jwtTokenService;
    private List<AccessDecisionVoter<?>> voters;

    public JwtSecurityConfig(JwtSecurityProperties jwtSecurityProperties) {
        this.jwtSecurityProperties = jwtSecurityProperties;
    }


    public JwtTokenService getDefaultJwtTokenService(){
        this.jwtTokenService = new DefaultJwtTokenServiceImpl();
        configureJwtTokenService();
        return this.jwtTokenService;
    }
    @Autowired(required = false)
    @ConditionalOnBean(JwtTokenService.class)
    public JwtTokenService jwtTokenService(JwtTokenService jwtTokenService){
        this.jwtTokenService = jwtTokenService;
        return this.jwtTokenService;
    }
    public void configureJwtTokenService(){
        this.jwtTokenService.setTokenHead(jwtSecurityProperties.getTokenHead());
        this.jwtTokenService.setExpiration(jwtSecurityProperties.getExpiration());
        Assert.hasText(jwtSecurityProperties.getSecret());
        this.jwtTokenService.setSecret(jwtSecurityProperties.getSecret());
        this.jwtTokenService.setRefreshTime(jwtSecurityProperties.getRefreshTime());
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
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        //有动态权限配置时添加动态权限校验过滤器
        if (dynamicSecurityService != null){
            registry.and().addFilterBefore(getDynamicSecurityFilter(), FilterSecurityInterceptor.class);
        }
    }

    public AuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        if (this.jwtTokenService == null){
            this.jwtTokenService = getDefaultJwtTokenService();
            SpringUtil.registerBean("jwtTokenService", this.jwtTokenService);
        }
        if (this.authenticationTokenFilter == null) {
            this.authenticationTokenFilter = new AuthenticationTokenFilter(userDetailsService(),
                    this.jwtSecurityProperties,
                    this.jwtTokenService);
        }
        return this.authenticationTokenFilter;
    }
    @Autowired(required = false)
    public void dynamicSecurityService(DynamicSecurityService dynamicSecurityService){
        this.dynamicSecurityService = dynamicSecurityService;
    }
    @Autowired(required = false)
    public void DecisionVoters(List<AccessDecisionVoter<?>> accessDecisionVoterList){
        this.voters = accessDecisionVoterList;
    }

    public JwtDynamicSecurityFilter getDynamicSecurityFilter(){
        return new JwtDynamicSecurityFilter(//new DynamicAccessDecisionManager(voters),
                new AffirmativeBased(voters),
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
