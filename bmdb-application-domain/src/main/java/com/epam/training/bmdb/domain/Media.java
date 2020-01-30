package com.epam.training.bmdb.domain;

import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    LocalDate premier;
    @Enumerated(EnumType.STRING)
    @OneToMany(cascade = CascadeType.ALL)
    List<Review> reviews;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Actor> cast;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public void addCast(Actor actor) {
        this.cast.add(actor);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    @Override public String toString() {
        return id + ":" +
            "'" + title + "\'\n" +
            " Description='" + description + "\'\n" +
            " Premier=" + premier + '\n' +
            " Cast= \n" + cast + '\n' +
            " Reviews=" + reviews;
    }
}
