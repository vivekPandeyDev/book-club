package com.bookhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookhive.entity.Follow;

public interface FollowRepository extends JpaRepository<Follow,Long> {
    
}
