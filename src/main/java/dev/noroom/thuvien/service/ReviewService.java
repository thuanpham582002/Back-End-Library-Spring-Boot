package dev.noroom.thuvien.service;

import dev.noroom.thuvien.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    boolean addReview(Review review);

    boolean deleteReview(long id);

    boolean updateReview(long id, Review review);

    Review getReviewByOrderId(int id);
}
