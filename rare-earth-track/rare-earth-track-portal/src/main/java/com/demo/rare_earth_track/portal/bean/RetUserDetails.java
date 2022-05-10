package com.demo.rare_earth_track.portal.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hhoa
 **/
public class RetUserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private final RetUser retUser;
    private final List<RetResource> retResources;
    public RetUserDetails(RetUser retUser, List<RetResource> retResources) {
        this.retUser = retUser;
        this.retResources = retResources;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  retResources.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return retUser.getPassword();
    }

    @Override
    public String getUsername() {
        return retUser.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return "1".equals(retUser.getStatus());
    }
}
