package com.bookhive.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book_club")
public class BookClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    private String name;
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "bookClub", cascade = CascadeType.ALL)
    private List<Membership> memberships;

    @OneToMany(mappedBy = "bookClub", cascade = CascadeType.ALL)
    private List<Discussion> discussions;
}
