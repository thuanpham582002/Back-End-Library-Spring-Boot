package dev.noroom.thuvien.exception.book;

import dev.noroom.thuvien.payload.response.MessageResponse;

public class DuplicateBookExceptionByTitle extends BookException {
    public DuplicateBookExceptionByTitle(String title) {
        messageResponse = new MessageResponse("Book already exists with title: " + title);
    }
}

