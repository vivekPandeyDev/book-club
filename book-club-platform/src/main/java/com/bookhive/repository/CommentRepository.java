package com.bookhive.repository;

import com.bookhive.entity.Comment;
import com.bookhive.projection.CommentProjection;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Cacheable(value = "comments", key = "#discussionId")
    @Query("SELECT c.id AS id, c.content AS content, c.createdAt AS createdAt, c.user.username AS createdBy " +
           "FROM Comment c WHERE c.discussion.id = :discussionId")
    List<CommentProjection> findCommentsByDiscussionId(Long discussionId, Pageable pageable);
}
