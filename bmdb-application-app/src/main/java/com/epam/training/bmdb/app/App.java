package com.epam.training.bmdb.app;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.epam.training.bmdb.domain.Media;
import com.epam.training.bmdb.domain.Rating;
import com.epam.training.bmdb.domain.Review;
import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.service.ConsoleReviewService;
import com.epam.training.bmdb.view.ConsoleView;
import com.epam.training.bmdb.view.IO;

public class App {
    @Autowired
    IO io;
    @Autowired
    private ConsoleReviewService service;
    @Autowired
    private ConsoleView view;
    @Autowired
    User activeUser;

    List<Media> medias;
    Media selectedMedia;

    public void play() {
        medias = service.findAllMedia();
        activeUser = view.readUserData();
        if (activeUser.getName() == null) {
            createUser();
        }

        view.printWelcomeMessage(activeUser);
        String anotherReview;
        do {
            doReview();
            printReviewAverage();
            anotherReview = io.consoleIn("Do you want to write another review? (yes/no)").toUpperCase();
        } while (anotherReview.contentEquals("YES"));
    }

    private void createUser() {
        io.consoleOut("You have to register to use the application!");
        User newUser = new User();
        newUser.setName(io.consoleIn("What is your name?"));
        newUser.setEmail(io.consoleIn("Type your e-mail address"));
        newUser.setPassWord(io.consoleIn("Type your password"));

        service.saveUser(newUser);
        activeUser = view.readUserData(newUser.getEmail());
    }

    private void doReview() {
        Review review = new Review();
        if (medias == null) {
            medias = service.findAllMedia();
        }

        service.printMedias(medias);

        do {
            long id = Long.parseLong(io.consoleIn("Choose an id"));

            int i = 0;
            while (i < medias.size() && !medias.get(i).getId().equals(id)) {
                i++;
            }
            if (i < medias.size()) {
                selectedMedia = medias.get(i);
            }
        } while (selectedMedia == null);

        review.setText(io.consoleIn("Write a review"));

        do {
            String rating = io.consoleIn("Choose a rating! (BAD, AVERAGE, GOOD)").toUpperCase();
            if (rating.contentEquals("BAD")) {
                review.setRating(Rating.BAD);
            }
            if (rating.contentEquals("AVERAGE")) {
                review.setRating(Rating.AVERAGE);
            }
            if (rating.contentEquals("GOOD")) {
                review.setRating(Rating.GOOD);
            }
        } while (review.getRating() == null);

        review.setCreator(activeUser);

        service.saveReview(selectedMedia, review);
    }

    private void printReviewAverage() {
        List<Review> reviews = service.findAllReview(selectedMedia);
        int sum = 0;
        for (Review review : reviews) {
            sum += Rating.valueOfRating(review.getRating());
        }
        io.consoleOut("Average of reviews: " + sum / selectedMedia.getReviews().size());
    }
}
