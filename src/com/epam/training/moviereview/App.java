package com.epam.training.moviereview;

import com.epam.training.moviereview.service.ConsoleReviewService;

import com.epam.training.moviereview.view.ConsoleView;
import com.epam.training.moviereview.view.View;

public class App {

    public App(ConsoleReviewService service, View view) {
        this.service = service;
        this.view=view;
    }

    ConsoleReviewService service;
    View view;

    public static void main(String[] args) {
        App app=new App(new ConsoleReviewService(), new ConsoleView());
        app.play();
    }

    public void play(){
        createUser();
        doReview();
        printReview();
    }

    private void createUser(){
        service.saveUser(view.readUserData());
    }

    private void doReview(){
        view.printWelcomeMessage(service.findUser());
    }

    private void printReview(){}
}
