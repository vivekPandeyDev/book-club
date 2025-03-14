package com.bookhive.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookhive.entity.Review;
import com.bookhive.projection.ReviewProjection;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r.id AS id, r.content AS content, r.rating AS rating, r.user.username AS createdBy " +
           "FROM Review r WHERE r.book.id = :bookId")
    List<ReviewProjection> findReviewsByBookId(Long bookId, Pageable pageable);
}
