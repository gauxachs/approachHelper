package com.analyzer.approachHelper.dto;

public class ProductResponse {

    private final String id;

    private final String description;

    public ProductResponse(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
