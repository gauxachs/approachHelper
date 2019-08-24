package com.analyzer.approachHelper.service.review;

import com.analyzer.approachHelper.domain.Review;
import com.analyzer.approachHelper.repository.ReviewRepository;
import com.analyzer.approachHelper.service.product.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    private ProductService productService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductService productService) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
    }

    @Override
    public List<Review> getReviewsByProductId(String productId) {
        return reviewRepository.findByProductId(productId);
    }

    @Override
    @Transactional
    public Review createReview(String productId) {
        var product = productService.getProduct(productId);

        var review = new Review("", product);

        return reviewRepository.save(review);
    }

}
