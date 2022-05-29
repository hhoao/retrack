package com.rare_earth_track.admin.bean;


import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 认证需要的UserDetails
 * @author hhoa
 **/
@RequiredArgsConstructor
public class RetUserDetails implements UserDetails {
    private final RetUser retUser;
    private final RetUserAuth userAuth;
    private final List<RetResource> retResources;
    private final List<RetFactoryJob> factoryJobs;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.addAll(retResources.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .toList());
        grantedAuthorities.addAll(factoryJobs.stream()
                .map(factoryJob -> new SimpleGrantedAuthority(factoryJob.getFactoryId() + ":" + factoryJob.getJobId()))
                .toList());

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userAuth.getCredential();
    }

    @Override
    public String getUsername() {
        return userAuth.getIdentifier();
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
        return retUser.getStatus() == 1;
    }
}
