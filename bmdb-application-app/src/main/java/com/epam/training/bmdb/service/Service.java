package com.epam.training.bmdb.service;

import java.util.List;

import com.epam.training.bmdb.domain.Media;
import com.epam.training.bmdb.domain.Review;
import com.epam.training.bmdb.domain.User;

public interface Service {
    public void saveUser(User user);

    public User findUser(String id);

    public List<Media> findAllMedia();

    public void saveReview(Media media, Review review);

    public List<Review> findAllReview(Media media);
}
