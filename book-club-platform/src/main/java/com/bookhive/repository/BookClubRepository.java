package com.bookhive.repository;

import com.bookhive.projection.BookClubProjection;
import com.bookhive.entity.BookClub;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookClubRepository extends JpaRepository<BookClub, Long> {

    // Using projection and pagination
    Page<BookClubProjection> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Get all book clubs with projection and pagination
    @Query("SELECT b.id AS id, b.name AS name,b.description as description FROM BookClub b")
    Page<BookClubProjection> findAllProjectedBy(Pageable pageable);

    // Get book club by ID with projection
    @Query("SELECT b FROM BookClub b WHERE b.id = :id")
    Optional<BookClubProjection> findProjectedById(@Param("id") Long id);

    boolean existsByName(String name);
}
