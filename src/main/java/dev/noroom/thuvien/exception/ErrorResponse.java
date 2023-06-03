package dev.noroom.thuvien.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorCode = "UNKNOWN_ERROR";
    private final String message;

    // Constructor, getters, setters

    public ErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorResponse(String message) {

        this.message = message;
    }

    // ...
}
