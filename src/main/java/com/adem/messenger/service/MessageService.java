package com.adem.messenger.service;

import java.util.List;

import com.adem.messenger.entities.Message;

public interface MessageService {
	public List<Message> getAllMessages();

	public Message getMessage(Long messageId);

	public Message addMessage(Message message);

	public Message updateMessage(Message message);

	public void removeMessage(Long messageId);
	
	public Message updateMessageBySpecifiedMessage(Long messageId, Message message);

}
