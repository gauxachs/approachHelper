package com.analyzer.approachHelper.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ReviewResponse {

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("score")
    private String score;

    @JsonProperty("date")
    private LocalDateTime date;

    @JsonCreator
    public ReviewResponse(String productId,
                          String score,
                          LocalDateTime date) {
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

    public LocalDateTime getLocalDate() {
        return date;
    }
}
