package com.analyzer.approachHelper.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewRequest {

    private String productId;

    @JsonCreator
    public ReviewRequest(@JsonProperty("productId") String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
