package com.analyzer.approachHelper.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewResponse {

    private String productId;

    private String score;

    @JsonCreator
    public ReviewResponse(@JsonProperty("productId") String productId,
                          @JsonProperty("score") String score) {
        this.productId = productId;
        this.score = score;
    }

    public String getProductId() {
        return productId;
    }

    public String getScore() {
        return score;
    }
}
