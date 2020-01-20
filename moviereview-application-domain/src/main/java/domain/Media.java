package domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Media {
    BigDecimal id;
    String title;
    String description;
    LocalDate premier;
    List<Review> reviews;
    List<Actor> cast;

    public Media() {}

    private Media(Builder builder) {
        this.id=builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.premier = builder.premier;
        this.reviews = builder.reviews;
        this.cast = builder.cast;
    }

    public static Builder newMedia() {
        return new Builder();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
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

    public void addCast(Actor actor){this.cast.add(actor);}

    public void addReview(Review review){this.reviews.add(review);}

    @Override public String toString() {
        return id + ": " +
            "Media{" +
            "Title='" + title + '\'' +
            ", Description='" + description + '\'' +
            ", Premier=" + premier +
            ", Cast=" + cast +
            ", Reviews=" + reviews +
            '}';
    }

    public static final class Builder {
        private BigDecimal id;
        private String title;
        private String description;
        private LocalDate premier;
        private List<Review> reviews=new ArrayList<>();
        private List<Actor> cast=new ArrayList<>();

        private Builder() {
        }

        public Media build() {
            return new Media(this);
        }

        public Builder id(BigDecimal id){
            this.id=id;
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
