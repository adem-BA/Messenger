package com.adem.messenger.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Link implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long linkId;
	private String link;
	private String rel;
	@ManyToOne
	@JoinColumn(name = "messageId")
	@JsonIgnoreProperties("links")
	private Message message;

	public Link() {
		super();
	}

	public Link(String link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}

	public Link(String link, String rel, Message message) {
		super();
		this.link = link;
		this.rel = rel;
		this.message = message;
	}

	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
