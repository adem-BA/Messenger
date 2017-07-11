package com.adem.messenger.restResources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adem.messenger.entities.Link;
import com.adem.messenger.service.LinkService;
import com.fasterxml.jackson.annotation.JsonFormat.Value;

@RestController
public class LinkResources {
	@Autowired
	LinkService linkService;
	
	@RequestMapping(value = "messages/{messageId}/links", method = RequestMethod.GET)
	public List<Link> getAllLink(@PathVariable("messageId") Long messageId) {
		return linkService.getAllLink(messageId);
	}
	
	@RequestMapping(value = "messages/{messageId}/links/{linkId}")
	public Link getLink( @PathVariable("messageId") Long messageId, @PathVariable("linkId") Long linkId){
		return linkService.getLinkById(messageId, linkId);
	}

	@RequestMapping(value = "messages/{messageId}/links", method = RequestMethod.POST)
	public Link addLinkToMessage(@PathVariable("messageId") Long messageId, @RequestBody Link link) {
		return linkService.addLinkToMessage(messageId, link);
	}

	@RequestMapping(value = "messages/{messageId}/links", method = RequestMethod.PUT)
	public Link updateLink(@PathVariable("messageId") Long messageId, @RequestBody Link link) {
		return linkService.addLinkToMessage(messageId, link);
	}
	
	
	
	

}
