package com.demo.rare_earth_track.security.component;

import com.demo.rare_earth_track.security.config.JwtSecurityProperties;
import com.demo.rare_earth_track.security.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hhoa
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    private final UserDetailsService userDetailsService;
    private final JwtSecurityProperties jwtSecurityProperties;

    public JwtAuthenticationTokenFilter(UserDetailsService userDetailsService, JwtSecurityProperties jwtSecurityProperties) {
        this.userDetailsService = userDetailsService;
        this.jwtSecurityProperties = jwtSecurityProperties;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(jwtSecurityProperties.getTokenHeader());
        if (authHeader != null && authHeader.startsWith(jwtSecurityProperties.getTokenHead())) {
            String authToken = authHeader.substring(jwtSecurityProperties.getTokenHead().length());
            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            String username = jwtTokenUtil.getUserNameFromToken(authToken, jwtSecurityProperties.getSecret());
            LOGGER.info("checking username:{}", username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, userDetails, jwtSecurityProperties.getSecret())) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    LOGGER.info("authenticated user:{}", username);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
