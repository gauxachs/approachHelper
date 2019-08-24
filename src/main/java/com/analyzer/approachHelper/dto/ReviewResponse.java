package com.analyzer.approachHelper.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ReviewResponse {

    private String productId;

    private String score;

    private LocalDateTime date;

    @JsonCreator
    public ReviewResponse(@JsonProperty("productId") String productId,
                          @JsonProperty("score") String score,
                          @JsonProperty("date") LocalDateTime date) {
        this.productId = productId;
        this.score = score;
        this.date = date;
    }

    public String getProductId() {
        return productId;
    }

    public String getScore() {
        return score;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
