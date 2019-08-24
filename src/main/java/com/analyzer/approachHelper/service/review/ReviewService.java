package com.analyzer.approachHelper.service.review;

import com.analyzer.approachHelper.domain.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewsByProductId(String productId);

    Review createReview(String productId);
}
