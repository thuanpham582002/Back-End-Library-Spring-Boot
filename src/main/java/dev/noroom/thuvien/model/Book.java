package dev.noroom.thuvien.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull String title;
    @NonNull String author;
    @NonNull String description;
    long genreId;
    @NonNull Date releaseDate;
    long numPages;
    long sold;
    @Nullable
    String selectedImage;

}
