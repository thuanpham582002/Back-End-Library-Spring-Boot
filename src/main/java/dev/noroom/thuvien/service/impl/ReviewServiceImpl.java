package dev.noroom.thuvien.service.impl;

import dev.noroom.thuvien.model.Review;
import dev.noroom.thuvien.repository.ReviewRepository;
import dev.noroom.thuvien.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean addReview(Review review) {
        try {
            reviewRepository.save(review);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteReview(long id) {
        try {
            reviewRepository.deleteById((int) id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateReview(long id, Review review) {
        try {
            Review review1 = reviewRepository.findById((int) id)
                    .orElseThrow();
            review1.setOrderId(review.getOrderId());
            review1.setRating(review.getRating());
            review1.setComment(review.getComment());
            reviewRepository.save(review1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Review getReviewByOrderId(long id) {
        Review review = reviewRepository.findByOrderId(id);
        if (review == null) {
            return null;
        }
        return review;
    }
}
