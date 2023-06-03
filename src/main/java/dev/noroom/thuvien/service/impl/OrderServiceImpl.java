package dev.noroom.thuvien.service.impl;

import dev.noroom.thuvien.model.Order;
import dev.noroom.thuvien.repository.OrderRepository;
import dev.noroom.thuvien.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByBookId(long bookId) {
        return orderRepository.findAllByBookId(bookId);
    }

    @Override
    public List<Order> getOrdersByUserId(long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public boolean addOrder(Order order) {
        try {
            orderRepository.save(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteOrder(long id) {
        try {
            orderRepository.deleteById((int) id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateOrder(Order order) {
        try {
            Order order1 = orderRepository.findById((int) order.getId())
                    .orElseThrow();
            order1.setBookId(order.getBookId());
            order1.setUserId(order.getUserId());
            order1.setQuantity(order.getQuantity());
            orderRepository.save(order1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
