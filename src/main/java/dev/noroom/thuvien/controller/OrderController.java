package dev.noroom.thuvien.controller;

import dev.noroom.thuvien.model.Order;
import dev.noroom.thuvien.model.Review;
import dev.noroom.thuvien.model.dto.OrderDto;
import dev.noroom.thuvien.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllOrders() {
        List<OrderDto> review = orderService.getAllOrders();
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<?> getOrdersByBookId(@PathVariable Long bookId) {
        List<OrderDto> review = orderService.getOrdersByBookId(bookId);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getOrdersByUserId(@PathVariable Long userId) {
        List<OrderDto> review = orderService.getOrdersByUserId(userId);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody OrderDto orderDto) {
        System.out.println(orderDto);
        if (orderService.addOrder(orderDto)) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        if (orderService.deleteOrder(id)) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestBody OrderDto orderDto) {
        if (orderService.updateOrder(orderDto)) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }


    @PostMapping("/{orderId}/reviews/add")
    public ResponseEntity<String> addReviewToOrder(@PathVariable Long orderId, @RequestBody Review review) {
        Order order = orderService.addReviewToOrder(orderId, review);
        if (order != null) {
            return ResponseEntity.ok("Đánh giá đã được thêm vào đơn hàng");
        }
        return ResponseEntity.notFound().build();
    }
}
