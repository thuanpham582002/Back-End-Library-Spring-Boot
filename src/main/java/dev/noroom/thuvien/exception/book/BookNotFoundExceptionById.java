package dev.noroom.thuvien.exception.book;

import dev.noroom.thuvien.payload.response.MessageResponse;

public class BookNotFoundExceptionById extends BookException {
    public BookNotFoundExceptionById(long id) {
        messageResponse = new MessageResponse("Book not found with id: " + id);
    }
}
