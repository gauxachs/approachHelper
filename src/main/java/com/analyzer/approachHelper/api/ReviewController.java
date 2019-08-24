package com.analyzer.approachHelper.api;

import com.analyzer.approachHelper.dto.ReviewResponse;
import com.analyzer.approachHelper.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewResponse> getReview(@PathParam("productId") String productId) {
        var reviews = reviewService.getReviewsByProductId(productId);

        return reviews.stream()
                .map(review -> new ReviewResponse(review.getProduct().getId(), review.getScore(), review.getDate()))
                .collect(toList());
    }
}
