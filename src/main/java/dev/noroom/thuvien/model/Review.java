package dev.noroom.thuvien.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int orderId;
    int rating;
    @NonNull String comment;

    public Review() {
    }
}
