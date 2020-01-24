package com.epam.training.bmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.training.bmdb.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
