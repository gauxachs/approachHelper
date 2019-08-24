package com.analyzer.approachHelper.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewControllerTest {

    private static final String PRODUCT_ID = "PRODUCT_ID";
    private static final String SCORE = "100";

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetProductReviewStatusOk() throws Exception {
        mvc.perform(get("/reviews")
                .param("productId", PRODUCT_ID))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetReview() throws Exception {
        mvc.perform(get("/reviews")
                .param("productId", PRODUCT_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("score").value(SCORE));
    }

}