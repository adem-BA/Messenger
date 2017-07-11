package com.adem.messenger.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adem.messenger.entities.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

	@Query("select l from Link l where l.linkId = :x and l.message.messageId = :y ")
	public Link getLinkFromMessageById(@Param("y") Long messageId, @Param("x") Long linkId);

	@Query("select l from Link l where l.message.messageId = :x")
	public List<Link> getAllLinks(@Param("x") Long messageId);

}
