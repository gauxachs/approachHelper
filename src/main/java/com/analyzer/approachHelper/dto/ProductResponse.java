package com.analyzer.approachHelper.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {

    private final String id;

    private final String description;

    @JsonCreator
    public ProductResponse(@JsonProperty("id") String id,
                           @JsonProperty("description") String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
