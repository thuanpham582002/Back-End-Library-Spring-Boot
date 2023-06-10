package dev.noroom.thuvien.model.dto;

import dev.noroom.thuvien.model.Book;
import dev.noroom.thuvien.model.Genre;
import dev.noroom.thuvien.service.GenreService;
import jakarta.annotation.Nullable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String description;
    private Genre genre;
    @NonNull
    private Date releaseDate;
    private long numPages;
    private long sold;
    @Nullable
    private List<String> selectedImage;

    public static BookDto fromBook(Book book, GenreService genreService) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .genre(genreService.getGenreById(book.getGenreId()))
                .releaseDate(book.getReleaseDate())
                .numPages(book.getNumPages())
                .sold(book.getSold())
                .selectedImage(book.getSelectedImage())
                .build();
    }

    public static Book toBook(BookDto bookDto, boolean ignoreNull) {
        Book book = new Book();
        if (ignoreNull) {
            if (bookDto.getId() != 0) {
                book.setId(bookDto.getId());
            }
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setDescription(bookDto.getDescription());
            if (bookDto.getGenre() != null) {
                book.setGenreId(bookDto.getGenre()
                        .getId());
            }
        } else {
            book.setId(bookDto.getId());
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setDescription(bookDto.getDescription());
            book.setGenreId(bookDto.getGenre()
                    .getId());
        }
        book.setReleaseDate(bookDto.getReleaseDate());
        book.setNumPages(bookDto.getNumPages());
        book.setSold(bookDto.getSold());
        book.setSelectedImage(bookDto.getSelectedImage());
        return book;
    }

    public static List<BookDto> fromList(List<Book> book, GenreService genreService) {
        List<BookDto> bookDto = new ArrayList<>();
        for (Book b : book) {
            bookDto.add(BookDto.fromBook(b, genreService));
        }
        return bookDto;
    }
}
