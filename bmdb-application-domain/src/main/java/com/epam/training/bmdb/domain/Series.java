package com.epam.training.bmdb.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Series extends Media {

    private Series(){}

    private Series(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.premier = builder.premier;
        this.reviews = new ArrayList<>();
        this.cast = new ArrayList<>();
    }

    public static Builder newSeries() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String title;
        private String description;
        private LocalDate premier;

        private Builder() {
        }

        public Series build() {
            return new Series(this);
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
    }
}
