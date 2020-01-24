package com.epam.training.bmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import com.epam.training.bmdb.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
    @Query
    Optional<User> findByName(String name);
}
