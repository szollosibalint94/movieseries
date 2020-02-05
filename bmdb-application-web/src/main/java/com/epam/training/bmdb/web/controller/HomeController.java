package com.epam.training.bmdb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.repository.ReviewRepository;
import com.epam.training.bmdb.repository.UserRepository;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/home")
    public String showWagerListAndRequestPlayer(User user, Model model, Authentication authentication) {
        user=userRepository.findByEmail(authentication.getName());
        model.addAttribute("user", user);
        model.addAttribute("reviews", reviewRepository.findAllByCreator(user));
        return "home";
    }

    @PostMapping("/saveUser")
    public String savePlayer(User user, Model model) {
        userRepository.save(user);
        model.addAttribute("wagers", reviewRepository.findAll());
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable Long id){
        reviewRepository.deleteById(id);
        return "home";
    }

    @GetMapping("/welcome")
    public String loginSuccess(){
        return "redirect:/home";
    }

    @GetMapping("/adminPage")
    public String getAdminPage(){
        return "adminPage";
    }
}
