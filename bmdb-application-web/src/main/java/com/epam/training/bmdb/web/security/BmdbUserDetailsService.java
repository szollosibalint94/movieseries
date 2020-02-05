package com.epam.training.bmdb.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.bmdb.domain.Role;
import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.repository.UserRepository;

@Service
public class BmdbUserDetailsService implements UserDetailsService {

    @Autowired UserRepository userRepository;

    @Override public UserDetails loadUserByUsername(String userName){
        User user = userRepository.findByEmail(userName);
        if (user == null) throw new UsernameNotFoundException(userName);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassWord(), grantedAuthorities);
    }
}
