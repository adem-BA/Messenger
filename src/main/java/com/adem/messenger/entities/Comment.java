package com.adem.messenger.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComment;
	private String comment;
	private Date creationDate;
	private String author;
	@ManyToOne
	@JoinColumn(name = "messageId")
	private Message message;

	public Comment() {
		super();
	}

	public Comment(String comment, String author) {
		super();
		this.comment = comment;
		this.author = author;
		this.creationDate = new Date();
	}

	public Comment(String comment, String author, Message message) {
		super();
		this.comment = comment;
		this.author = author;
		this.message = message;
		this.creationDate = new Date();
	}

	public Long getIdComment() {
		return idComment;
	}

	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
