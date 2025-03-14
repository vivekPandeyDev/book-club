package com.bookhive.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookhive.entity.User;
import com.bookhive.projection.UserProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.id AS id, u.username AS username, u.email AS email FROM User u")
    List<UserProjection> findAllUsers(Pageable pageable);

    @Query("SELECT f.follower.id AS id, f.follower.username AS username FROM Follow f WHERE f.following.id = :userId")
    List<UserProjection> findFollowersByUserId(Long userId, Pageable pageable);

    Optional<User> findUserByUsername(String userName);
    Optional<User> findUserByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}

