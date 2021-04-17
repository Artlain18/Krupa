package com.example.Krupa.service;
import com.example.Krupa.models.game;
import com.example.Krupa.models.review;
import com.example.Krupa.models.status;
import com.example.Krupa.models.users;
import com.example.Krupa.repo.gameRepository;
import com.example.Krupa.repo.reviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ArrayList<review> ReadReview(Integer REVIEW_ID) {
        Optional<review> review = ReviewRepository.findById(REVIEW_ID);
        ArrayList<review> readReview = new ArrayList<>();
        review.ifPresent(readReview::add);
        return readReview;
    }
    public review UpdateReview(Integer REVIEW_ID, String NAME, String MESSAGE) {
        review review = ReviewRepository.findById(REVIEW_ID).orElseThrow();
        review.setNAME(NAME);
        review.setMESSAGE(MESSAGE);
        ReviewRepository.save(review);
        return review;
    }
    public void DeleteReview(Integer REVIEW_ID) {
        ReviewRepository.delete(ReviewRepository.findById(REVIEW_ID).orElseThrow());
    }

    public review findByreviewID (Integer REVIEW_ID) {

        return ReviewRepository.findByreviewID(REVIEW_ID);
    }
}
