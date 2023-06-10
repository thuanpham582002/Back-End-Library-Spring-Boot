package dev.noroom.thuvien.service;

import dev.noroom.thuvien.model.Order;
import dev.noroom.thuvien.model.Review;
import dev.noroom.thuvien.model.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();

    List<OrderDto> getOrdersByBookId(long bookId);

    List<OrderDto> getOrdersByUserId(long userId);

    boolean addOrder(Order order);

    boolean deleteOrder(long id);

    boolean updateOrder(Order order);

    Order addReviewToOrder(Long orderId, Review review);
}
