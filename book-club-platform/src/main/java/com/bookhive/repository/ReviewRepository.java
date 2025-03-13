package com.bookhive.repository;

import com.bookhive.entity.Review;
import com.bookhive.projection.ReviewProjection;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Cacheable(value = "reviews", key = "#bookId")
    @Query("SELECT r.id AS id, r.content AS content, r.rating AS rating, r.user.username AS createdBy " +
           "FROM Review r WHERE r.book.id = :bookId")
    List<ReviewProjection> findReviewsByBookId(Long bookId, Pageable pageable);
}
