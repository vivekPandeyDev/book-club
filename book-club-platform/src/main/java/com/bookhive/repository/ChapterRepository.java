package com.bookhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookhive.entity.Chapter;



public interface ChapterRepository extends JpaRepository<Chapter, Long>  {
    @Query("SELECT c FROM Chapter c WHERE c.book.id = :bookId")
    List<Chapter> findByBookId(@Param("bookId") Long bookId);
}
