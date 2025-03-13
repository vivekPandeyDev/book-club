package com.bookhive.repository;

import com.bookhive.entity.Discussion;
import com.bookhive.projection.DiscussionProjection;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Long> {

    @Cacheable(value = "discussions", key = "#bookId")
    @Query("SELECT d.id AS id, d.title AS title, d.createdAt AS createdAt, d.user.username AS createdBy " +
           "FROM Discussion d WHERE d.book.id = :bookId")
    List<DiscussionProjection> findDiscussionsByBookId(Long bookId, Pageable pageable);
}
