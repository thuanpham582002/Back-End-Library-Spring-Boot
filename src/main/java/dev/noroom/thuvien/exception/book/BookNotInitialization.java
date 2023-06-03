package dev.noroom.thuvien.exception.book;

import dev.noroom.thuvien.exception.CustomException;
import dev.noroom.thuvien.exception.ErrorResponse;

public class BookNotInitialization extends CustomException {
    public BookNotInitialization() {
        errorResponse = new ErrorResponse("Book not initialization");
    }
}
