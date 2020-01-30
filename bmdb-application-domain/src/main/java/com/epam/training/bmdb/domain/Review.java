package com.epam.training.bmdb.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    @ManyToOne(cascade = CascadeType.ALL)
    User creator;
    @ManyToOne(cascade = CascadeType.ALL)
    Media media;
    @Enumerated(EnumType.STRING)
    Rating rating;

    public Review() {
    }

    private Review(Builder builder) {
        this.id=builder.id;
        this.text = builder.text;
        this.creator = builder.creator;
        this.media = builder.media;
        this.rating = builder.rating;
    }

    public static Builder newReview() {
        return new Builder();
    }

    public Long getId(){
        return id;
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
        private Long id;
        private String text;
        private User creator;
        private Media media;
        private Rating rating;

        private Builder() {
        }

        public Review build() {
            return new Review(this);
        }

        public Builder id(Long id){
            this.id=id;
            return this;
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
