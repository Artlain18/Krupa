package com.example.Krupa.service;
import com.example.Krupa.models.game;
import com.example.Krupa.models.review;
import com.example.Krupa.models.status;
import com.example.Krupa.models.users;
import com.example.Krupa.repo.gameRepository;
import com.example.Krupa.repo.reviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private reviewRepository ReviewRepository;

    @Autowired
    public ReviewService(reviewRepository ReviewRepository) {
        this.ReviewRepository = ReviewRepository;
    }

    public review addReview(String NAME, String MESSAGE, users USER_ID, game GAME_ID, Double SCORE, status STATUS_ID) {
        review newReview = new review(NAME, MESSAGE, USER_ID, GAME_ID, SCORE, STATUS_ID);
        return ReviewRepository.save(newReview);
    }
    public List<review> AllReviews() {
        List<review> reviews = ReviewRepository.findAll();
        return reviews;
    }
    public List<review> findAllBystatusID (status statusID) {
        List<review> reviews = ReviewRepository.findAllBystatusID(statusID);
        return reviews;
    }
}
