package com.bookhive.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookhive.entity.Book;
import com.bookhive.projection.BookProjection;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

    @Query("SELECT b.id AS id, b.title AS title, b.author AS author FROM Book b")
    List<BookProjection> findAllBooks(Pageable pageable);

    @Query("""
                SELECT r.book.id AS id, r.book.title AS title, r.book.author AS author
                FROM Recommendation r WHERE r.user.id = :userId
            """)
    List<BookProjection> findRecommendedBooksByUserId(Long userId, Pageable pageable);
}
