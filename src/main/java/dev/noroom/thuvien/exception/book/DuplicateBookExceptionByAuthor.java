package dev.noroom.thuvien.exception.book;

import dev.noroom.thuvien.payload.response.MessageResponse;

public class DuplicateBookExceptionByAuthor extends BookException {
    public DuplicateBookExceptionByAuthor(String author) {
        messageResponse = new MessageResponse("Book not found with author: " + author);
    }
}
