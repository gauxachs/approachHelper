package com.analyzer.approachHelper.service;

import com.analyzer.approachHelper.domain.Review;
import com.analyzer.approachHelper.exception.ReviewNotFoundException;
import com.analyzer.approachHelper.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review getReviewByProductId(String productId) {
        return reviewRepository.findByProductId(productId)
                .orElseThrow(() -> new ReviewNotFoundException("Review for this product doesn't exists"));
    }
}
