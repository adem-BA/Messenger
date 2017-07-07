package com.adem.messenger.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adem.messenger.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("select c from Comment c where c.message.messageId = :x")
	public List<Comment> getCommentsFromMessage(@Param("x") Long messageId);

	@Query("select c from Comment c where c.message.messageId = :x and c.commentId = :y")
	public Comment getCommentFromMessageById(@Param("x") Long messageId, @Param("y") Long commentId);

}
