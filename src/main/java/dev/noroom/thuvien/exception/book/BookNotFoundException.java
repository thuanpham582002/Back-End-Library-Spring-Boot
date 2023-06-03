package dev.noroom.thuvien.exception.book;

import dev.noroom.thuvien.exception.CustomException;
import dev.noroom.thuvien.exception.ErrorResponse;

public class BookNotFoundException extends CustomException {
    public BookNotFoundException(long id) {
        errorResponse = new ErrorResponse("Book not found with id: " + id);
    }
}
