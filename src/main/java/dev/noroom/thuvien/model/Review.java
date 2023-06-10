package dev.noroom.thuvien.model;

import dev.noroom.thuvien.model.converter.StringListConverter;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int orderId;
    int rating;
    @NonNull String comment;

    @Nullable
    @Convert(converter = StringListConverter.class)
    List<String> images;
}
