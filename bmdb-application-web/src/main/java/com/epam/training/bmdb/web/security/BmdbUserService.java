package com.epam.training.bmdb.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.bmdb.domain.Role;
import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.repository.RoleRepository;
import com.epam.training.bmdb.repository.UserRepository;

@Service
public class BmdbUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final Logger LOGGER = LoggerFactory.getLogger(BmdbUserService.class);

    public void save(User user) {
        user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        List<Role> roles = new ArrayList<>();
        Role role =new Role();
        try {
            role = roleRepository.findByName("USER");
        } catch (Exception e) {
            LOGGER.error("Cannot retrieve USER role");
            role.setName("USER");
        }
        role.addUser(user);
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }
}
