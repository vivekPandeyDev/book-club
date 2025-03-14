package com.bookhive.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookhive.entity.Achievement;
import com.bookhive.projection.AchievementProjection;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    @Query("""
             SELECT a.id AS id, a.title AS title, a.description AS description
            FROM Achievement a WHERE a.user.id = :userId
            """)
    List<AchievementProjection> findAchievementsByUserId(Long userId, Pageable pageable);
}
