package dev.noroom.thuvien.service.impl;

import dev.noroom.thuvien.exception.book.*;
import dev.noroom.thuvien.model.Book;
import dev.noroom.thuvien.repository.BookRepository;
import dev.noroom.thuvien.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(long id) throws BookException {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.delete(book);
            return true;
        } else {
            throw new BookNotFoundExceptionById(id);
        }
    }

    @Override
    public boolean addBook(Book book) {
        if (book != null) {
            if (bookRepository.existsByTitle(book.getTitle())) {
                throw new DuplicateBookExceptionByTitle(book.getTitle());
            } else if (bookRepository.existsByAuthor(book.getAuthor())) {
                throw new DuplicateBookExceptionByAuthor(book.getAuthor());
            } else {
                bookRepository.save(book);
                return true;
            }
        } else {
            throw new BookNotInitialization();
        }
    }
}
