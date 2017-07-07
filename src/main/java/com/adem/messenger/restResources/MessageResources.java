package com.adem.messenger.restResources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adem.messenger.entities.Message;
import com.adem.messenger.service.MessageService;
import com.fasterxml.jackson.annotation.JsonFormat.Value;

@RestController
@CrossOrigin

public class MessageResources {
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "messages", method = RequestMethod.GET)
	public List<Message> getAllMessages() {
		return messageService.getAllMessages();
	}

	@RequestMapping(value = "messages/{messageId}")
	public Message getMessageById(@PathVariable("messageId") Long id) {
		return messageService.getMessage(id);
	}

	@RequestMapping(value = "messages", method = RequestMethod.POST)
	public Message addMessage(@RequestBody Message message) {
		return messageService.addMessage(message);
	}

	@RequestMapping(value = "messages/{messageId}", method = RequestMethod.PUT)
	public Message updateMessage(@PathVariable("messageId") Long id, @RequestBody Message message) {
		
		return messageService.updateMessageBySpecifiedMessage(id, message);
	}

	@RequestMapping(value = "messages/{messageId}", method = RequestMethod.DELETE)
	public void removeMessage(@PathVariable("messageId") Long id) {
		messageService.removeMessage(id);
	}
	
	@RequestMapping(value = "messages/{messageId}/comments")
	public CommentResources getCommentResources() {
		return new CommentResources();
	}

}
