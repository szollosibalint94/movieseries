package app;

import java.math.BigDecimal;
import java.util.List;

import domain.Media;
import domain.Rating;
import domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import service.ConsoleReviewService;

import service.Service;
import view.ConsoleView;
import view.IO;
import view.View;

public class App {
    @Autowired
    Review review;
    @Autowired
    IO io=new IO();

    Service service;
    View view;

    List<Media> medias;
    Media selectedMedia;

    public App(Service service, View view) {
        this.service = service;
        this.view=view;
    }

    public void play(){
        createUser();

        view.printWelcomeMessage(service.findUser());
        String anotherReview;
        do {
            doReview();
            anotherReview=io.consoleIn("Do you want to write another review? (yes/no)").toUpperCase();
        }while(anotherReview.contentEquals("YES"));

        printReviewAverage();
    }

    private void createUser(){
        service.saveUser(view.readUserData());
    }

    private void doReview(){
        Review review=new Review();
        if(medias==null) {
            medias = service.findAllMedia();
        }

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
        io.consoleOut("Average of reviews: "+ sum / selectedMedia.getReviews().size());
    }
}
