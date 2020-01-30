package com.epam.training.bmdb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.training.bmdb.domain.Review;
import com.epam.training.bmdb.domain.Media;
import com.epam.training.bmdb.repository.MediaRepository;
import com.epam.training.bmdb.repository.ReviewRepository;
import com.epam.training.bmdb.repository.UserRepository;

@Controller
public class ReviewController {

    @Autowired MediaRepository mediaRepository;
    @Autowired ReviewRepository reviewRepository;
    @Autowired UserRepository userRepository;

    Long mediaId;

    @GetMapping("/review/{id}")
    public String reviewPage(@PathVariable Long id, Model model){
        model.addAttribute("media", mediaRepository.findById(id).get());
        model.addAttribute("review", new Review());
        mediaId=id;
        return "review";
    }

    @PostMapping("/save")
    public String saveReview(@ModelAttribute Review review){
        Media media= mediaRepository.findById(mediaId).get();
        review.setCreator(userRepository.findById("gergo093@hotmail.com").get());
        review.setMedia(media);
        media.addReview(review);
        reviewRepository.save(review);
        mediaRepository.save(media);
        return "redirect:/media";
    }
}
