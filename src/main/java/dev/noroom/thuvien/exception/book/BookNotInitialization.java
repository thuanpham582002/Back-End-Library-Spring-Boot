package dev.noroom.thuvien.exception.book;

import dev.noroom.thuvien.payload.response.MessageResponse;

public class BookNotInitialization extends BookException {
    public BookNotInitialization() {
        messageResponse = new MessageResponse("Book not initialization");
    }
}
