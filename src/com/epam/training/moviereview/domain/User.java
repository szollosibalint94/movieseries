package com.epam.training.moviereview.domain;

import java.time.LocalDate;

public class User {
    String name;
    LocalDate born;

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
}
