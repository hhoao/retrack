package com.demo.rare_earth_track.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hhoa
 **/
public class MyUserDetails implements UserDetails {
    private final User user;
    private final List<Resource> resources;
    public MyUserDetails(User user, List<Resource> resources) {
        this.user = user;
        this.resources = resources;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  resources.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
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
        return "1".equals(user.getStatus());
    }
}
