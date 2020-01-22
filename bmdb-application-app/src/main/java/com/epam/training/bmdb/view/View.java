package view;

import domain.User;

public interface View {
    User readUserData();

    void printWelcomeMessage(User user);

    void printMedias();

    void printReviews(User user);
}
