package com.example.Krupa.controllers;


import com.example.Krupa.models.game;
import com.example.Krupa.models.review;
import com.example.Krupa.models.users;
import com.example.Krupa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewLikeController {
    @Autowired
    private ReviewLikeService reviewLikeService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;

    public ReviewLikeController(ReviewLikeService reviewLikeService) {
        this.reviewLikeService = reviewLikeService;
    }
    @GetMapping("/reviewLikes")
    public String getGameLikes(Model model) {
        model.addAttribute("reviewLikes", reviewLikeService.AllReviewsLikes());
        return "reviewLikes";
    }
    @GetMapping("/addReviewLike")
    public String addReviewLike(Model model) {
        return "addReviewLike";
    }
    @PostMapping("/addReviewLike")
    public String addReviewLikesPost(@RequestParam Long USER_ID, @RequestParam Integer REVIEW_ID,  Model model) {
        users user = userService.findByuserID(USER_ID);
        review review = reviewService.findByReviewID(REVIEW_ID)   ;
        reviewLikeService.addReviewLikes(user, review);
        return "redirect:/reviewLikes";
    }
}
