package com.analyzer.approachHelper.dto;

public class CreateProductRequest {

    private String description;

    public CreateProductRequest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
