package dev.noroom.thuvien.service;

import dev.noroom.thuvien.model.Book;

import java.util.List;


public interface BookService  {

    List<Book> getAllBooks();

    boolean deleteBook(long id);

    boolean addBook(Book book);

    Book getBookById(long id);

    boolean updateBook(long id, Book book);
}
