package com.bookhive.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookhive.entity.BookClub;
import com.bookhive.projection.BookClubProjection;
import com.bookhive.repository.BookClubRepository;

@Service
public class BookClubService {

    private final BookClubRepository bookClubRepository;

    public BookClubService(BookClubRepository bookClubRepository) {
        this.bookClubRepository = bookClubRepository;
    }

    // Create BookClub
    public BookClub createBookClub(BookClub bookClub) {
        return bookClubRepository.save(bookClub);
    }

    // Get All BookClubs with Paging and Sorting
    public Page<BookClubProjection> getAllBookClubs(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(
                page >= 0 ? page : 0,
                size > 0 ? size : 10,
                Sort.by(sortBy != null ? sortBy : "name").ascending()
        );
        return bookClubRepository.findAllProjectedBy(pageable);
    }

    // Get BookClub by ID
    public BookClubProjection getBookClubById(Long id) {
        return bookClubRepository.findProjectedById(id)
                .orElseThrow(() -> new RuntimeException("BookClub not found with ID: " + id));
    }

    // Update BookClub
    public BookClub updateBookClub(Long id, BookClub updatedBookClub) {
        BookClub existingBookClub = bookClubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookClub not found with ID: " + id));

        existingBookClub.setName(updatedBookClub.getName());
        existingBookClub.setDescription(updatedBookClub.getDescription());
        return bookClubRepository.save(existingBookClub);
    }

    // Delete BookClub
    public void deleteBookClub(Long id) {
        if (bookClubRepository.existsById(id)) {
            bookClubRepository.deleteById(id);
        } else {
            throw new RuntimeException("BookClub not found with ID: " + id);
        }
    }
}
