package com.epam.training.moviereview.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.moviereview.domain.Media;
import com.epam.training.moviereview.domain.Review;
import com.epam.training.moviereview.domain.User;

public interface Service {
    public void saveUser(User user);

    public User findUser();

    public List<Media> findAllMedia();

    public void saveReview(Review review);

    public List<Review> findAllReview();
}
