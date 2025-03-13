package com.bookhive.service;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookhive.dto.club.BookClubDto;
import com.bookhive.dto.club.BookClubResponseDto;
import com.bookhive.entity.BookClub;
import com.bookhive.entity.User;
import com.bookhive.projection.BookClubProjection;
import com.bookhive.repository.BookClubRepository;
import com.bookhive.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookClubService {

    private final BookClubRepository bookClubRepository;
    private final UserRepository userRepository;
    private final MessageSource messageSource;
    private static final String BOOK_CLUB_ALREADY_EXIST = "Book club with this name already exists";
    private static final String BOOK_CLUB_NOT_FOUND_WITH_ID = "BookClub not found with ID: ";
    // Create BookClub
    public BookClubResponseDto createBookClub(BookClubDto bookClubDto) {
        // Check if name is already taken
        if (bookClubRepository.existsByName(bookClubDto.getName())) {
            String message = messageSource.getMessage("book.club.name.exists", null, BOOK_CLUB_ALREADY_EXIST,
                    Locale.getDefault());
            throw new IllegalArgumentException(message);
        }

        User owner = userRepository.findById(bookClubDto.getOwnerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));

        BookClub bookClub = new BookClub();
        bookClub.setName(bookClubDto.getName());
        bookClub.setDescription(bookClubDto.getDescription());
        bookClub.setOwner(owner);
        bookClub.setCreatedAt(LocalDateTime.now());
        BookClub savedBookClub;
        savedBookClub = bookClubRepository.save(bookClub);

        // Create response DTO using builder
        return BookClubResponseDto.builder()
                .clubId(savedBookClub.getClubId())
                .name(savedBookClub.getName())
                .description(savedBookClub.getDescription())
                .ownerName(savedBookClub.getOwner().getUsername())
                .createdAt(savedBookClub.getCreatedAt())
                .build();
    }

    // Get All BookClubs with Paging and Sorting
    public Page<BookClubResponseDto> getAllBookClubs(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(
                page >= 0 ? page : 0,
                size > 0 ? size : 10,
                Sort.by(sortBy != null ? sortBy : "name").ascending());
        Page<BookClub> bookClubPage = bookClubRepository.findAll(pageable);

        return bookClubPage.map(bookClub -> BookClubResponseDto.builder()
                .clubId(bookClub.getClubId())
                .name(bookClub.getName())
                .description(bookClub.getDescription())
                .ownerName(bookClub.getOwner().getUsername())
                .createdAt(bookClub.getCreatedAt())
                .memberCount(bookClub.getMemberships().size())
                .build());
    }

    // Get BookClub by ID
    public BookClubResponseDto getBookClubById(Long id) {
        String message = messageSource.getMessage(
                "book.club.not.found",
                new Object[] { id },
                BOOK_CLUB_NOT_FOUND_WITH_ID+ id, // Default message
                Locale.getDefault());
        BookClub bookClub = bookClubRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(message));

        return BookClubResponseDto.builder()
                .clubId(bookClub.getClubId())
                .name(bookClub.getName())
                .description(bookClub.getDescription())
                .ownerName(bookClub.getOwner().getUsername())
                .createdAt(bookClub.getCreatedAt())
                .build();
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
