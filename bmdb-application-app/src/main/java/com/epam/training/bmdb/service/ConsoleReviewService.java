package service;

import java.util.List;

import domain.Media;
import domain.Review;
import domain.User;
import view.IO;

public class ConsoleReviewService implements Service {
    IO io=new IO();
    User user;

    @Override public void saveUser(User user){
        this.user=user;
    }

    @Override public User findUser(){
        return this.user;
    }

    @Override public List<Media> findAllMedia(){
        BuildMedias buildMedias=new BuildMedias();

        List<Media> mediaList=buildMedias.getMedias();
        printMedias(mediaList);
        return mediaList;
    }

    public void printMedias(List<Media> medias){
        for (Media media: medias) {
            io.consoleOut(media.toString());
        }
    }

    @Override public void saveReview(Media media, Review review){
        media.addReview(review);
        review.setMedia(media);
    }

    @Override public List<Review> findAllReview(Media media){
        return media.getReviews();
    }
}
