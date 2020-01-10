package com.epam.training.moviereview.domain;

public class Review {
    String text;
    User creator;
    Media reviewOf;
    Rating rating;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Media getReviewOf() {
        return reviewOf;
    }

    public void setReviewOf(Media reviewOf) {
        this.reviewOf = reviewOf;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
