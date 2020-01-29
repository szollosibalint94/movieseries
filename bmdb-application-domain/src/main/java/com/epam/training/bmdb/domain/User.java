package com.epam.training.bmdb.domain;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Component
@Entity
public class User {
    @Id
    String email;
    String name;
    String passWord;
    @OneToMany(cascade = CascadeType.ALL)
    List<Review> reviews;

    public User() {
    }

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.passWord = builder.passWord;
        this.reviews = builder.reviews;
    }

    public static Builder newUser() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", passWord='" + passWord + '\'' +
            '}';
    }

    public static final class Builder {
        private String name;
        private String email;
        private String passWord;
        private List<Review> reviews;

        private Builder() {
        }

        public User build() {
            return new User(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder passWord(String passWord) {
            this.passWord = passWord;
            return this;
        }

        public Builder reviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }
    }
}
