package com.epam.training.bmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.training.bmdb.domain.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
}
