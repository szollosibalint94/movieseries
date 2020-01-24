package com.epam.training.bmdb.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.training.bmdb.app.I18N;
import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.service.ConsoleReviewService;

@Component
public class ConsoleView implements View {

    @Autowired
    private I18N i18N;

    @Autowired
    IO io;

    @Autowired ConsoleReviewService service;

    @Override public User readUserData() {
        return service.findUser(io.consoleIn(i18N.yourNameMessage));
    }

    public User readUserData(String id) {
        return service.findUser(id);
    }

    @Override public void printWelcomeMessage(User user) {
        io.consoleOut(i18N.welcomeMessage);
    }

    @Override public void printMedias() {

    }

    @Override public void printReviews(User user) {

    }
}
