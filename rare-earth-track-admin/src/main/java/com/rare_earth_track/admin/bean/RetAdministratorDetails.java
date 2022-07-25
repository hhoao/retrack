package com.rare_earth_track.admin.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rare_earth_track.mgb.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetAdministratorDetails implements UserDetails {
    private RetAdministrator retAdministrator;

    private List<RetResource> retResources;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //最终roleId:roleName即为访问资源所需要的权限, factoryId:jobId为访问公司所需要的权限
        return new ArrayList<>(retResources.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .toList());
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return retAdministrator.getPassword();
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return retAdministrator.getUsername();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return retAdministrator.getStatus() == 1;
    }
}
