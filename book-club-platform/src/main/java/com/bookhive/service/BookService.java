package com.bookhive.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bookhive.dto.book.BookRequestDto;
import com.bookhive.dto.book.BookResponseDto;
import com.bookhive.entity.Book;
import com.bookhive.handler.ResourceFoundException;
import com.bookhive.repository.BookRepository;
import com.bookhive.util.BookMapper;
import com.bookhive.util.MinioUtil;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BookService {

    private final BookRepository bookRepository;
    private final MinioUtil minioUtil;

    /**
     * Upload book and chapters to MinIO
     */
    @Transactional
    @CacheEvict(value = "books", key = "#bookRequestDto.title")
    public BookResponseDto uploadBook(BookRequestDto bookRequestDto, MultipartFile file, MultipartFile coverImage) throws Exception {
        if(bookRepository.findByTitle(bookRequestDto.getTitle()).isPresent()){
            throw new ResourceFoundException("Book found with title: " + bookRequestDto.getTitle());
        }
        // Save cover image and book file to MinIO and get URLs
        String bookUrl = minioUtil.uploadFile(file, bookRequestDto.getTitle(), "books");
        String coverImageUrl = minioUtil.uploadFile(coverImage, bookRequestDto.getTitle(), "cover");
    
        // Map DTO to entity
        Book book = getBook(bookRequestDto, bookUrl, coverImageUrl);
    
        // Save book details to the database
        book = bookRepository.save(book);
        return BookMapper.toDto(book);
    }
    private Book getBook(BookRequestDto dto, String bookUrl, String coverImageUrl) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setLanguage(dto.getLanguage());
        book.setPublishedYear(dto.getPublishedYear());
        book.setRating(dto.getRating());
        book.setCoverImageUrl(coverImageUrl);
        book.setBookUrl(bookUrl);
        return book;
    }

    @Cacheable(value = "books", key = "#title")
    public BookResponseDto findBookByTitle(String title) {
        return bookRepository.findByTitle(title)
                .map(BookMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with title: " + title));

    }
}
