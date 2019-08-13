package com.analyzer.approachHelper.dto;

public class ApproachResponse {

    private String productId;

    private String code;

    public ApproachResponse(String productId, String code) {
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
