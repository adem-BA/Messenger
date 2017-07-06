package com.adem.messenger.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adem.messenger.dao.MessageRepository;
import com.adem.messenger.entities.Message;

@Service
public class MessageServiceImp implements MessageService {
	@Autowired
	private MessageRepository messageRepo;

	@Override
	public List<Message> getAllMessages() {
		return messageRepo.findAll();
	}

	@Override
	public Message getMessage(Long messageId) {
		return messageRepo.getOne(messageId);
	}

	@Override
	public Message addMessage(Message message) {
		message.setCreationDate(new Date());
		return messageRepo.save(message);
	}

	@Override
	public Message updateMessage(Message message) {
		message.setCreationDate(new Date());
		return messageRepo.save(message);
	}

	@Override
	public void removeMessage(Long messageId) {
		messageRepo.delete(messageId);
	}

	@Override
	public Message updateMessageBySpecifiedMessage(Long messageId, Message message) {
		Message messageToUpdate = messageRepo.getOne(messageId);
		messageToUpdate.setAuthor(message.getAuthor());
		messageToUpdate.setComments(message.getComments());
		messageToUpdate.setContent(message.getContent());
		messageToUpdate.setCreationDate(new Date());
		messageToUpdate.setLinks(message.getLinks());
		return messageRepo.save(messageToUpdate);
	}

}
