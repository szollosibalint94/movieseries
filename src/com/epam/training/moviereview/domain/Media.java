package com.epam.training.moviereview.domain;

import java.time.LocalDate;
import java.util.List;

public class Media {
    String title;
    LocalDate premier;
    List<Review> reviews;
    List<Actor> actors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPremier() {
        return premier;
    }

    public void setPremier(LocalDate premier) {
        this.premier = premier;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
