package com.bookhive.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookhive.entity.Discussion;
import com.bookhive.projection.DiscussionProjection;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Long> {


    @Query("SELECT d.id AS id, d.title AS title, d.createdAt AS createdAt, d.user.username AS createdBy " +
           "FROM Discussion d WHERE d.book.id = :bookId")
    List<DiscussionProjection> findDiscussionsByBookId(Long bookId, Pageable pageable);
}
