package com.analyzer.approachHelper.dto;

public class ProductResponse {

    private final String id;

    public ProductResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id='" + id + '\'' +
                '}';
    }
}
