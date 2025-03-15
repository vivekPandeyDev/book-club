package com.bookhive.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @Column(name = "cover_image_url",nullable = false, unique = true, length = 1000)
    private String coverImageUrl;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Discussion> discussions;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Recommendation> recommendations;
    
    @Column(name = "book_url", nullable = false, unique = true, length = 1000)
    private String bookUrl;
}
