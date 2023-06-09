package dev.noroom.thuvien.service;

import dev.noroom.thuvien.model.Book;
import dev.noroom.thuvien.model.Genre;

import java.util.List;


public interface GenreService {
    List<Genre> getAllGenres();

    Genre getGenreById(Long id);

    boolean addGenre();

    boolean deleteGenre();

    boolean updateGenre();
}
