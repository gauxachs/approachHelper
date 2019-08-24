package com.analyzer.approachHelper.api;

import com.analyzer.approachHelper.dto.ReviewRequest;
import com.analyzer.approachHelper.dto.ReviewResponse;
import com.analyzer.approachHelper.service.review.ReviewService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ReviewResponse createReview(@RequestBody ReviewRequest reviewRequest) {
        var review = reviewService.createReview(reviewRequest.getProductId());

        var productId = review.getProduct().getId();
        var score = review.getScore();
        var date = review.getDate();

        return new ReviewResponse(productId, score, date);
    }
}
