package com.epam.training.bmdb.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.repository.UserRepository;

@Service
public class BmdbUserDetailsService implements UserDetailsManager, UserDetailsService {

    @Autowired UserRepository userRepository;
    private final Logger LOGGER= LoggerFactory.getLogger(BmdbUserDetailsService.class);

    @Override public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user;
        try {
            LOGGER.info(s);
            user = userRepository.findById(s).get();
        }catch (NoSuchElementException e){
            throw new UsernameNotFoundException(s);
        }
        return new BmdbUserPrincipal(user);
    }

    @Override public void createUser(UserDetails userDetails) {
        User user=new User();
        user.setEmail(userDetails.getUsername());
        user.setPassWord(userDetails.getPassword());
        userRepository.save(user);
    }

    @Override public void updateUser(UserDetails userDetails) {
        User user=new User();
        user.setEmail(userDetails.getUsername());
        user.setPassWord(userDetails.getPassword());
        userRepository.save(user);
    }

    @Override public void deleteUser(String s) {
        userRepository.deleteById(s);

    }

    @Override public void changePassword(String s, String s1) {
        User user=userRepository.findById(s).get();
        user.setPassWord(s1);
        userRepository.save(user);
    }

    @Override public boolean userExists(String s) {
        try{
            userRepository.findById(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
