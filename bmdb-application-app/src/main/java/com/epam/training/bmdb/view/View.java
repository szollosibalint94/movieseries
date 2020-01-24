package com.epam.training.bmdb.view;

import com.epam.training.bmdb.domain.User;

public interface View {
    User readUserData();

    void printWelcomeMessage(User user);

    void printMedias();

    void printReviews(User user);
}
