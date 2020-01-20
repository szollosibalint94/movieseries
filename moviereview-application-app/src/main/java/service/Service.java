package service;

import java.util.List;

import domain.Media;
import domain.Review;
import domain.User;

public interface Service {
    public void saveUser(User user);

    public User findUser();

    public List<Media> findAllMedia();

    public void saveReview(Media media, Review review);

    public List<Review> findAllReview(Media media);
}
