package com.epam.training.bmdb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.epam.training.bmdb.domain.User;
import com.epam.training.bmdb.web.security.BmdbSecurityService;
import com.epam.training.bmdb.web.security.BmdbUserService;
import com.epam.training.bmdb.web.security.BmdbUserValidator;

@Controller
public class UserController {
    @Autowired
    private BmdbUserService userService;

    @Autowired
    private BmdbSecurityService securityService;

    @Autowired
    private BmdbUserValidator userValidator;

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
}
