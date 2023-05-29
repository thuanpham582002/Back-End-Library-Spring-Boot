package dev.noroom.thuvien.exception;

import dev.noroom.thuvien.exception.book.BookException;
import dev.noroom.thuvien.exception.book.DuplicateBookExceptionByAuthor;
import dev.noroom.thuvien.exception.book.DuplicateBookExceptionByTitle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = { BookException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBookNotFoundException(BookException ex) {
        return ResponseEntity.badRequest().body(ex.messageResponse);
    }

    @ExceptionHandler(value = { DuplicateBookExceptionByTitle.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleDuplicateBookExceptionByTitle(DuplicateBookExceptionByTitle ex) {
        return ResponseEntity.badRequest().body(ex.messageResponse);
    }

    @ExceptionHandler(value = { DuplicateBookExceptionByAuthor.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBookNotFoundExceptionByAuthor(DuplicateBookExceptionByAuthor ex) {
        return ResponseEntity.badRequest().body(ex.messageResponse);
    }
}