package com.bookhive.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookhive.dto.club.BookClubDto;
import com.bookhive.dto.club.BookClubResponseDto;
import com.bookhive.service.BookClubService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookclubs")
public class BookClubController {

    private final BookClubService bookClubService;

    public BookClubController(BookClubService bookClubService) {
        this.bookClubService = bookClubService;
    }

    // Create BookClub@PostMapping
    @PostMapping
    public ResponseEntity<Map<String, Object>> createBookClub(@RequestBody @Valid BookClubDto bookClubDto) {
        BookClubResponseDto createdBookClub = bookClubService.createBookClub(bookClubDto);

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", "Book club created successfully");
        response.put("data", createdBookClub);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get All BookClubs with Paging and Sorting
    @GetMapping
    public ResponseEntity<Page<BookClubResponseDto>> getAllBookClubs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {

        Page<BookClubResponseDto> bookClubs = bookClubService.getAllBookClubs(page, size, sortBy);
        return ResponseEntity.ok(bookClubs);
    }

    // Get BookClub by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookClubResponseDto> getBookClubById(@PathVariable Long id) {
        BookClubResponseDto bookClub = bookClubService.getBookClubById(id);
        return ResponseEntity.ok(bookClub);
    }

    // Delete BookClub
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookClub(@PathVariable Long id) {
        bookClubService.deleteBookClub(id);
        return ResponseEntity.noContent().build();
    }
}
