package com.adem.messenger.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Link implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long linkId;
	private String href;
	private String rel;
	@ManyToOne
	@JoinColumn(name = "messageId")
	@JsonIgnoreProperties("links")
	private Message message;

	public Link() {
		super();
	}

	public Link(String href, String rel) {
		super();
		this.href = href;
		this.rel = rel;
	}

	public Link(String href, String rel, Message message) {
		super();
		this.href = href;
		this.rel = rel;
		this.message = message;
	}

	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String link) {
		this.href = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	@JsonIgnore
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
