package dev.noroom.thuvien.exception.book;

import dev.noroom.thuvien.payload.response.MessageResponse;

public abstract class BookException extends RuntimeException {
    public MessageResponse messageResponse;
}
