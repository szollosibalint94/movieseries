package com.epam.training.moviereview.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.moviereview.domain.Media;
import com.epam.training.moviereview.domain.Review;
import com.epam.training.moviereview.domain.User;
import com.epam.training.moviereview.view.IO;

public class ConsoleReviewService implements Service {
    IO io=new IO();
    User user;
    Review review;

    @Override public void saveUser(User user){
        this.user=user;
    }

    @Override public User findUser(){
        return this.user;
    }

    @Override public List<Media> findAllMedia(){
        BuildMedias buildMedias=new BuildMedias();

        List<Media> mediaList=buildMedias.getMedias();
        printMedias(mediaList);
        return mediaList;
    }

    public void printMedias(List<Media> medias){
        for (Media media: medias) {
            io.consoleOut(media.toString());
        }
    }

    @Override public void saveReview(Review review){
        this.review=review;
    }

    @Override public List<Review> findAllReview(){
        List<Review> reviewList=new ArrayList<>();

        reviewList.add(this.review);

        return reviewList;
    }
}
