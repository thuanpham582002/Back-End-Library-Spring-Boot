package dev.noroom.thuvien.service.impl;

import dev.noroom.thuvien.model.Genre;
import dev.noroom.thuvien.repository.GenreRepository;
import dev.noroom.thuvien.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        System.out.println("getAllGenres");
        return genreRepository.findAll();
    }
}
