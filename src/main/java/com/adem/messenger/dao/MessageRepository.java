package com.adem.messenger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adem.messenger.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
