package dev.noroom.thuvien.controller;

import dev.noroom.thuvien.model.Genre;
import dev.noroom.thuvien.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenreById(@PathVariable Long id) {
        Genre genre = genreService.getGenreById(id);
        if (genre != null) {
            return ResponseEntity.ok(genre);
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @GetMapping("/add")
    public ResponseEntity<?> addGenre() {
        if (genreService.addGenre()) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteGenre() {
        if (genreService.deleteGenre()) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @GetMapping("/update")
    public ResponseEntity<?> updateGenre() {
        if (genreService.updateGenre()) {
            return ResponseEntity.ok()
                    .build();
        } else {
            return ResponseEntity.notFound()
                    .build();
        }
    }


}
