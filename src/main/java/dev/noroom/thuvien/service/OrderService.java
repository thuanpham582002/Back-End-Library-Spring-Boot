package dev.noroom.thuvien.service;

import dev.noroom.thuvien.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    List<Order> getOrdersByBookId(long bookId);

    List<Order> getOrdersByUserId(long userId);

    boolean addOrder(Order order);

    boolean deleteOrder(long id);

    boolean updateOrder(Order order);
}
