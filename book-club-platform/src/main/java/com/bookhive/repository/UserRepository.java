package com.bookhive.repository;

import com.bookhive.entity.User;
import com.bookhive.projection.UserProjection;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(value = "users", key = "#pageable.pageNumber")
    @Query("SELECT u.id AS id, u.username AS username, u.email AS email FROM User u")
    List<UserProjection> findAllUsers(Pageable pageable);

    @Cacheable(value = "followers", key = "#userId")
    @Query("SELECT f.follower.id AS id, f.follower.username AS username FROM Follow f WHERE f.following.id = :userId")
    List<UserProjection> findFollowersByUserId(Long userId, Pageable pageable);
}

