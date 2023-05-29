package dev.noroom.thuvien.repository;

import dev.noroom.thuvien.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ReviewRepository   extends JpaRepository<Review, Integer> {
}
