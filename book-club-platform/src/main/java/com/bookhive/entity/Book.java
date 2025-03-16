package com.bookhive.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(nullable = false, unique = true, length = 1000)
    private String title;
    private String author;
    private String genre;
    private String language;
    private Double rating;
    private Integer publishedYear;
    @Column(name = "cover_image_url", nullable = false, unique = true, length = 1000)
    private String coverImageUrl;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Discussion> discussions = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Recommendation> recommendations = new ArrayList<>();

    @Column(name = "book_url", nullable = false, unique = true, length = 1000)
    private String bookUrl;
}
