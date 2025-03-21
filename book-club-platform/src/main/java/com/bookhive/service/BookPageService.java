package com.bookhive.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookhive.dto.page.BookPageDto;
import com.bookhive.entity.Book;
import com.bookhive.entity.BookPage;
import com.bookhive.repository.BookPageRepository;
import com.bookhive.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BookPageService {

    private final BookPageRepository bookPageRepository;
    private final BookRepository bookRepository;
    private final MinioService minioService;

    // Convert entity to DTO
    private BookPageDto convertToDto(BookPage bookPage) {
        return new BookPageDto(
                bookPage.getId(),
                bookPage.getPageNumber(),
                bookPage.getPageTitle(),
                bookPage.getPageUrl(),
                bookPage.getBook().getBookId(),
                bookPage.getBook().getTitle(),
                null
        );
    }

    // Get a single book page
    public Optional<BookPageDto> getBookPage(Long clubId, String title, Integer pageNumber) {
        return bookPageRepository.findBookPageByClubIdAndTitleAndPageNumber(clubId, title, pageNumber)
                .map(this::convertToDto);
    }

    // Get a list of book pages in a specific range
    public Page<BookPageDto> getBookPagesInRange(Long clubId, String title, Integer startPage, Integer endPage, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("pageNumber").ascending());
        return bookPageRepository.findBookPagesByClubIdAndTitleAndPageRange(clubId, title, startPage, endPage, pageable)
                .map(this::convertToDto);
    }

    // Get the previous book page
    public Optional<BookPageDto> getPreviousBookPage(Long clubId, String title, Integer currentPageNumber) {
        if (currentPageNumber <= 1) {
            return Optional.empty(); // No previous page exists
        }
        return bookPageRepository.findPreviousBookPage(clubId, title, currentPageNumber - 1)
                .map(this::convertToDto);
    }

    @Transactional
    public void saveBookPages(List<BookPageDto> pageDtos) {
        List<BookPage> bookPages = new ArrayList<>();

        for (BookPageDto dto : pageDtos) {
            // Fetch the book entity
            Book book = bookRepository.findById(dto.getBookId())
                    .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + dto.getBookId()));

            // Convert text content to InputStream
            InputStream inputStream = new ByteArrayInputStream(dto.getContent().getBytes(StandardCharsets.UTF_8));

            try {
                // Use MinioService to upload content
                String pageUrl = minioService.uploadFile(
                        inputStream,
                        "book-pages", // Bucket Name
                        "books/" + book.getBookId() + "/pages", // Folder Name
                        "page_" + dto.getPageNumber(), // File Name
                        "text/plain",
                        dto.getContent().length()
                );

                // Convert DTO to Entity
                BookPage bookPage = new BookPage();
                bookPage.setBook(book);
                bookPage.setPageNumber(dto.getPageNumber());
                bookPage.setPageTitle(dto.getPageTitle());
                bookPage.setPageUrl(pageUrl); // MinIO URL

                bookPages.add(bookPage);

            } catch (Exception e) {
                throw new RuntimeException("Failed to upload page content to MinIO", e);
            }
        }

        bookPageRepository.saveAll(bookPages);
    }
}
