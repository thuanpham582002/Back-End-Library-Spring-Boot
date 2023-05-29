package dev.noroom.thuvien.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    int id;
    int userId;
    int bookId;
    int quantity;
    String status;

    public Order() {
    }
}
