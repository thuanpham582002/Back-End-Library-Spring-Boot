package dev.noroom.thuvien.repository;

import dev.noroom.thuvien.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderRepository extends JpaRepository<Order, Integer> {
}
