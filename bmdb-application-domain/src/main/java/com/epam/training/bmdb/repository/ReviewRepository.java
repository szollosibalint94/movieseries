package com.epam.training.bmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epam.training.bmdb.domain.Review;
import com.epam.training.bmdb.domain.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public Iterable<Review> findAllByCreator(User creator);
}
