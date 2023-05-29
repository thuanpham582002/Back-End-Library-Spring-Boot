package dev.noroom.thuvien.service.impl;

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
}
