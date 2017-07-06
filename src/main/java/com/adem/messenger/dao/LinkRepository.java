package com.adem.messenger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adem.messenger.entities.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
