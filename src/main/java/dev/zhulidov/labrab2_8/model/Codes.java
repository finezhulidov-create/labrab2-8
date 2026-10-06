package dev.zhulidov.labrab2_8.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Codes {
    SUCCESS("success"),
    FAILED("failed");

    @Override
    public String toString() {
        return name;
    }

    private final String name;

    Codes(String name) {
        this.name = name;
    }
    @JsonValue
    public String getName(){
        return name;
    }

}
