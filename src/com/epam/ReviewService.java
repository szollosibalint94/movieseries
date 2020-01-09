package com.epam;

import java.util.List;

public interface ReviewService {
    void saveUser(User user);
    User findUser();
    List<Media> findAllMedia();
    void saveReview(Review review);
    List<Review> findAllReview();
}
