package com.epam.training.bmdb.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Component
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String name;
    String passWord;
    @Transient
    private String passwordConfirm;
    @OneToMany(cascade = CascadeType.ALL)
    List<Review> reviews;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Role> roles;

    public User() {
    }

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.passWord = builder.passWord;
        this.reviews = builder.reviews;
        this.roles = builder.roles;
    }

    public static Builder newUser() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPasswordConfirm(String passwordConfirm){
        this.passwordConfirm=passwordConfirm;
    }

    public String getPasswordConfirm(){
        return this.passwordConfirm;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles){
        this.roles=roles;
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
        private List<Review> reviews = new ArrayList<>();
        private List<Role> roles = new ArrayList<>();

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

        public Builder addrole(Role role) {
            this.roles.add(role);
            return this;
        }
    }
}
