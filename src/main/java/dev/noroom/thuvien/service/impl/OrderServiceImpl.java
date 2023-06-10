package dev.noroom.thuvien.service.impl;

import dev.noroom.thuvien.model.Book;
import dev.noroom.thuvien.model.Order;
import dev.noroom.thuvien.model.Review;
import dev.noroom.thuvien.model.User;
import dev.noroom.thuvien.model.dto.OrderDto;
import dev.noroom.thuvien.repository.BookRepository;
import dev.noroom.thuvien.repository.OrderRepository;
import dev.noroom.thuvien.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final BookRepository bookRepository;

    public OrderServiceImpl(OrderRepository orderRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderDto::fromOrder)
                .toList();
    }

    @Override
    public List<OrderDto> getOrdersByBookId(long bookId) {
        return orderRepository.findAllByBookId(bookId)
                .stream()
                .map(OrderDto::fromOrder)
                .toList();
    }

    @Override
    public List<OrderDto> getOrdersByUserId(long userId) {
        return orderRepository.findAllByUserId(userId)
                .stream()
                .map(OrderDto::fromOrder)
                .toList();
    }

    @Override
    public boolean addOrder(Order order) {
        try {
            orderRepository.save(order);
            // increase sold of book
            Book book = bookRepository.findById(order.getBook()
                            .getId())
                    .orElseThrow();
            book.setSold(book.getSold() + order.getQuantity());
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteOrder(long id) {
        try {
            Order order = orderRepository.findById(id)
                    .orElseThrow();
            Book book = bookRepository.findById(order.getBook()
                            .getId())
                    .orElseThrow();
            book.setSold(book.getSold() - order.getQuantity());
            bookRepository.save(book);
            orderRepository.deleteById(id);
            // decrease sold of book
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateOrder(Order order) {
        try {
            orderRepository.save(order);
            // update book sold
            Book book = bookRepository.findById(order.getBook()
                            .getId())
                    .orElseThrow();
            book.setSold(book.getSold() - order.getQuantity() + order.getQuantity());
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Order addReviewToOrder(Long orderId, Review review) {
        try {
            Order order = orderRepository.findById(orderId)
                    .orElseThrow();
            order.setReview(review);
            orderRepository.save(order);
            return order;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
