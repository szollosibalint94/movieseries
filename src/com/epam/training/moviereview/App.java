package com.epam.training.moviereview;

import java.math.BigDecimal;
import java.util.List;

import com.epam.training.moviereview.domain.Media;
import com.epam.training.moviereview.domain.Rating;
import com.epam.training.moviereview.domain.Review;
import com.epam.training.moviereview.service.ConsoleReviewService;

import com.epam.training.moviereview.service.Service;
import com.epam.training.moviereview.view.ConsoleView;
import com.epam.training.moviereview.view.IO;
import com.epam.training.moviereview.view.View;

public class App {
    Review review=new Review();

    public App(Service service, View view) {
        this.service = service;
        this.view=view;
    }

    List<Media> medias;
    Media selectedMedia;
    Service service;
    View view;
    IO io=new IO();

    public static void main(String[] args) {
        App app=new App(new ConsoleReviewService(), new ConsoleView());
        app.play();
    }

    public void play(){
        createUser();
        doReview();
        printReviewAverage();
    }

    private void createUser(){
        service.saveUser(view.readUserData());
    }

    private void doReview(){
        Review review=new Review();
        medias=service.findAllMedia();
        view.printWelcomeMessage(service.findUser());

        do {
            BigDecimal id = BigDecimal.valueOf(Long.parseLong(io.consoleIn("Choose an id")));

            int i = 0;
            while (i < medias.size() && !medias.get(i).getId().equals(id)) {
                i++;
            }
            selectedMedia=medias.get(i);
        }while (selectedMedia==null);

        review.setText(io.consoleIn("Write a review"));

        do {
            String rating=io.consoleIn("Choose a rating! (BAD, AVERAGE, GOOD)").toUpperCase();
            if(rating.contentEquals("BAD")){
                review.setRating(Rating.BAD);
            }
            if(rating.contentEquals("AVERAGE")){
                review.setRating(Rating.AVERAGE);
            }
            if(rating.contentEquals("GOOD")){
                review.setRating(Rating.GOOD);
            }
        }while (review.getRating()==null);

        review.setCreator(service.findUser());

        service.saveReview(selectedMedia, review);
        this.review=review;
    }

    private void printReviewAverage(){
        List<Review> reviews=service.findAllReview(selectedMedia);
        int sum=0;
        for(Review review : reviews){
            sum+=Rating.valueOfRating(review.getRating());
        }
        io.consoleOut("Average of reviews: "+sum/selectedMedia.getReviews().size());
    }
}
