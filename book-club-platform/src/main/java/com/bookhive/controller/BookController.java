package com.bookhive.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookhive.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadBook(
            @RequestParam("file") MultipartFile file,
            @RequestParam("coverImage") MultipartFile coverImage,
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("genre") String genre,
            @RequestParam("language") String language,
            @RequestParam("publishedYear") Integer publishedYear,
            @RequestParam("rating") Double rating) {

        try {
            bookService.uploadBook(file, title, author, genre, language, publishedYear, rating, coverImage);
            return ResponseEntity.ok("Book uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload book: " + e.getMessage());
        }
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getBookByTitle(@PathVariable String title) {
        var book =bookService.findBookByTitle(title.trim());
        return ResponseEntity.of(Optional.of(book));
    }
}

