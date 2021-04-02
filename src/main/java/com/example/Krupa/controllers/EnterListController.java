package com.example.Krupa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnterListController {

    @GetMapping("/enter")
    public String greeting(Model model) {
        model.addAttribute("title", "Страница входа");
        return "Enter";
    }

}
