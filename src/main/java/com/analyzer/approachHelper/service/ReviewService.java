package com.analyzer.approachHelper.service;

import com.analyzer.approachHelper.domain.Review;

public interface ReviewService {

    Review getReviewByProductId(String productId);
}
