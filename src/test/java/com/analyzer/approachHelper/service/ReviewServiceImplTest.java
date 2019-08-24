package com.analyzer.approachHelper.service;

import com.analyzer.approachHelper.domain.Review;
import com.analyzer.approachHelper.repository.ReviewRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceImplTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String SCORE = "100";

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Before
    public void setUp() {
        var review = mock(Review.class);
        when(review.getScore()).thenReturn(SCORE);

        when(reviewRepository.findByProductId(PRODUCT_ID)).thenReturn(Lists.newArrayList(review));
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
    }

}