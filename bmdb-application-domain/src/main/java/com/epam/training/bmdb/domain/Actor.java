package com.epam.training.bmdb.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {
    @Id
    String name;
    LocalDate born;
    @Enumerated(EnumType.STRING)
    Sex sex;
    String biography;
    @ManyToMany
    List<Media> filmography;

    public Actor(){}

    private Actor(Builder builder) {
        this.name = builder.name;
        this.born = builder.born;
        this.sex = builder.sex;
        this.biography = builder.biography;
        this.filmography = builder.filmography;
    }

    public static Builder newActor() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Media> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<Media> filmography) {
        this.filmography = filmography;
    }

    public void addMovieToFilmography(Media media){
        this.filmography.add(media);
    }

    @Override public String toString() {
        return "\tname= " + name + ", " +
            "born=" + born+ '\n';
    }

    public static final class Builder {
        private String name;
        private LocalDate born;
        private Sex sex;
        private String biography;
        private List<Media> filmography=new ArrayList<>();

        private Builder() {
        }

        public Actor build() {
            return new Actor(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder born(LocalDate born) {
            this.born = born;
            return this;
        }

        public Builder sex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public Builder biography(String biography) {
            this.biography = biography;
            return this;
        }

        public Builder filmography(List<Media> filmography) {
            this.filmography = filmography;
            return this;
        }
    }
}
