package dev.noroom.thuvien.service.impl;

import dev.noroom.thuvien.exception.book.BookNotFoundException;
import dev.noroom.thuvien.exception.book.BookNotInitialization;
import dev.noroom.thuvien.exception.book.DuplicateBookException;
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
    public boolean deleteBook(long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElse(null);
        if (book != null) {
            bookRepository.delete(book);
            return true;
        } else {
            throw new BookNotFoundException(id);
        }
    }

    @Override
    public boolean addBook(Book book) {
        if (book != null) {
            if (bookRepository.existsByTitle(book.getTitle())) {
                throw new DuplicateBookException("TITLE_EXISTED", book.getTitle() + " already exists");
            } else if (bookRepository.existsByAuthor(book.getAuthor())) {
                throw new DuplicateBookException("AUTHOR_EXISTED", book.getAuthor() + " already exists");
            } else {
                bookRepository.save(book);
                return true;
            }
        } else {
            throw new BookNotInitialization();
        }
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public boolean updateBook(long id, Book book) {
        if (book != null) {
            Book book1 = bookRepository.findById(id)
                    .orElseThrow();
            if (bookRepository.existsByTitle(book.getTitle()) && !book1.getTitle()
                    .equals(book.getTitle())) {
                throw new DuplicateBookException("TITLE_EXISTED", book.getTitle() + " already exists");
            } else if (bookRepository.existsByAuthor(book.getAuthor()) && !book1.getAuthor()
                    .equals(book.getAuthor())) {
                throw new DuplicateBookException("AUTHOR_EXISTED", book.getAuthor() + " already exists");
            }

            book1.setTitle(book.getTitle());
            book1.setAuthor(book.getAuthor());
            book1.setDescription(book.getDescription());
            System.out.println("GenreID " + book.toString());
            book1.setGenreId(book.getGenreId());
            book1.setReleaseDate(book.getReleaseDate());
            book1.setNumPages(book.getNumPages());
            book1.setSold(book.getSold());
            book1.setSelectedImage(book.getSelectedImage());
            bookRepository.save(book1);
            return true;
        } else {
            throw new BookNotInitialization();
        }
    }
}
