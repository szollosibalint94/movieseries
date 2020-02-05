package com.epam.training.bmdb.service;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import com.epam.training.bmdb.domain.Media;
import com.epam.training.bmdb.domain.Review;
import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.repository.MediaRepository;
import com.epam.training.bmdb.repository.ReviewRepository;
import com.epam.training.bmdb.repository.UserRepository;
import com.epam.training.bmdb.view.IO;

@Component
public class ConsoleReviewService implements Service {
    @Autowired
    IO io;

    @Autowired UserRepository userRepository;
    @Autowired ReviewRepository reviewRepository;
    @Autowired MediaRepository mediaRepository;

    @Autowired BuildMedias buildMedias;

    private Logger LOGGER = LoggerFactory.getLogger(ConsoleReviewService.class);

    @Override public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override public User findUser(String id) {
        if (id.contains("@")) {
            return userRepository.findByEmail(id);
        } else {
            return userRepository.findByEmail(id);
        }
    }

    @Override public List<Media> findAllMedia() {
        buildMedias.buildMedias();

        List<Media> mediaList = mediaRepository.findAll();

        LOGGER.debug("Medias found");
        return mediaList;
    }

    public void printMedias(List<Media> medias) {
        for (Media media : medias) {
            io.consoleOut(media.toString());
        }
    }

    @Override public void saveReview(Media media, Review review) {
        media.addReview(review);
        review.setMedia(media);
        reviewRepository.save(review);
        mediaRepository.save(media);
        LOGGER.debug("Review saved");
    }

    @Override public List<Review> findAllReview(Media media) {
        return media.getReviews();
    }
}
