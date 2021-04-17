package com.example.Krupa.service;

import com.example.Krupa.models.*;
import com.example.Krupa.repo.reviewLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewLikeService {

    private reviewLikeRepository ReviewLikeRepository;

    @Autowired
    public ReviewLikeService(reviewLikeRepository ReviewLikeRepository) {
        this.ReviewLikeRepository = ReviewLikeRepository;
    }

    public List<reviewLike> AllReviewsLikes() {
        List<reviewLike> reviewLikes = ReviewLikeRepository.findAll();
        return reviewLikes;
    }
    public reviewLike addReviewLikes(users USER_ID, review REVIEW_ID) {
        reviewLike newReviewLike = new reviewLike(USER_ID, REVIEW_ID);
        newReviewLike.setUSER_ID(USER_ID);
        newReviewLike.setREVIEW_ID(REVIEW_ID);
        newReviewLike.setIS_REVIEW_LIKE(true);
        routeReviewLike route = new routeReviewLike(USER_ID.getUserID(), REVIEW_ID.getReviewID());
        newReviewLike.setId(route);
        return ReviewLikeRepository.save(newReviewLike);
    }
}
