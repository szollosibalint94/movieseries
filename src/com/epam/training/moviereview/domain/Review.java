package com.epam.training.moviereview.domain;

public class Review {
    String text;
    User creator;
    Media media;
    Rating rating;

    public Review(){}

    private Review(Builder builder) {
        this.text = builder.text;
        this.creator = builder.creator;
        this.media = builder.media;
        this.rating = builder.rating;
    }

    public static Builder newReview() {
        return new Builder();
    }

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

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override public String toString() {
        return "Review{" +
            "text='" + text + '\'' +
            ", creator=" + creator +
            ", rating=" + rating +
            '}';
    }

    public static final class Builder {
        private String text;
        private User creator;
        private Media media;
        private Rating rating;

        private Builder() {
        }

        public Review build() {
            return new Review(this);
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder creator(User creator) {
            this.creator = creator;
            return this;
        }

        public Builder media(Media media) {
            this.media = media;
            return this;
        }

        public Builder rating(Rating rating) {
            this.rating = rating;
            return this;
        }
    }
}
