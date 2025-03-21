package com.bookhive.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"book_club_id", "title"}), // Ensure uniqueness
       indexes = @Index(name = "idx_book_club_title", columnList = "book_club_id, title")) // Index for fast lookup
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(nullable = false, length = 1000)
    private String title;
    private String author;
    private String genre;
    private String language;
    private Double rating;
    private Integer publishedYear;
    @Column(name = "cover_image_url", nullable = false, unique = true, length = 1000)
    private String coverImageUrl;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Discussion> discussions = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Recommendation> recommendations = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookPage> pages = new ArrayList<>();

    @Column(name = "book_url", nullable = false, unique = true, length = 1000)
    private String bookUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_club_id",nullable = false)
    BookClub bookClub;
}
