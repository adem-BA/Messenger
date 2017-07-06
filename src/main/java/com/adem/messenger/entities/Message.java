package com.adem.messenger.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Message implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long messageId;
	private String content;
	private String author;
	private Date creationDate;
	@OneToMany(mappedBy = "message")
	private List<Comment> comments;
	@OneToMany(mappedBy = "message")
	private List<Link> links;

	public Message() {
		super();
	}

	public Message(String content, String author) {
		super();
		this.content = content;
		this.author = author;
		this.creationDate = new Date();
	}

	public Message(String content, String author, Date creationDate) {
		super();
		this.content = content;
		this.author = author;
		this.creationDate = creationDate;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
