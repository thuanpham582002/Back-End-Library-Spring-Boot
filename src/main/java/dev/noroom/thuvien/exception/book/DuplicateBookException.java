package dev.noroom.thuvien.exception.book;

import dev.noroom.thuvien.exception.CustomException;
import dev.noroom.thuvien.exception.ErrorResponse;

public class DuplicateBookException extends CustomException {
    public DuplicateBookException(String errorCode, String message) {
        errorResponse = new ErrorResponse(errorCode, message);
    }
}

