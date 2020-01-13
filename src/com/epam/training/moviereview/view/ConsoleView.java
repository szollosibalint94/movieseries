package com.epam.training.moviereview.view;


import com.epam.training.moviereview.domain.User;

public class ConsoleView implements View {
    User thisUser=new User();
    IO io=new IO();

    @Override public User readUserData() {
        thisUser.setName(io.consoleIn("What is your name?"));
        return thisUser;
    }

    @Override public void printWelcomeMessage(User user) {
        io.consoleOut("Welcome " + user.getName() + " to the movie and series review application. ");
    }

    @Override public void printMedias() {

    }

    @Override public void printReviews(User user) {

    }
}
