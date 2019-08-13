package com.analyzer.approachHelper.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApproachResponse {

    private String productId;

    private String code;

    @JsonCreator
    public ApproachResponse(@JsonProperty("productId") String productId,
                            @JsonProperty("code") String code) {
        this.productId = productId;
        this.code = code;
    }

    public String getProductId() {
        return productId;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ApproachResponse{" +
                "productId='" + productId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
