package com.adem.messenger.service;

import java.util.List;

import com.adem.messenger.entities.Comment;

public interface CommentService {

	public List<Comment> getAllComments(Long messageId);

	public Comment getCommentById(Long messageId, Long commentId);

	public Comment addComment(Long messageId, Comment comment);

	public Comment updateComment(Long messageId, Comment comment);

	public Comment removeComment(Long messageId, Long commentId);
	
}
