// package com.bookhive.entity;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import lombok.Getter;
// import lombok.Setter;


// @Getter
// @Setter
// @Entity
// public class Chapter {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String title;
    
//     @Column(name = "content_url",nullable = false, unique = true, length = 1000)
//     private String contentUrl;

//     @ManyToOne
//     @JoinColumn(name = "book_id", nullable = false)
//     private Book book;

// }