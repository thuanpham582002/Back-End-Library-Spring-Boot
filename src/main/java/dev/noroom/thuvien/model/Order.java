package dev.noroom.thuvien.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    long id;
    long userId;
    long bookId;
    long quantity;

    public Order() {
    }
}
