package com.bookhive.repository;

import com.bookhive.entity.Achievement;
import com.bookhive.projection.AchievementProjection;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    @Cacheable(value = "achievements", key = "#userId")
    @Query("SELECT a.id AS id, a.title AS title, a.description AS description " +
           "FROM Achievement a WHERE a.user.id = :userId")
    List<AchievementProjection> findAchievementsByUserId(Long userId, Pageable pageable);
}
