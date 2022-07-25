package com.rare_earth_track.portal.bean;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
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
public class RetUserDetails implements UserDetails {
    private RetUser retUser;

    private List<RetUserAuth> userAuths;
    private List<RetFactoryJob> factoryJobs;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //最终roleId:roleName即为访问资源所需要的权限, factoryId:jobId为访问公司所需要的权限
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.addAll(factoryJobs.stream()
                .map(factoryJob -> new SimpleGrantedAuthority(factoryJob.getFactoryName() + ":" + factoryJob.getJobName()))
                .toList());

        return grantedAuthorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return userAuths.get(0).getCredential();
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        for (RetUserAuth userAuth : userAuths){
            if (userAuth.getIdentityType().equals(IdentifyType.username.value())){
                return userAuth.getCredential();
            }
        }
        return null;
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
        return retUser.getStatus() == 1;
    }
}
