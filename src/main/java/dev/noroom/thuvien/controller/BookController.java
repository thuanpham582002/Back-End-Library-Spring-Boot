package dev.noroom.thuvien.controller;


import dev.noroom.thuvien.model.Book;
import dev.noroom.thuvien.model.Order;
import dev.noroom.thuvien.model.Review;
import dev.noroom.thuvien.service.BookService;
import dev.noroom.thuvien.service.OrderService;
import dev.noroom.thuvien.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BookController {

    final private BookService bookService;

    final private OrderService orderService;

    final private ReviewService reviewService;

    BookController(BookService bookService, OrderService orderService, ReviewService reviewService) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> book = bookService.getAllBooks();
        if (book != null) {
            return ResponseEntity.ok(book);
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
    public ResponseEntity<?> getBookById(@PathVariable long id) {
        System.out.println(id);
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody Book book) {
        if (bookService.updateBook(id, book)) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        if (bookService.addBook(book)) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @GetMapping("/orders/{bookId}")
    public ResponseEntity<Map<Order, Review>> getOrdersByBookId(@PathVariable long bookId) {
        Map<Order, Review> fullOrders = new java.util.HashMap<>(Map.of());
        System.out.println("getOrdersByBookId");
        List<Order> orders = orderService.getOrdersByBookId(bookId);
        for (Order order : orders) {
            Review review = reviewService.getReviewByOrderId(order.getId());
            fullOrders.put(order, review);
        }
        return ResponseEntity.ok(fullOrders);
    }
}
