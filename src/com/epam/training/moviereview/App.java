package com.epam.training.moviereview;

import com.epam.training.moviereview.domain.User;
import com.epam.training.moviereview.service.ReviewService;

import com.epam.training.moviereview.view.ConsoleView;
import com.epam.training.moviereview.view.View;

public class App {
    User user;

    public App(ReviewService service, View view) {
        this.service = service;
        this.view=view;
    }

    ReviewService service;
    View view;

    public static void main(String[] args) {
        App app=new App(new ReviewService(), new ConsoleView());
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

    }

    private void printReview(){}
}
