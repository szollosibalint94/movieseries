package com.epam.training.moviereview.view;

import com.epam.training.moviereview.domain.User;

public interface View {
    User readUserData();

    void printWelcomeMessage(User user);

    void printReviews(User user);
}
