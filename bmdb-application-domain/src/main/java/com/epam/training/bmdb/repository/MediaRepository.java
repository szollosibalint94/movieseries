package com.epam.training.bmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.training.bmdb.domain.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
