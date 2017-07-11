package com.adem.messenger.service;

import java.util.List;

import com.adem.messenger.entities.Link;

public interface LinkService {
	public List<Link> getAllLink(Long messageId);

	public Link getLinkById(Long messageId, Long linkId);

	public Link addLinkToMessage(Long messageId, Link link);

	public void removeLink(Long messageId,Long linkId);
	
	public Link updateLink(Long messageId, Long linkId, Link link);

}
