package com.epam.training.bmdb.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Component
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    @ManyToOne
    User creator;
    @ManyToOne
    Media media;
    Rating rating;

    public Review() {
    }

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
        return "\t" + id +
            " :'" + text + "\'\n" +
            " rating=" + rating + '\n';
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
