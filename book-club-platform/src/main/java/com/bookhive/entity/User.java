package com.bookhive.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false,unique = true)
    private String username;
    private String email;
    private String password;
    private String role;
    private String avatar;
    private String bio;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Membership> memberships;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Discussion> discussions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private List<Follow> followers;

    @OneToMany(mappedBy = "following", cascade = CascadeType.ALL)
    private List<Follow> follwings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Achievement> achievements;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Recommendation> recommendations;
}
