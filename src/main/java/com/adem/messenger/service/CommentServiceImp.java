package com.adem.messenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adem.messenger.dao.CommentRepository;
import com.adem.messenger.dao.MessageRepository;
import com.adem.messenger.entities.Comment;
import com.adem.messenger.entities.Message;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private MessageRepository messageRepo;

	@Override
	public List<Comment> getAllComments(Long messageId) {
		return commentRepo.findAll();
	}

	@Override
	public Comment getCommentById(Long messageId, Long commentId) {
		return null;
	}

	@Override
	public Comment addComment(Long messageId, Comment comment) {
		Comment result = commentRepo.saveAndFlush(comment);
		Message message = messageRepo.getOne(messageId);
		message.getComments().add(result);
		messageRepo.save(message);

		return result;
	}

	@Override
	public Comment updateComment(Long messageId, Comment comment) {
		return null;
	}

	@Override
	public Comment removeComment(Long messageId, Long commentId) {
		return null;
	}

}
