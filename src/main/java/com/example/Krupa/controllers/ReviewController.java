package com.example.Krupa.controllers;


import com.example.Krupa.models.review;

import com.example.Krupa.repo.reviewRepository;
import com.example.Krupa.service.GameService;
import com.example.Krupa.service.ReviewService;
import com.example.Krupa.service.StatusService;
import com.example.Krupa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {
    private final ReviewService Reviewservice;

    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;
    @Autowired
    private StatusService statusService;

    public ReviewController(ReviewService reviewservice) {
        Reviewservice = reviewservice;
    }

    @GetMapping("/reviews")
    public String getReview(Model model) {
        //List<review> reviews = Reviewservice.findAllBystatusID(statusService.findBystatusID(1));
        //Reviewservice.findAllBystatusID(statusService.findBystatusID(1))
        model.addAttribute("reviews", Reviewservice.AllReviews());
        //reviewRepository.getreviewBy(1);
        return "allReviews";
    }

    @GetMapping("/addReview")
    public String addReview(Model model) {
        return "addReview";

    }
    @PostMapping("/addReview")
    public String addReviewPost(@RequestParam String NAME, @RequestParam String MESSAGE, @RequestParam Integer USER_ID, @RequestParam Integer GAME_ID, @RequestParam Double SCORE, @RequestParam Integer STATUS_ID, Model model) {
        //userService.findByUSER_ID(USER_ID);
        Reviewservice.addReview(NAME, MESSAGE, userService.findByuserID(USER_ID), gameService.findBygameID(GAME_ID), SCORE, statusService.findBystatusID(STATUS_ID));
        return "redirect:/reviews";
    }
    @GetMapping("/review/{id}")
    public String readReview(@PathVariable(value = "id") Integer REVIEW_ID, Model model) {
        model.addAttribute("readReview", Reviewservice.ReadReview(REVIEW_ID));
        return "review-details";

    }
    @GetMapping("/review/{id}/edit")
    public String editReview(@PathVariable(value = "id") Integer REVIEW_ID, Model model) {
        model.addAttribute("readReview", Reviewservice.ReadReview(REVIEW_ID));
        return "review-edit";

    }

    @PostMapping("/review/{id}/edit")
    public String addReviewPostUpdate(@PathVariable(value = "id") Integer REVIEW_ID, @RequestParam String NAME, @RequestParam String MESSAGE, Model model) {
        Reviewservice.UpdateReview(REVIEW_ID, NAME, MESSAGE);
        return "redirect:/reviews";
    }
    @PostMapping("/review/{id}/remove")
    public String addReviewPostDelete(@PathVariable(value = "id") Integer REVIEW_ID, Model model) {
        Reviewservice.DeleteReview(REVIEW_ID);
        return "redirect:/reviews";
    }
}