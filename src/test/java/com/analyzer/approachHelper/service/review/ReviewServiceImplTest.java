package com.analyzer.approachHelper.service.review;

import com.analyzer.approachHelper.domain.Product;
import com.analyzer.approachHelper.domain.Review;
import com.analyzer.approachHelper.repository.ReviewRepository;
import com.analyzer.approachHelper.service.product.ProductService;
import com.analyzer.approachHelper.service.review.ReviewServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceImplTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String SCORE = "100";
    private static final LocalDateTime REVIEW_DATE = LocalDateTime.now();

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Before
    public void setUp() {
        var review = mock(Review.class);
        when(review.getScore()).thenReturn(SCORE);
        when(review.getDate()).thenReturn(REVIEW_DATE);

        when(reviewRepository.findByProductId(PRODUCT_ID)).thenReturn(Lists.newArrayList(review));
        when(reviewRepository.save(any(Review.class))).thenReturn(review);

        var product = mock(Product.class);
        when(productService.getProduct(PRODUCT_ID)).thenReturn(product);
    }

    @Test
    public void testCorrectSizeGetReviewsByProductId() {
        var reviews = reviewService.getReviewsByProductId(PRODUCT_ID);

        assertThat(reviews).isNotNull();
        assertThat(reviews.size()).isEqualTo(1);
    }

    @Test
    public void testContentGetReviewsByProductId() {
        var reviews = reviewService.getReviewsByProductId(PRODUCT_ID);

        assertThat(reviews.get(0)).isNotNull();
        assertThat(reviews.get(0).getScore()).isEqualTo(SCORE);
        assertThat(reviews.get(0).getDate()).isEqualTo(REVIEW_DATE);
    }

    @Test
    public void testCreateReview() {
        var review = reviewService.createReview(PRODUCT_ID);

        assertThat(review.getScore()).isEqualTo(SCORE);
        verify(reviewRepository).save(any(Review.class));
    }
}