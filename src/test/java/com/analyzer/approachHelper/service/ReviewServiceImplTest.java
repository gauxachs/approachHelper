package com.analyzer.approachHelper.service;

import com.analyzer.approachHelper.domain.Review;
import com.analyzer.approachHelper.exception.ReviewNotFoundException;
import com.analyzer.approachHelper.repository.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceImplTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String PRODUCT_ID_NOT_FOUND = "PRODUCT_ID_NOT_FOUND";
    private static final String SCORE = "100";

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Before
    public void setUp() {
        var review = mock(Review.class);
        when(review.getScore()).thenReturn(SCORE);

        when(reviewRepository.findByProductId(PRODUCT_ID)).thenReturn(Optional.of(review));
    }

    @Test
    public void testGetReviewByProductId() {
        var review = reviewService.getReviewByProductId(PRODUCT_ID);

        assertThat(review.getScore()).isEqualTo(SCORE);
    }

    @Test(expected = ReviewNotFoundException.class)
    public void testGetReviewByProductIdNotFound() {
        reviewService.getReviewByProductId(PRODUCT_ID_NOT_FOUND);
    }
}