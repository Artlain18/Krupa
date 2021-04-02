package com.example.Krupa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    /*@GetMapping("/reviews")
    public String listReviews(Model model) {
        return "allReviews";
    }*/

}
