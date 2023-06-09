package dev.noroom.thuvien.controller;


import dev.noroom.thuvien.model.Book;
import dev.noroom.thuvien.model.dto.BookDto;
import dev.noroom.thuvien.model.dto.OrderDto;
import dev.noroom.thuvien.service.BookService;
import dev.noroom.thuvien.service.GenreService;
import dev.noroom.thuvien.service.OrderService;
import dev.noroom.thuvien.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BookController {

    final private BookService bookService;

    final private OrderService orderService;

    final private ReviewService reviewService;

    final private GenreService genreService;

    BookController(BookService bookService, OrderService orderService, ReviewService reviewService, GenreService genreService) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.reviewService = reviewService;
        this.genreService = genreService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<Book> book = bookService.getAllBooks();
        if (book != null) {
            Collections.reverse(book);
            return ResponseEntity.ok(BookDto.fromList(book, genreService));
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable long id) {
        System.out.println(id);
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(BookDto.fromBook(book, genreService));
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody BookDto bookDto) {
        if (bookService.updateBook(id, BookDto.toBook(bookDto, false))) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto) {
        System.out.println(BookDto.toBook(bookDto, true));
        if (bookService.addBook(BookDto.toBook(bookDto, true))) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @GetMapping("/orders/{bookId}")
    public ResponseEntity<List<OrderDto>> getOrdersByBookId(@PathVariable long bookId) {
        List<OrderDto> orders = orderService.getOrdersByBookId(bookId);
        return ResponseEntity.ok(orders);
    }
}
