package dev.noroom.thuvien.repository;

import dev.noroom.thuvien.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByBookId(Long bookId);

    List<Order> findAllByUserId(Long userId);

    Order findByUserIdAndBookId(Long userId, Long bookId);
}
