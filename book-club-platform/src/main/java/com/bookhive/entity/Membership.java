package com.bookhive.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "membership", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "club_id"})
})
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipId;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "club_id",nullable = false)
    private BookClub bookClub;

    private String role;

    private LocalDateTime joinedAt;
}

