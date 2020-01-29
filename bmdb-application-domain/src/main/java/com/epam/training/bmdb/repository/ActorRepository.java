package com.epam.training.bmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.bmdb.domain.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, String> {
}
