package com.example.Krupa.controllers;

import com.example.Krupa.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StatusController {
    private final StatusService statusService;
    @Autowired
    private com.example.Krupa.repo.statusRepository statusRepository;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
    @GetMapping("/addStatus")
    public String addStatus(Model model) {
        return "addStatus";

    }
    @PostMapping("/addStatus")
    public String addStatusPost(@RequestParam String statusMessage, Model model) {

        statusService.addStatus(statusMessage);
        return "redirect:/games";
    }
}
