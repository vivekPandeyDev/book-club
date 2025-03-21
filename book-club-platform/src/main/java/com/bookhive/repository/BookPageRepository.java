package com.bookhive.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookhive.entity.BookPage;

public interface BookPageRepository extends JpaRepository<BookPage, Long> {

        @Query("SELECT bp FROM BookPage bp WHERE bp.book.bookClub.clubId = :clubId AND bp.book.title = :title AND bp.pageNumber = :pageNumber")
        Optional<BookPage> findBookPageByClubIdAndTitleAndPageNumber(@Param("clubId") Long clubId,
                        @Param("title") String title,
                        @Param("pageNumber") Integer pageNumber);

        @Query("SELECT bp FROM BookPage bp WHERE bp.book.bookClub.clubId = :clubId AND bp.book.title = :title AND bp.pageNumber BETWEEN :startPage AND :endPage")
        Page<BookPage> findBookPagesByClubIdAndTitleAndPageRange(@Param("clubId") Long clubId,
                        @Param("title") String title,
                        @Param("startPage") Integer startPage,
                        @Param("endPage") Integer endPage,
                        Pageable pageable);

        @Query("SELECT bp FROM BookPage bp WHERE bp.book.bookClub.clubId = :clubId AND bp.book.title = :title AND bp.pageNumber = :prevPageNumber")
        Optional<BookPage> findPreviousBookPage(@Param("clubId") Long clubId,
                        @Param("title") String title,
                        @Param("prevPageNumber") Integer prevPageNumber);

}
