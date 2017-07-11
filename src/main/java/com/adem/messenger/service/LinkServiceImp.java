package com.adem.messenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adem.messenger.dao.LinkRepository;
import com.adem.messenger.dao.MessageRepository;
import com.adem.messenger.entities.Link;
import com.adem.messenger.entities.Message;

@Service
public class LinkServiceImp implements LinkService {

	@Autowired
	private LinkRepository linkRepo;

	@Autowired
	private MessageRepository messageRepo;

	@Override
	public Link addLinkToMessage(Long messageId, Link link) {

		Message message = messageRepo.getOne(messageId);
		link.setMessage(message);
		Link result = linkRepo.saveAndFlush(link);
		message.getLinks().add(result);
		messageRepo.save(message);

		return result;
	}

	@Override
	public List<Link> getAllLink(Long messageId) {
		return linkRepo.getAllLinks(messageId);
	}

	@Override
	public Link getLinkById(Long messageId, Long linkId) {

		return linkRepo.getLinkFromMessageById(messageId, linkId);
	}

	@Override
	public void removeLink(Long linkId) {
		linkRepo.delete(linkId);

	}

}
