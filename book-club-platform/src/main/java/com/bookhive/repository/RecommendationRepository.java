package com.bookhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookhive.entity.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation,Long>{
    
}
