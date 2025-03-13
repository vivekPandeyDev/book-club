package com.bookhive.controller;

import com.bookhive.projection.BookClubProjection;
import com.bookhive.entity.BookClub;
import com.bookhive.service.BookClubService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookclubs")
public class BookClubController {

    private final BookClubService bookClubService;

    public BookClubController(BookClubService bookClubService) {
        this.bookClubService = bookClubService;
    }

    // Create BookClub
    @PostMapping
    public ResponseEntity<BookClub> createBookClub(@RequestBody BookClub bookClub) {
        BookClub createdBookClub = bookClubService.createBookClub(bookClub);
        return new ResponseEntity<>(createdBookClub, HttpStatus.CREATED);
    }

    // Get All BookClubs with Paging and Sorting
    @GetMapping
    public ResponseEntity<Page<BookClubProjection>> getAllBookClubs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {

        Page<BookClubProjection> bookClubs = bookClubService.getAllBookClubs(page, size, sortBy);
        return ResponseEntity.ok(bookClubs);
    }

    // Get BookClub by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookClubProjection> getBookClubById(@PathVariable Long id) {
        BookClubProjection bookClub = bookClubService.getBookClubById(id);
        return ResponseEntity.ok(bookClub);
    }

    // Update BookClub
    @PutMapping("/{id}")
    public ResponseEntity<BookClub> updateBookClub(@PathVariable Long id, @RequestBody BookClub updatedBookClub) {
        BookClub updated = bookClubService.updateBookClub(id, updatedBookClub);
        return ResponseEntity.ok(updated);
    }

    // Delete BookClub
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookClub(@PathVariable Long id) {
        bookClubService.deleteBookClub(id);
        return ResponseEntity.noContent().build();
    }
}
