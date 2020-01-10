package com.epam.training.moviereview.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.moviereview.domain.Media;
import com.epam.training.moviereview.domain.Review;
import com.epam.training.moviereview.domain.User;

public class ReviewService implements Service {

    @Override public void saveUser(User user){}

    @Override public User findUser(){
        return new User();
    }

    @Override public List<Media> findAllMedia(){
        List<Media> mediaList=new ArrayList<>();

        return mediaList;
    }

    @Override public void saveReview(Review review){}

    @Override public List<Review> findAllReview(){
        List<Review> reviewList=new ArrayList<>();

        return reviewList;
    }
}
