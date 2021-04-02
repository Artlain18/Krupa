package com.example.Krupa.controllers;


import com.example.Krupa.models.review;

import com.example.Krupa.repo.reviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private reviewRepository reviewRepository;
    @GetMapping("/reviews")
    public String getReview(Model model) {
        Iterable<review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);
        //reviewRepository.getreviewBy(1);
        return "allReviews";

    }
}