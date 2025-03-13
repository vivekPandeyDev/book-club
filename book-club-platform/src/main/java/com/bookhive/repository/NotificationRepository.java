package com.bookhive.repository;

import com.bookhive.entity.Notification;
import com.bookhive.projection.NotificationProjection;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Cacheable(value = "notifications", key = "#userId")
    @Query("SELECT n.id AS id, n.content AS content, n.createdAt AS createdAt " +
           "FROM Notification n WHERE n.user.id = :userId")
    List<NotificationProjection> findNotificationsByUserId(Long userId, Pageable pageable);
}
