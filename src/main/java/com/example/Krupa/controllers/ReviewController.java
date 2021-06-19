package com.example.Krupa.controllers;


import com.example.Krupa.models.game;
import com.example.Krupa.models.review;

import com.example.Krupa.models.users;
import com.example.Krupa.repo.reviewRepository;
import com.example.Krupa.service.GameService;
import com.example.Krupa.service.ReviewService;
import com.example.Krupa.service.StatusService;
import com.example.Krupa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        //return "allReviews";
        return "list_review";
    }@GetMapping("/myReviews")
    public String getMyReview(Model model) {
        //List<review> reviews = Reviewservice.findAllBystatusID(statusService.findBystatusID(1));
        //Reviewservice.findAllBystatusID(statusService.findBystatusID(1))
        String name = userService.getCurrentUsername();
        users user = userService.findByName(name);
        model.addAttribute("reviews", Reviewservice.findAllUSER_ID(userService.findByuserID(user.getUserID())));
        //reviewRepository.getreviewBy(1);
        //return "allReviews";
        return "list_review";
    }

    @GetMapping("/addReview")
    public String addReview(Model model) {
        review review = new review();

        model.addAttribute("readReview", review);

        return "addNewReview";

    }
    @PostMapping("/addReview")
    public String addReviewPost(@Valid @ModelAttribute("review") review review, Model model) {
        //userService.findByUSER_ID(USER_ID);

        String name = userService.getCurrentUsername();
        users user = userService.findByName(name);
        review.setUSER_ID(user);
        Reviewservice.addNewReview(review);
        return "redirect:/reviews";
    }
    @GetMapping("/review/{id}")
    public String readReview(@PathVariable(value = "id") Integer REVIEW_ID, Model model) {
        model.addAttribute("readReview", Reviewservice.ReadReview(REVIEW_ID));
        //return "review-details";
        return "show_review";

    }
    @GetMapping("/review/{id}/edit")
    public String editReview(@PathVariable(value = "id") Integer REVIEW_ID, Model model) {
        review review = Reviewservice.findByReviewID(REVIEW_ID);
        model.addAttribute("readReview", review);
        //return "review-edit";
        return "review_edit";
    }
    @PostMapping("/updateReview")
    public String updateReview(@Valid review review, BindingResult bindingResult)
    {
        Reviewservice.UpdateOldReview(review, review.getReviewID());
        return "redirect:/reviews";
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
    @PostMapping("/review/{id}/{statusID}/ban")
    public String addReviewPostBan(@PathVariable(value = "id") Integer REVIEW_ID, @PathVariable(value = "statusID") Integer STATUS_ID, Model model) {
        Reviewservice.BanReview(REVIEW_ID, statusService.findBystatusID(STATUS_ID));
        return "redirect:/reviews";
    }
}