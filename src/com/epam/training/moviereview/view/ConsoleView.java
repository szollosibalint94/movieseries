package com.epam.training.moviereview.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.epam.training.moviereview.domain.User;

public class ConsoleView implements View {
    IO io=new IO();
    @Override public User readUserData() {
        User thisUser=new User();

        thisUser.setName(io.consoleIn("What is your name?"));
        do {
            try {
                thisUser.setBorn(LocalDate.parse(io.consoleIn("When did you bor? (yyyy-mm-dd)"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }catch (DateTimeParseException e){
                io.consoleOut("Cannot convert to date");
            }
        }while (thisUser.getBorn() == null);

        return thisUser;
    }

    @Override public void printWelcomeMessage(User user) {
        io.consoleOut("Welcome to the movie and series review application. In the first step, you have to setup your user!");
    }

    @Override public void printReviews(User user) {

    }
}
