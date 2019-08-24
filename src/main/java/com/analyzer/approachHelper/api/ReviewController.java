package com.analyzer.approachHelper.api;

import com.analyzer.approachHelper.domain.Review;
import com.analyzer.approachHelper.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public Review getReview(@PathParam("productId") String productId) {
        return reviewService.getReviewByProductId(productId);
    }
    
}
