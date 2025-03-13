package com.bookhive.repository;

import com.bookhive.entity.Book;
import com.bookhive.projection.BookProjection;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Cacheable(value = "books", key = "#pageable.pageNumber")
    @Query("SELECT b.id AS id, b.title AS title, b.author AS author FROM Book b")
    List<BookProjection> findAllBooks(Pageable pageable);

    @Cacheable(value = "recommendedBooks", key = "#userId")
    @Query("SELECT r.book.id AS id, r.book.title AS title, r.book.author AS author " +
           "FROM Recommendation r WHERE r.user.id = :userId")
    List<BookProjection> findRecommendedBooksByUserId(Long userId, Pageable pageable);
}
