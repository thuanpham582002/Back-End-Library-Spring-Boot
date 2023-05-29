package dev.noroom.thuvien.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NonNull String title;
    @NonNull String author;
    @NonNull String description;
    @NonNull String genre;
    @NonNull Date releaseDate;
    int numPages;

    public Book() {
    }
}
