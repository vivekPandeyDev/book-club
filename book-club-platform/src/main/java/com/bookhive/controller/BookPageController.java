package com.bookhive.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookhive.dto.page.BookPageDto;
import com.bookhive.service.BookPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookPageController {

    private final BookPageService bookPageService;

    // Fetch a single book page
    @GetMapping("/{clubId}/{title}/book-page/{pageNumber}")
    public ResponseEntity<BookPageDto> getBookPage(@PathVariable Long clubId,
            @PathVariable String title,
            @PathVariable Integer pageNumber) {
        return bookPageService.getBookPage(clubId, title, pageNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Fetch a list of book pages in a range
    @GetMapping("/{clubId}/{title}/book-pages")
    public ResponseEntity<Page<BookPageDto>> getBookPagesInRange(@PathVariable Long clubId,
            @PathVariable String title,
            @RequestParam Integer startPage,
            @RequestParam Integer endPage,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bookPageService.getBookPagesInRange(clubId, title, startPage, endPage, page, size));
    }

    // Fetch the previous book page
    @GetMapping("/{clubId}/{title}/book-page/{pageNumber}/prev")
    public ResponseEntity<BookPageDto> getPreviousBookPage(@PathVariable Long clubId,
            @PathVariable String title,
            @PathVariable Integer pageNumber) {
        return bookPageService.getPreviousBookPage(clubId, title, pageNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}