package com.epam.training.bmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.training.bmdb.domain.Actor;

public interface ActorRepository extends JpaRepository<Actor, String> {
}
