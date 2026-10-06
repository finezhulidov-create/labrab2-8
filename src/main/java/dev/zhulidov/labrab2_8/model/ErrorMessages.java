package dev.zhulidov.labrab2_8.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {
    EMPTY(""),
    VALIDATION("Validation Exception"),
    UNKNOWN("Unknown Exception");

    private final String description;

    ErrorMessages(String description) {
        this.description = description;
    }
    @JsonValue
    public String getDescription() {
        return description;
    }
}
