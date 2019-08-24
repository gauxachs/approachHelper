package com.analyzer.approachHelper.service;

import com.analyzer.approachHelper.domain.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviewsByProductId(String productId);
}
