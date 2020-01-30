package com.epam.training.bmdb.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.training.bmdb.domain.Media;
import com.epam.training.bmdb.repository.MediaRepository;

@Controller
public class MediasController {

    @Autowired MediaRepository mediaRepository;

    @GetMapping(path = "/media")
    public String medias(Model model){
        model.addAttribute("medias", mediaRepository.findAll());
        return "media";
    }

    @GetMapping("/media/{id}")
    public String cast(@PathVariable Long id, Model model){
        Media media=mediaRepository.findById(id).get();
        model.addAttribute("media", media);
        return "cast";
    }
}
