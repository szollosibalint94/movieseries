package com.epam.training.bmdb.web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.epam.training.bmdb.domain.User;

@Service
public class BmdbUserPrincipal implements UserDetails {
    private User user;

    public BmdbUserPrincipal(User user) {
        this.user = user;
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> authorities=new ArrayList<>();
        authorities.add("USER");
        System.out.println("Get Authorities");
        return null;
    }

    @Override public String getPassword() {
        System.out.println("Password: " + user.getPassWord());
        return user.getPassWord();
    }

    @Override public String getUsername() {
        System.out.println("Username: " + user.getEmail());
        return user.getEmail();
    }

    @Override public boolean isAccountNonExpired() {
        return true;
    }

    @Override public boolean isAccountNonLocked() {
        return true;
    }

    @Override public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override public boolean isEnabled() {
        return true;
    }
}
