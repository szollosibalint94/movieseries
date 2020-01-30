package com.epam.training.bmdb.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Movie extends Media {
    public Movie() {
    }

    private Movie(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.premier = builder.premier;
        this.reviews = builder.reviews;
        this.cast = builder.cast;
    }

    public static Builder newMovie() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String title;
        private String description;
        private LocalDate premier;
        private List<Review> reviews = new ArrayList<>();
        private List<Actor> cast = new ArrayList<>();

        private Builder() {
        }

        public Media build() {
            return new Movie(this);
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder premier(LocalDate premier) {
            this.premier = premier;
            return this;
        }

        public Builder reviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public Builder cast(List<Actor> cast) {
            this.cast = cast;
            return this;
        }
    }
}
