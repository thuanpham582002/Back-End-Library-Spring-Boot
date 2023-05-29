package dev.noroom.thuvien.repository;

import dev.noroom.thuvien.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {
    Boolean existsByTitle(String title);

    Boolean existsByAuthor(String author);
}
