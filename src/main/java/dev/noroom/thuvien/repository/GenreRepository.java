package dev.noroom.thuvien.repository;

import dev.noroom.thuvien.model.Book;
import dev.noroom.thuvien.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
