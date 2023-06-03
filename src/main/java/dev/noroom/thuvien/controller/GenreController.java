package dev.noroom.thuvien.controller;

import dev.noroom.thuvien.model.Genre;
import dev.noroom.thuvien.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreService genreService;


    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllGenres() {
        List<Genre> genre = genreService.getAllGenres();
        if (genre != null) {
            return ResponseEntity.ok(genre);
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }
}
