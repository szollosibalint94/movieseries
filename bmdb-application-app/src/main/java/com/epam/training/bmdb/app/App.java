package com.epam.training.bmdb.app;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.epam.training.bmdb.domain.Media;
import com.epam.training.bmdb.domain.Rating;
import com.epam.training.bmdb.domain.Review;
import com.epam.training.bmdb.service.Service;
import com.epam.training.bmdb.view.ConsoleView;
import com.epam.training.bmdb.view.IO;
import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.service.ConsoleReviewService;
import com.epam.training.bmdb.view.View;

public class App {
    @Autowired
    IO io;
    @Autowired
    private ConsoleReviewService service;
    @Autowired
    private ConsoleView view;
    @Autowired
    User activeUser;

    @Autowired
    private I18N i18N;

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
            anotherReview = io.consoleIn(i18N.otherReviewMessage).toUpperCase();
        } while (anotherReview.contentEquals(i18N.otherReviewYes));
    }

    private void createUser() {
        io.consoleOut(i18N.registerMessage);
        User newUser = new User();
        newUser.setName(io.consoleIn(i18N.yourNameMessage));
        newUser.setEmail(io.consoleIn(i18N.emailMessage));
        newUser.setPassWord(io.consoleIn(i18N.passWordMessage));

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
            long id = Long.parseLong(io.consoleIn(i18N.chooseId));

            int i = 0;
            while (i < medias.size() && !medias.get(i).getId().equals(id)) {
                i++;
            }
            if (i < medias.size()) {
                selectedMedia = medias.get(i);
            }
        } while (selectedMedia == null);

        review.setText(io.consoleIn(i18N.writeReview));

        do {
            String rating = io.consoleIn(i18N.chooseRatingMessage).toUpperCase();
            if (rating.contentEquals(i18N.badRating)) {
                review.setRating(Rating.BAD);
            }
            if (rating.contentEquals(i18N.averageRating)) {
                review.setRating(Rating.AVERAGE);
            }
            if (rating.contentEquals(i18N.goodRating)) {
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
        io.consoleOut(i18N.reviewAverage + sum / selectedMedia.getReviews().size());
    }
}
