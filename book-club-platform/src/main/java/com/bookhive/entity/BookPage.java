package com.bookhive.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book_page", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"book_id", "pageNumber"}), // Ensures unique pages in a book
       indexes = @Index(name = "idx_book_page_number", columnList = "book_id, pageNumber")) // Fast lookup
public class BookPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer pageNumber;

    @Column(nullable = false, length = 500)
    private String pageTitle;

    @Column(nullable = false, unique = true, length = 1000)
    private String pageUrl;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}