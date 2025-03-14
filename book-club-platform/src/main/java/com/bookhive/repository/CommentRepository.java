package com.bookhive.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookhive.entity.Comment;
import com.bookhive.projection.CommentProjection;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c.id AS id, c.content AS content, c.createdAt AS createdAt, c.user.username AS createdBy " +
           "FROM Comment c WHERE c.discussion.id = :discussionId")
    List<CommentProjection> findCommentsByDiscussionId(Long discussionId, Pageable pageable);
}
