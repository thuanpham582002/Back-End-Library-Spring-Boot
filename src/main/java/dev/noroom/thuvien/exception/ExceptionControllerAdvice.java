package dev.noroom.thuvien.exception;

import dev.noroom.thuvien.exception.book.BookNotFoundException;
import dev.noroom.thuvien.exception.book.DuplicateBookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = {BookNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex) {
        return ResponseEntity.badRequest()
                .body(ex.errorResponse);
    }

    @ExceptionHandler(value = {DuplicateBookException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleDuplicateBookException(DuplicateBookException ex) {
        return ResponseEntity.badRequest()
                .body(ex.errorResponse);
    }
}