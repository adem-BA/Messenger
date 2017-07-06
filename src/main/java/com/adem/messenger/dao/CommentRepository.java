package com.adem.messenger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adem.messenger.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
