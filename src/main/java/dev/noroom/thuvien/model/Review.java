package dev.noroom.thuvien.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int userId;
    int bookId;
    int rating;
    @NonNull String comment;
    int pages;
    int sold = 0;

    public Review() {
    }
}
