package dev.noroom.thuvien.model.dto;

import dev.noroom.thuvien.model.Book;
import dev.noroom.thuvien.model.Order;
import dev.noroom.thuvien.model.Review;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
    long id;
    UserDto user;
    Book book;
    Review review;
    long quantity;

    public static OrderDto fromOrder(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .user(UserDto.fromUser(order.getUser()))
                .book(order.getBook())
                .quantity(order.getQuantity())
                .review(order.getReview())
                .build();
    }

    public static Order toOrder(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .user(UserDto.toUser(orderDto.getUser()))
                .book(orderDto.getBook())
                .quantity(orderDto.getQuantity())
                .review(orderDto.getReview())
                .build();
    }
}
