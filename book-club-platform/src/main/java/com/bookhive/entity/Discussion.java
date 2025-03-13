package com.bookhive.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "discussion")
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discussionId;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private BookClub bookClub;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String content;
    private String title;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
