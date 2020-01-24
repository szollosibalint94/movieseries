package com.epam.training.bmdb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private static final String HOME_URL = "/";

    @RequestMapping(value = HOME_URL)
    public String homePage(){
        return "home";
    }
}
