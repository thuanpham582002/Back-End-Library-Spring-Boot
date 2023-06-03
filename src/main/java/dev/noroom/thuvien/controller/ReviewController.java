package dev.noroom.thuvien.controller;

import dev.noroom.thuvien.model.Review;
import dev.noroom.thuvien.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllReviews() {
        List<Review> review = reviewService.getAllReviews();
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<?> addReview(@RequestBody Review review) {
        if (reviewService.addReview(review)) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable long id) {
        if (reviewService.deleteReview(id)) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateReview(@PathVariable long id, @RequestBody Review review) {
        if (reviewService.updateReview(id, review)) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }
}
