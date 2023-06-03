package dev.noroom.thuvien.service.impl;

import dev.noroom.thuvien.model.Book;
import dev.noroom.thuvien.model.Order;
import dev.noroom.thuvien.repository.BookRepository;
import dev.noroom.thuvien.repository.OrderRepository;
import dev.noroom.thuvien.service.OrderService;
import org.springframework.stereotype.Service;

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
            // increase sold of book
            Book book = bookRepository.findById(order.getBookId())
                    .orElseThrow();
            book.setSold(book.getSold() + order.getQuantity());
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteOrder(long id) {
        try {
            orderRepository.deleteById((int) id);
            // decrease sold of book
            Order order = orderRepository.findById((int) id)
                    .orElseThrow();
            Book book = bookRepository.findById(order.getBookId())
                    .orElseThrow();
            book.setSold(book.getSold() - order.getQuantity());
            bookRepository.save(book);
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
            // update book sold
            orderRepository.save(order1);
            Book book = bookRepository.findById(order.getBookId())
                    .orElseThrow();
            book.setSold(book.getSold() - order1.getQuantity() + order.getQuantity());
            bookRepository.save(book);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
