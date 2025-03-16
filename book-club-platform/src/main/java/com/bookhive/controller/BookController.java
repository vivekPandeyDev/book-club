package com.bookhive.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookhive.dto.book.BookRequestDto;
import com.bookhive.dto.book.BookResponseDto;
import com.bookhive.repository.BookRepository;
import com.bookhive.service.BookService;
import com.bookhive.service.ChapterService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;
    private final ChapterService chapterService;

    @PostMapping(value = "/upload")
    public ResponseEntity<Map<String, Object>>  uploadBook(
            @Valid @RequestPart("book") BookRequestDto book,
            @RequestPart("file") MultipartFile file,
            @RequestPart("coverImage") MultipartFile coverImage) throws Exception {

        BookResponseDto bookResponseDto = bookService.uploadBook(book, file, coverImage);
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Book club created successfully");
        response.put("data", bookResponseDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/upload/chapter")
    public ResponseEntity<String> uploadBook(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title) throws IOException, Exception {
        var book = bookRepository.findByTitle(title);
        chapterService.extractAndSaveChapters(file.getInputStream(), book.get());
        return ResponseEntity.ok().body("done");
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getBookByTitle(@PathVariable String title) {
        var book = bookService.findBookByTitle(title.trim());
        return ResponseEntity.of(Optional.of(book));
    }
}
