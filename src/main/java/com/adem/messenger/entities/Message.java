package com.adem.messenger.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Message implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long messageId;
	private String content;
	private String author;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creationDate;
	@OneToMany(mappedBy = "message", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("message")
	private List<Comment> comments;
	@OneToMany(mappedBy = "message")
	@JsonIgnoreProperties("message")
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
	
	

	public Message(Long messageId, String content, String author, Date creationDate, List<Comment> comments,
			List<Link> links) {
		super();
		this.messageId = messageId;
		this.content = content;
		this.author = author;
		this.creationDate = creationDate;
		this.comments = comments;
		this.links = links;
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
