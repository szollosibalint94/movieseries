package com.epam.training.bmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.training.bmdb.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
