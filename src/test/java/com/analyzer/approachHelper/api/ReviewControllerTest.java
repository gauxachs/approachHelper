package com.analyzer.approachHelper.api;

import com.analyzer.approachHelper.domain.Product;
import com.analyzer.approachHelper.domain.Review;
import com.analyzer.approachHelper.dto.ReviewRequest;
import com.analyzer.approachHelper.service.review.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewControllerTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String SCORE = "100";
    private static final LocalDateTime REVIEW_DATE = LocalDateTime.now();

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ReviewService reviewService;

    @Before
    public void setUp() {
        var review = mock(Review.class);
        when(review.getScore()).thenReturn(SCORE);
        when(review.getDate()).thenReturn(REVIEW_DATE);

        var product = mock(Product.class);
        when(product.getId()).thenReturn(PRODUCT_ID);
        when(review.getProduct()).thenReturn(product);

        when(reviewService.getReviewsByProductId(PRODUCT_ID)).thenReturn(Lists.newArrayList(review));
        when(reviewService.createReview(PRODUCT_ID)).thenReturn(review);
    }

    @Test
    public void testGetProductReviewStatusOk() throws Exception {
        mvc.perform(get("/reviews")
                .param("productId", PRODUCT_ID))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetReviewsByProductId() throws Exception {
        mvc.perform(get("/reviews")
                .param("productId", PRODUCT_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].score").value(SCORE))
                .andExpect(jsonPath("[0].date").value(REVIEW_DATE.toString()));
    }

    @Test
    public void testCreateProductReview() throws Exception {
        var reviewRequest = new ReviewRequest(PRODUCT_ID);

        var body = objectMapper.writeValueAsString(reviewRequest);

        mvc.perform(post("/reviews")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("score").exists());
    }
}