package com.adem.messenger.restResources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adem.messenger.entities.Comment;
import com.adem.messenger.service.CommentService;

@RestController
@RequestMapping(value = "messages/{messageId}/comments")
public class CommentResources {
	@Autowired
	private CommentService commentService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Comment> getAllCommentByMessage(@PathVariable("messageId") Long messageId) {
		return commentService.getAllComments(messageId);
	}

	@RequestMapping("/{commentId}")
	public Comment getCommentFromMessageById(@PathVariable("messageId") Long messageId,
			@PathVariable("commentId") Long commentId) {
		return commentService.getCommentById(messageId, commentId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Comment addCommentToMessage(@PathVariable("messageId") Long messageId, @RequestBody Comment comment) {
		return commentService.addComment(messageId, comment);
	}

	@RequestMapping(value = "/{commentId}", method = RequestMethod.PUT)
	public Comment updateComment(@PathVariable("messageId") Long messageId, @PathVariable("commentId") Long commentId,
			@RequestBody Comment comment) {
		return commentService.updateComment(messageId, commentId, comment);
	}

	@RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
	public void removeComment(@PathVariable("commentId") Long commentId) {
		commentService.removeComment(commentId);
	}

}
